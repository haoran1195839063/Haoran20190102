package haoran.bwie.com.haoran20190102;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import haoran.bwie.com.haoran20190102.adapter.MyAdapter;
import haoran.bwie.com.haoran20190102.bean.MyBeam;
import haoran.bwie.com.haoran20190102.presenter.Presenter;
import haoran.bwie.com.haoran20190102.view.View;

public class MainActivity extends AppCompatActivity implements View {
    private String url = "https://www.zhaoapi.cn/home/getHome";
    private GridView gridview;
    private List<MyBeam.DataBean.MiaoshaBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Presenter presenter = new Presenter(this);
        presenter.login(url);
    }

    @Override
    public void success(Object data) {
        MyBeam myBeam = (MyBeam) data;
        list.add(myBeam.getData().getMiaosha());
        gridview.setAdapter(new MyAdapter(list, this));
    }

    @Override
    public void error(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        gridview = (GridView) findViewById(R.id.gridview);
    }
}
