package haoran.bwie.com.haoran20190102.model;

import haoran.bwie.com.haoran20190102.callback.MyCallBack;
import haoran.bwie.com.haoran20190102.util.OkhttpUtil;

public class ModelImpl implements Model {

    @Override
    public void ModelInter(String url, MyCallBack myCallBack) {
        OkhttpUtil okhttpUtil = new OkhttpUtil();
        okhttpUtil.getData(url, myCallBack);

    }

}
