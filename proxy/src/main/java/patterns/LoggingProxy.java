package patterns;

public class LoggingProxy implements Subject {
  
  private Subject next;

  public LoggingProxy(Subject next) {
    this.next = next;
  }

  public int request(int x) {
    System.out.printf("Calling with param [%d]\n", x);
    var returnValue = next.request(x);
    System.out.printf("Got return value [%d]\n", returnValue);
    return returnValue;
  }
}


