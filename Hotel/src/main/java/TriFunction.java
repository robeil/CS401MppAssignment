//todo: Make this interface a valid definition for a function that accepts 3 inputs and return a single value
@FunctionalInterface
public interface TriFunction<T,U,V,R>{
    R apply(T t,U u,V v);
}
