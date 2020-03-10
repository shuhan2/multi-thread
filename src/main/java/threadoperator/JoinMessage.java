package threadoperator;

public class JoinMessage implements Runnable {

  @Override
  public void run() {
    String importantInfo[] = {
        "Sleep",
        "Interrupt",
        "Join"
    };

    for (String s : importantInfo) {
      //Pause for 2 seconds
      Thread thread = Thread.currentThread();
      try {
        Thread.sleep(2000);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(s);
    }
  }
}
