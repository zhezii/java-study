package org.zhezii.se.thread;

import java.util.concurrent.FutureTask;

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

        ImplentsCallable thread3 = new ImplentsCallable();
        FutureTask futureTask = new FutureTask(thread3);
        Thread thread4 = new Thread(futureTask);
        try {
            Object o = futureTask.get();
        } catch (Exception e) {
            e.getMessage();
        }

        thread4.start();
    }
}
