package com.shengsiyuan.jvm.memory;

/**
 * Designed By luf
 *
 * @author luf
 * @date 2019/12/8 16:58
 */
class ClassA{

    public void hello() {
        System.out.println("hello");
    }
}
class ClassB{
    public void world(){
        System.out.println("world");
    }
}
public class DeadLock {

    public void test1(){
        synchronized (ClassA.class) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ClassB.class) {
                System.out.println("dfsdf");

            }
        }
    }
    public void test2(){
        synchronized (ClassB.class) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ClassA.class) {
                System.out.println("dfsdf");

            }
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            new DeadLock().test1();

        }).start();
        new Thread(()->{
            new DeadLock().test2();
        }).start();
    }


}
