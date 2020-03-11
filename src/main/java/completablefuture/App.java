package completablefuture;

public class App {

  public static void main(String[] args) {
    PersonService service=  new PersonService(new AddressRepository(), new EmailRepository());
    service.getPersonByFuture();  //1045724019
    service.getPerson();       //2006186011
  }

}
