package patterns;

public interface Predicate<T> extends Function<T, Boolean> {
  public Boolean apply(T t);
}
