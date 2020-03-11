package synch;

import java.util.concurrent.locks.ReentrantLock;

public class SumClass {
  ReentrantLock lock = new ReentrantLock();
  private int sum = 0;

  public void calculate() {
    setSum(getSum() + 1);
  }

  public int getSum() {
    lock.lock();
    try {
      return sum;
    } finally {
      lock.unlock();;
    }

  }

  public void setSum(int sum) {
    lock.lock();
    try {
      this.sum = sum;
    } finally {
      lock.unlock();
    }

  }
}
