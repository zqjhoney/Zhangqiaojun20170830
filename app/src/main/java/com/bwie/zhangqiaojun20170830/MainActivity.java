package com.bwie.zhangqiaojun20170830;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.zhangqiaojun20170830.adapter.MyAdapter;
import com.bwie.zhangqiaojun20170830.bean.Bean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import view.xlistview.XListView;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.xlv)
    XListView xlv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initdata();

    }

    private void initdata() {
        RequestParams params=new RequestParams(API.POST_URL);
        params.addBodyParameter("key",API.KEY);
        params.addBodyParameter("type",API.TYPE);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {//成功返回的数据
                System.out.println("====="+result);
                Gson gson=new Gson();
                Bean bean = gson.fromJson(result, Bean.class);
                List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                MyAdapter adapter=new MyAdapter(MainActivity.this, (ArrayList<Bean.ResultBean.DataBean>) data);

                xlv.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
