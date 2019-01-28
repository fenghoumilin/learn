package distributed;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpBioServer {

    public static void main(String[] args) {
        try {
            /**
             * 思路：创建服务端
             * 1、创建 SeverSocket 客户端对象
             * 2、获取 Socket 流
             * 3、通过 Socket，读取客户端发过来的需要转换的数据
             * 4、显示在控制台上
             * 5、将数据转换成大写返回给客户端
             */

            // 1、创建 SeverSocket 对象
            ServerSocket ss = new ServerSocket(10004);

            // 2、获取 Socket 对象
            Socket s = ss.accept();

            // 获取 IP 地址
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + "......connected");

            // 3、获取 Socket 读取流，并装饰
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // 4、获取 Socket 的输出流，并装饰
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String line = null;
            while ((line = bufIn.readLine()) != null) {
                System.out.println(line);
                out.println(line.toUpperCase());
            }

            s.close();
            ss.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
