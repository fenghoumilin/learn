package distributed;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class TcpIpNioServer {
    public static void main(String[] args) {
        try {
            //用于监听端口及监听连接事件
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8080));
            //设置为非阻塞状态
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            //向channel中注册感兴趣事件
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            Handler handler = new Handler();
            while (true) {
                //监听至感兴趣事件发生，如果发生则返回数大于0，否则等于0
                if (selector.select(3000) == 0) {
                    System.out.println("通道阻塞中");
                    continue;
                }
                System.out.println("开始处理请求");
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    try {
                        SelectionKey key = iterator.next();
                        if(key.isAcceptable()){
                            handler.handlerAccept(key);
                        }
                        if(key.isReadable()){
                            handler.handlerRead(key);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        iterator.remove();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler {
        private int bufferSize = 1024;
        private String loackCharset = "UTF-8";

        public Handler() {
        }

        public Handler(int bufferSize) {
            this(bufferSize, null);
        }

        public Handler(String loackCharset) {
            this(-1, loackCharset);
        }

        public Handler(int bufferSize, String loackCharset) {
            if (bufferSize > 0)
                this.bufferSize = bufferSize;
            if (loackCharset != null)
                this.loackCharset = loackCharset;
        }

        public void handlerAccept(SelectionKey key) throws IOException {
            //建立连接，监听事件及操作读写
            SocketChannel accept = ((ServerSocketChannel) key.channel()).accept();
            accept.configureBlocking(false);
            accept.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handlerRead(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel)key.channel();
            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
            byteBuffer.clear();
            if(channel.read(byteBuffer)==-1){
                channel.close();
            }else{
                byteBuffer.flip();
                String receiveString = Charset.forName(loackCharset).newDecoder().decode(byteBuffer).toString();
                System.out.println("received from client : "+receiveString);
                StringBuffer sb=new StringBuffer("HTTP/1.1 200 OK\r\n");
                sb.append("Content-Type: text/html;charset=UTF-8\r\n");
                sb.append("Access-Control-Allow-Origin: *\r\n");
                sb.append("Access-Control-Allow-Headers: GET,POST,PUT,DELETE\r\n");
                sb.append("\r\n");
                sb.append("<html><head><title>测试form</title><head><body><form method='post'><table><tr><td>姓名</td><td><input type='text' name='name'/></td></tr>" +
                        "<tr><td colspan='2'><input type='submit' value='提交'/></td></tr></table></form>");
//                String sendString ="receivedd data： "+receiveString;
                ByteBuffer wrap = ByteBuffer.wrap(sb.toString().getBytes(loackCharset));
                channel.write(wrap);
                channel.close();

            }


        }
    }
}
