package threadoperator;

public class JoinDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new JoinMessage());
    thread.start();
    System.out.println("DeadLock Thread");
  }
}
