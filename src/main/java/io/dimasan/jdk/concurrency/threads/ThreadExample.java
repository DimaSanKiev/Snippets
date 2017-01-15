package io.dimasan.jdk.concurrency.threads;

public class ThreadExample extends Thread {
    private int count = 0;

    @Override
    public void run() {
        System.out.println("Thread started.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("In Thread count is " + count);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread terminated.");
    }

    public static void main(String[] args) {
        ThreadExample instance = new ThreadExample();
        instance.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
