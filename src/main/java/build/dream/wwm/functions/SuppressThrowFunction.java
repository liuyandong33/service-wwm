package build.dream.wwm.functions;

@FunctionalInterface
public interface SuppressThrowFunction<T> {
    T call() throws Exception;
}
