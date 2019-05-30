package org.zhezii.se.thread;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/30
 */
public class ThreadTest extends Thread {

    Integer i;

    public ThreadTest(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {

        synchronized (i){
            while (i > 0) {
                i --;
                System.out.println("还有"+i+"张票");
            }
        }
        super.run();
    }
}
