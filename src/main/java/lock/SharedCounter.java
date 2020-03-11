package lock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {

  ReentrantLock lock = new ReentrantLock();
  private int counter = 0;

  public void add() {
    //Acquires the lock
    lock.lock();
    try {
      System.out.println(Thread.currentThread() +" Add try: " + lock.isHeldByCurrentThread());
      counter++;
    } finally {

      //release this lock
      lock.unlock();
      System.out.println(Thread.currentThread() +" Add finally: " + lock.isHeldByCurrentThread());

    }
  }

  public int getCounter() {

    try {
//      lock.lock();
      System.out.println(Thread.currentThread() +" Get try: " + lock.isHeldByCurrentThread());
      return counter;
    } finally {
//      lock.unlock();
      System.out.println(Thread.currentThread() +" Get finally: " + lock.isHeldByCurrentThread());
    }
  }


}
