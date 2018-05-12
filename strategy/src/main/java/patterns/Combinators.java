package patterns;

import java.util.*;

public class Combinators {

  public static <T, U> List<U> map(Function<T, U> f, List<T> xs) {
    var ys = new ArrayList<U>();
    for (T x : xs) {
      ys.add(f.apply(x));
    }
    return ys;
  }

  public static <T> List<T> filter(Predicate<T> p, List<T> xs) {
    var ys = new ArrayList<T>();
    for (T x : xs) {
      if (p.apply(x)) {
        ys.add(x);
      }
    }
    return ys;
  }

  public static <T, U> U reduce(BiFunction<U, T, U> bf, U init, List<T> xs) {
    U acc = init;
    for (T x : xs) {
      acc = bf.apply(acc, x);
    }
    return acc;
  }
}
