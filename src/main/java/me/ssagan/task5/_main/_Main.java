package me.ssagan.task5._main;

public class _Main {
    public static void main(String[] args) {
        //Напишите программу на Java, которая создает два потока: "Поток 1" и "Поток 2".
        // Каждый поток должен выводить своё имя в консоль 10 раз с интервалом в 1 секунду.
        // При этом "Поток 1" должен начать свою работу первым и закончить последним,
        // а "Поток 2" - наоборот: начать последним и закончить первым.
        TwoThreads twoThreads = new TwoThreads();
        twoThreads.runThreads();
    }
}

class TwoThreads {
    Boolean isFirstThreadStarted = false;
    Boolean isLastThreadFinished = false;

    public void runThreads() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i == 10) {
                    synchronized (lock2) {
                        if (!isLastThreadFinished) {
                            try {
                                lock2.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " - " + i);
                if (i == 1) {
                    synchronized (lock1) {
                        isFirstThreadStarted = true;
                        lock1.notify();
                    }
                }
            }
        }, "Thread 1");
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i == 1) {
                    synchronized (lock1) {
                        if (!isFirstThreadStarted) {
                            try {
                                lock1.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("   " + Thread.currentThread().getName() + " - " + i);
                if (i == 10) {
                    synchronized (lock2) {
                        isLastThreadFinished = true;
                        lock2.notify();
                    }
                }
            }
        }, "Thread 2");
        thread1.start();
        thread2.start();
    }
}
