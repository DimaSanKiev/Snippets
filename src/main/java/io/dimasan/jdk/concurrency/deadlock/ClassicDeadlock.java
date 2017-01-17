package io.dimasan.jdk.concurrency.deadlock;

public class ClassicDeadlock {
    private static final Thread[] threads = new Thread[2];

    public static void main(String[] args) {
        threads[0] = new Thread(() -> {
            try {
                System.out.println("#0 join to #1");
                threads[1].join();
            } catch (InterruptedException e) {/* NOOP */}
        });

        threads[1] = new Thread(() -> {
           try {
               System.out.println("#1 join to #0");
               threads[0].join();
           } catch (InterruptedException e) {/* NOOP */}
        });

        threads[0].start();
        threads[1].start();
    }
}
