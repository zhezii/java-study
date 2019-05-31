package org.zhezii.se.thread;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/30
 */
public class Demo {

    public static void main(String[] args) {

        Ticket t1 = new Ticket("A");
        Ticket t2 = new Ticket("B");
        t1.start();
        t2.start();

    }
}
