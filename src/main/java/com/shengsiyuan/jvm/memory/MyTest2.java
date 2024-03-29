package com.shengsiyuan.jvm.memory;

/*
   虚拟机栈溢出 。

 */
/**
 * Designed By luf
 *
 * @author luf
 * @date 2019/12/8 15:19
 */
public class MyTest2 {
    private int length;

    public int getLength() {
        return length;
    }
    public void test() {
        length++;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }
    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Throwable throwable) {
            System.out.println(myTest2.getLength());
            throwable.printStackTrace();
        }
    }
}
