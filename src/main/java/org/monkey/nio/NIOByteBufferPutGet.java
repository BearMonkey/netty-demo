package org.monkey.nio;

import java.nio.ByteBuffer;

public class NIOByteBufferPutGet {

    public static void main(String[] args) {
        // 创建一个buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        // 类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9L);
        buffer.putChar('皈');
        buffer.putShort((short) 4);

        // 反转
        buffer.flip();

        // 取出
        System.out.println("===========");
    }
}
