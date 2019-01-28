package distributed;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpIpBioClient {
    public static void main(String[] args) {
        try {
            /**
             * 思路：创建客户端
             * 1、创建 Socket 客户端对象
             * 2、获取键盘录入的数据
             * 3、将录入的信息发送给 Socket 输出流
             * 4、读取服务端的数据并返回的大写数据
             */

            // 1、创建 Socket 客户端对象
            Socket s = new Socket(InetAddress.getLocalHost(), 10004);

            // 2、获取键盘录入
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

            // 3、Socket 输出流
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            // 4、Socket 输入流，读取服务端的数据并返回的大写数据
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String line = null;

            while ((line = bufr.readLine()) != null) {

                if ("over".equals(line))
                    break;
                //向服务端输出数据
                out.println(line);

                // 读取服务端返回的一行大写数据
                String upperStr = bufIn.readLine();
                System.out.println(upperStr);
            }
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
