package lock;

import java.util.concurrent.locks.ReentrantLock;

public class AddMinusCounter {

  ReentrantLock lock1 = new ReentrantLock();
  ReentrantLock lock2 = new ReentrantLock();
  private int counter = 0;

  public synchronized void add() {
//    lock1.lock();
    try {
      counter++;
    } finally {
//      lock1.unlock();
    }

  }

  public synchronized void minus() {
//    lock1.lock();
    try {
      counter--;
    } finally {
//      lock1.unlock();

    }
  }

  public int getCounter() {

    try {
      return counter;
    } finally {
    }
  }

}
