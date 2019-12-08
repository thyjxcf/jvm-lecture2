package com.shengsiyuan.jvm.memory;
/*
方法区产生内存溢出错误 ，设定元空间固定内存大小 ，元空间不会自动扩展，就会内存溢出了
在运行期动态生成类 ，
默认元空间大小21m
如果超过21m或者到达21m，元空间虚拟机会进行垃圾回收。如果元空间还是不够，他会进行动态扩容
扩容的上限就是物理空间上限。利用的就是操作系统原生内存。

动态代理 有一个很大的约束，只能对接口进行代理，如果我们的目标bean没有实现接口，动态代理是实现不了aop的

cglib z在运行期生成目标类的子类，子类又可以调用父类相应的方法
在调用父类的方法前与后插入自己的一些逻辑，进一步实现AOP

-XX:MaxMetaspaceSize=200m
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Designed By luf
 *
 * @author luf
 * @date 2019/12/8 17:39
 */
public class MyTest4 {
    public static void main(String[] args) {
        for( ; ; ){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy)->proxy.invokeSuper(obj,args1));
            System.out.println("hello world");
            enhancer.create();
            //这个不断创建MyTest4的子类 将类型信息 放入 到元空间当中 。
        }
    }
}
