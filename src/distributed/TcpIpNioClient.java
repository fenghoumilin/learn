package distributed;

import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class TcpIpNioClient {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            //设置为非阻塞模式
            channel.configureBlocking(false);
            //



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
