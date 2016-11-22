public class BasePresenter {

    private final UseCaseExecutor useCaseExecutor;

    public BasePresenter(UseCaseExecutor useCaseExecutor) {
        this.useCaseExecutor = useCaseExecutor;
    }

    public <T extends UseCase<?, ?>> T create(T useCase) {
        useCase.on(asyncThread());
        return null;
    }

    public <T extends UseCase<?, ?>> T async(T useCase) {
        useCase.on(asyncThread());
        return null;
    }

    protected Thread asyncThread() {
        return null;
    }
}
