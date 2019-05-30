package org.zhezii.se.thread;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/30
 */
public class Demo {

    public static void main(String[] args) {

        ThreadTest t1 = new ThreadTest(100);
        ThreadTest t2 = new ThreadTest(100);

        t1.start();
        t2.start();
    }
}
