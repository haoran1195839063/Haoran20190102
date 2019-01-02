package haoran.bwie.com.haoran20190102.presenter;

import com.google.gson.Gson;

import haoran.bwie.com.haoran20190102.bean.MyBeam;
import haoran.bwie.com.haoran20190102.callback.MyCallBack;
import haoran.bwie.com.haoran20190102.model.ModelImpl;
import haoran.bwie.com.haoran20190102.view.View;

public class Presenter {
    private ModelImpl model;
    private View view;

    public Presenter(View view) {
        this.view = view;
        model = new ModelImpl();
    }

    public void login(String url) {
        model.ModelInter(url, new MyCallBack() {
            @Override
            public void success(String success) {
                Gson gson = new Gson();
                MyBeam myBeam = gson.fromJson(success, MyBeam.class);
                view.success(myBeam);
            }

            @Override
            public void error(String error) {
                view.error(error);
            }
        });
    }
}
