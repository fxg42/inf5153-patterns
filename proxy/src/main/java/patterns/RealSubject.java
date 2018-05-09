package patterns;

public class RealSubject implements Subject {
  
  public int request(int x) {
    return x * x;
  }
}

