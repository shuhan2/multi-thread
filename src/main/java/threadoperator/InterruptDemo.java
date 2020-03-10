package threadoperator;

public class InterruptDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(new InterruptMessage());
    thread1.start();
    Thread.sleep(500);
    thread1.interrupt();
    System.out.println(thread1.getState());
  }

}
