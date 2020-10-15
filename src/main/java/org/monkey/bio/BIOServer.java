package org.monkey.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 线程池机制
        // 思路
        // 1.创建线程池
        // 2.如果有客户端连接, 就创建一个线程与之通讯(单独写一个方法)

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            System.out.println("线程信息 id=" + Thread.currentThread().getId()
                    + ", name=" + Thread.currentThread().getName());
            // 监听,等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            // 创建一个线程
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }


    /**
     * 编写一个handler发表过法和客户端通讯
     *
     * @param socket socket
     */
    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();

            // 循环读取客户段发送的数据
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println("线程信息 id=" + Thread.currentThread().getId()
                            + ", name=" + Thread.currentThread().getName());
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                    System.out.println("连接关闭");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}