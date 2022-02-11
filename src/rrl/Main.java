package rrl;

import pack.Tool;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Res res = new Res();
        Thread t1 = new Thread(() -> {
            lock.lock();
            for(int i=0; i< 10; i++){
                System.out.println("W" + res.n++);
                Tool.sleepThis(1000);
            }
            lock.unlock();
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            for(int i=0; i< 10; i++){
                System.out.println("R" + res.n--);
                Tool.sleepThis(1000);
            }
            lock.unlock();
        });
        t1.start();
        t2.start();

    }
}
