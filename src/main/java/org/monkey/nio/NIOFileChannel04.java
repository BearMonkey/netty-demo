package org.monkey.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        // 创建相关的流
        String resourcePath = "src" + File.separator + "main" + File.separator + "resources";

        FileInputStream fileInputStream = new FileInputStream(resourcePath + File.separator + "source.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(resourcePath + File.separator + "dest.jpg");

        // 获取各个流对应的fileChannel
        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();

        // 使用transferFrom完成拷贝
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

        // 关闭相关的通道和流
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
