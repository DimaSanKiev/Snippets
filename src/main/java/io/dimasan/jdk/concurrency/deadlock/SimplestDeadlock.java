package io.dimasan.jdk.concurrency.deadlock;

public class SimplestDeadlock {
    /* Thread.currentThread() returns a reference on the current thread (on main thread).
    And we join() it, but it cannot die because it waits for its death. Deadlock. */
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
    }
}
