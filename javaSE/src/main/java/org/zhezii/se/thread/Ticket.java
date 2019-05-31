package org.zhezii.se.thread;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/31
 */
public class Ticket extends Thread {
    static int count = 100;

    public Ticket(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this){
        while (count > 0) {

                System.out.println(getName()+"正在售卖第"+count+"张票");
                count --;
            }
        }
    }
}
