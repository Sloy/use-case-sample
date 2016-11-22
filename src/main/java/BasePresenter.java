public class BasePresenter {

    private final UseCaseExecutor useCaseExecutor;

    public BasePresenter(UseCaseExecutor useCaseExecutor) {
        this.useCaseExecutor = useCaseExecutor;
    }

    public <T> T create(T useCase) {
        return null;
    }

    protected Thread asyncThread() {
        return null;
    }
}
