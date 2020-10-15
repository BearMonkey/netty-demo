package org.monkey.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello file channel!";

        String resourcePath = "src" + File.separator + "main" + File.separator + "resources";

        String targetPath = resourcePath + File.separator + "file01.txt";

        // 创建一个输出流 --> channel
        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);

        // 实际的channel是FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将String放入到ByteBuffer
        byteBuffer.put(str.getBytes());

        // 读变为写，flip进行反转
        byteBuffer.flip();

        // 将bytebuffer的数据写入到fileChannel
        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }
}
