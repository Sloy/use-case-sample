import java.util.function.Consumer;

public abstract class UseCase<P, R> {

    private Consumer<R> callback;
    private Consumer<Exception> errorCallback;
    private P parameters;

    UseCase<P, R> withArgs(P parameters) {
        this.parameters = parameters;
        return this;
    }

    UseCase<P, R> onSuccess(Consumer<R> callback) {
        this.callback = callback;
        return this;
    }

    UseCase<P, R> onError(Consumer<Exception> errorCallback) {
        this.errorCallback = errorCallback;
        return this;
    }

    void notifySuccess(R response) {
        //TODO async
        callback.accept(response);
    }

    void notifyError(Exception error) {
        //TODO async
        errorCallback.accept(error);

    }

    public MyUseCase on(Thread thread) {
        //TODO async
        return null;
    }

    void execute() {
        //TODO async
        this.onRun(parameters);
    }

    void execute(Consumer<R> callback, Consumer<Exception> errorCallback) {
        // alias
        onSuccess(callback);
        onError(errorCallback);
        execute();
    }

    protected abstract void onRun(P parameters);
}
