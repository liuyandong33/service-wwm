package build.dream.wwm.functions;

@FunctionalInterface
public interface SuppressThrowNoReturnFunction {
    void call() throws Exception;
}
