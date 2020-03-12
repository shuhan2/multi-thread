package completablefuture.accept;

public class EmailRepository {
  public String provideEmail1() {
    System.out.println(Thread.currentThread());

    return "email1@example.com";
  }

  public String provideEmail2() {
    System.out.println(Thread.currentThread());



    return "@example.com";
  }
}
