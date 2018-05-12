package patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.*;
import static patterns.Combinators.*;

class TestFunctional {

  @Test void it_should_allow_fp() {
    var xs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    var isOdd = new Predicate<Integer>() {
      @Override public Boolean apply(Integer x) {
        return x % 2 != 0;
      }
    };
    var squared = new Function<Integer, Integer>() {
      @Override public Integer apply(Integer x) {
        return x * x;
      }
    };
    var sum = new BiFunction<Integer, Integer, Integer>() {
      @Override public Integer apply(Integer x, Integer y) {
        return x + y;
      }
    };

    int sumOfSquaredOddNumbers = reduce(sum, 0, map(squared, filter(isOdd, xs)));
    assertEquals(1*1 + 3*3 + 5*5 + 7*7 + 9*9, sumOfSquaredOddNumbers);
  }

  @Test void it_should_allow_fp_shorthand() {
    var xs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Predicate<Integer> isOdd = x -> x % 2 != 0;
    Function<Integer, Integer> squared = x -> x * x;
    BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;

    int sumOfSquaredOddNumbers = reduce(sum, 0, map(squared, filter(isOdd, xs)));
    assertEquals(1*1 + 3*3 + 5*5 + 7*7 + 9*9, sumOfSquaredOddNumbers);
  }
}
