package edu.fjbatresv.edutec.mvp.main;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainModel model;

    public MainPresenterImpl(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void textToUpper(String text) {
        view.cleanEditText();
        view.setButtonText("Publicado");
        String upper = model.textToUpper(text);
        view.setText(upper);
    }
}
