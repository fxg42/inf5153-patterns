package patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ProxyTest {

  @Test void it_should_log_call() {
    var real = new RealSubject();
    var subject = new LoggingProxy(real);
    var returnValue = subject.request(5);
    assertEquals(25, returnValue);
  }
}
