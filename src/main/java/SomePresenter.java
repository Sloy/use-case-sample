public class SomePresenter extends BasePresenter {

    private final MyUseCase retrieveImportantThing;

    public SomePresenter(MyUseCase retrieveImportantThing, UseCaseExecutor useCaseExecutor) {
        super(useCaseExecutor);
        this.retrieveImportantThing = retrieveImportantThing;
    }


    public void onSomethingClick() {
        create(retrieveImportantThing)
                .withArgs("data")
                .onSuccess((response) -> {
                    // Tadaaaaa
                })
                .onError(error -> {
                    // Boooo
                })
                .execute();
    }


    public void onSomethingElseClick() {
        create(retrieveImportantThing)
                .withArgs("data")
                .execute(response -> {
                            // Tadaaaaa
                        },
                        error -> {
                            // Boooo
                        });
    }

    public void onMoreClicks() {
        retrieveImportantThing.withArgs("data")
                .on(asyncThread())
                .execute(response -> {
                            // Tadaaaaa
                        },
                        error -> {
                            // Boooo
                        });
    }


}
