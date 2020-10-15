package org.monkey.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        // 举例说明buffer的使用（简单说明）
        // 创建buffer，大小年为5，即可以存放5个int类型数据
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 向buffer中存放数据
        // intBuffer.put(10);
        // intBuffer.put(11);
        // intBuffer.put(12);
        // intBuffer.put(13);
        // intBuffer.put(14);

        // capacity() 容量
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // 取数据
        // flip() 读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            // get() 会自动后移指针
            System.out.println(intBuffer.get());
        }

    }
}
