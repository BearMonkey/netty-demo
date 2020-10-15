package org.monkey.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {

        String resourcePath = "src" + File.separator + "main" + File.separator + "resources";

        String targetPath = resourcePath + File.separator + "file01.txt";

        // 创建文件的输入流
        File file = new File(targetPath);

        FileInputStream fileInputStream = new FileInputStream(file);

        // 通过fileInputStream获取对饮的fileChannel
        FileChannel fileChannel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 将通道的数据读入到buffer中
        fileChannel.read(byteBuffer);

        // 将缓冲取的字节转成字符串String
        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();


    }
}
