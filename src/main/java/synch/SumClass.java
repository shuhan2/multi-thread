package synch;

public class SumClass {
  private int sum = 0;

  public void calculate() {
    setSum(getSum() + 1);
  }

  public synchronized int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;

  }
}
