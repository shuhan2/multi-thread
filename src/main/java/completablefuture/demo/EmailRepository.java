package completablefuture.demo;

public class EmailRepository {
  public String provideEmail() {
    System.out.println(Thread.currentThread());

    return "email@example.com";
  }
}
