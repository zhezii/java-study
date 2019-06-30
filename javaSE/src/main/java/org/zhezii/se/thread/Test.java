package org.zhezii.se.thread;

/**
 * @author Zhou Wenzhe
 * @date 2019/7/1
 */
public class Test {

    public static void main(String[] args) {
        ExtendThread thread1 = new ExtendThread();
        thread1.start();

        ImplentsRunnable thread2 = new ImplentsRunnable();
        //真正的线程对象
        Thread thread = new Thread(thread2);
        thread.start();
    }
}
