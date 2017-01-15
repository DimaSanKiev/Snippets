package io.dimasan.jdk.concurrency.synchronization;

class MyClass extends Thread {
    private String name;
    private MyObject myObject;

    public MyClass(MyObject myObject, String name) {
        this.myObject = myObject;
        this.name = name;
    }

    @Override
    public void run() {
        myObject.foo(name);
    }
}

class MyObject {
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting");
            Thread.sleep(300);
            System.out.println("Thread " + name + ".foo(): ending");
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + ".foo(): interrupted");
        }
    }
}

class Main {
    public static void main(String[] args) {
        oneThread();
//        twoThreads();
    }

    /* Different references - both threads can call MyObject.foo() */
    private static void twoThreads() {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj2, "2");
        thread1.start();
        thread2.start();
    }

    /* Same reference to obj. Only one will be allowed to call foo, and the other will be forced to wait. */
    private static void oneThread() {
        MyObject obj = new MyObject();
        MyClass thread1 = new MyClass(obj, "1");
        MyClass thread2 = new MyClass(obj, "2");
        thread1.start();
        thread2.start();
    }
}
