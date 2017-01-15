package io.dimasan.jdk.concurrency.threads;

public class RunnableThreadExample implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        System.out.println("RunnableThread started.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("In RunnableThread count is " + count);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("RunnableThread interrupted.");
        }
        System.out.println("RunnableThread terminated.");
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
