package zuoye;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Library {
    private int num = 1;
    private static Library library = new Library();
    //new一个锁对象
    private Lock lock = new ReentrantLock();

    //借书，因为还书满后直接退出终止线程
    private Condition lender = lock.newCondition();

    //书最大数
    final int  MAX_SIZE = 3;

    //还书---
    public void back(){
        //锁住
        lock.lock();
        try {
            if (num == MAX_SIZE){
                System.out.println(Thread.currentThread().getName()+"想要还书，但是已经满了，无需还书");
                return;
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"归还一本书，现在有"+num);
            //唤醒借书等待
            lender.signalAll();
        }finally {
            //释放锁
            lock.unlock();
        }
    }

    public  void lend(){
        lock.lock();
        try {
            //被唤醒后还要判断是否为0，所以用while，避免直接进行下一步有负数
            while (num == 0) {
                try {
                    System.out.println(Thread.currentThread().getName()+",对不起，没有书了");
                    //等待被唤醒，并释放锁
                    lender.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"借走一本书，现在有"+num);
        }finally {
            lock.unlock();
        }
    }



    //创建5个借书和5个还书线程
    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.lend();
        }
    },"借书者-1");
    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.lend();
        }
    },"借书者-2");
    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.lend();
        }
    },"借书者-3");
    static Thread t4 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.lend();
        }
    },"借书者-4");
    static Thread t5 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.lend();
        }
    },"借书者-5");




    static Thread t6 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.back();
        }
    },"还书者-1");
    static Thread t7 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.back();
        }
    },"还书者-2");
    static Thread t8 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.back();
        }
    },"还书者-3");
    static Thread t9 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.back();
        }
    },"还书者-4");
    static Thread t10 = new Thread(new Runnable() {
        @Override
        public void run() {
            library.back();
        }
    },"还书者-5");

    public static void main(String[] args) {
        //启动这些线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
