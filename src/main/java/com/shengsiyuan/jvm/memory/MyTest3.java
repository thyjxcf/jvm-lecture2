package com.shengsiyuan.jvm.memory;

/*
    如果一个类 它是静态方法它是synchronized的 进入这个方法时持有的不是当前类所对应的对象的锁，当前类class对象的锁。
    这样不管类A有多少实例，都对应同一把锁。

 */
/**
 * Designed By luf
 *
 * @author luf
 * @date 2019/12/8 17:09
 */
public class MyTest3 {
    public static void main(String[] args) {
//        new Thread(()->{
//            A.method();
//        }).start();
//        new Thread(()->{
//            B.method();
//        }).start();
        new Thread(() -> A.method(), "Thread-A").start();
        new Thread(() -> B.method(), "Thread-B").start();
    }
}

class A{

    public static synchronized void method() {
        System.out.println("method from A");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B.method();
    }
}
class B{
    public static synchronized void method() {
        System.out.println("method from B");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A.method();
    }
}
