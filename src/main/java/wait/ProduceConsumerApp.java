package wait;


public class ProduceConsumerApp {

  public static void main(String[] args) {

    new ProduceConsumerService().run();
//    long l = System.nanoTime();
//    new SimpleService().run();
//    System.out.println(System.nanoTime() - l);
  }

}
