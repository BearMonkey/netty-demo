package org.monkey.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {

        /*File file = new File(".");
        String[] files = file.list();
        for (String f : files) {
            System.out.println(f);
        }*/


        FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\1.txt");
        FileChannel readChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\resources\\2.txt");
        FileChannel writeChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        while (true) {

            // 此处有一个重要操作, 清空buffer
            byteBuffer.clear();

            int read = readChannel.read(byteBuffer);
            System.out.println("read=" + read);
            // 读完了
            if (read == -1) {
                break;
            }
            // buffer的写转变成读
            byteBuffer.flip();
            // 江南buffer中的数据写入到writeChannel
            writeChannel.write(byteBuffer);
        }

        // 关闭相关的IO流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
