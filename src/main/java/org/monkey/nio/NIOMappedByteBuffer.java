package org.monkey.nio;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明
 * 1. MappedByteBuffer可以让文件直接在内存（堆外内存）中修改，即操作系统不需要拷贝一次
 */
public class NIOMappedByteBuffer {

    public static void main(String[] args) throws IOException {
        String resourcePath = "src" + File.separator + "main" + File.separator + "resources";
        RandomAccessFile randomAccessFile = new RandomAccessFile(resourcePath + File.separator + "1.txt", "rw");

        // 获取对应的通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        /*
        参数1： FileChannel.MapMode.READ_WRITE  使用读写模式
        参数2： 0 可以直接修改的起始位置
        参数3： 5 映射到内存的大小，即将1.txt的多少个字节映射到内存，即可修改的下标范围是  [0-5)

        MappedByteBuffer 实际类型是
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'A');
        mappedByteBuffer.put(1, (byte) 's');
        mappedByteBuffer.put(2, (byte) 'h');
        mappedByteBuffer.put(3, (byte) 'e');

        randomAccessFile.close();
        System.out.println("修改成功！！");













































    }
}
