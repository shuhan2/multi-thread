package lock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {

  ReentrantLock lock = new ReentrantLock();
  private int counter = 0;

  public void add() {
    //Acquires the lock
    lock.lock();
    try {
//      System.out.println(Thread.currentThread() +" Add try: " + lock.isHeldByCurrentThread());
      counter++;
    } finally {
      //release this lock
      lock.unlock();
//      System.out.println(Thread.currentThread() +" Add finally: " + lock.isHeldByCurrentThread());

    }
  }

  public int getCounter() {
   lock.lock();
    try {
      return counter;
    } finally {
      lock.unlock();
    }
  }


}
