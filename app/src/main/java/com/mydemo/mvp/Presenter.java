package com.mydemo.mvp;

/**
 * Created by zh on 2018/3/22.
 */

public class Presenter{
    private MainView mainView;
    private Model model=new Model();

    public Presenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void presenter(String a){
        String s=model.doModel("hi",a);
        mainView.setView(s);
    }
}
