package com.bwie.zhangqiaojun20170830;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by 张乔君 on 2017/8/30.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initxutils();
        initImageloder();
    }

    private void initImageloder() {
        DisplayImageOptions opt=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .showImageOnLoading(R.drawable.ic_loading)
                .showImageOnFail(R.drawable.ic_error)
                .build();
        ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(opt)
                .build();

        ImageLoader.getInstance().init(con);
    }

    private void initxutils() {
        x.Ext.init(this);
        x.Ext.setDebug(false);//log打印数据
    }
}
