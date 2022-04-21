//todo: Make this interface a valid definition for a function that accepts 4 inputs and return a single value
@FunctionalInterface
public interface QuadFunction<T,U,V,O,R>{
    R apply(T t,U u,V v,O o);
}
