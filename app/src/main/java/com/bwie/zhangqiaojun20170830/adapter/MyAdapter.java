package com.bwie.zhangqiaojun20170830.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bwie.zhangqiaojun20170830.R;
import com.bwie.zhangqiaojun20170830.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by 张乔君 on 2017/8/30.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Bean.ResultBean.DataBean> list;
    private int atype=0;
    private int btype=1;
    private int typenum=2;


    public MyAdapter(Context context, ArrayList<Bean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){

            return atype;
        }else{
            return btype;
        }
    }

    @Override
    public int getViewTypeCount() {
        return typenum;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoldera holdera=null;
        ViewHolderb holderb=null;
        int type=getItemViewType(i);
        if(view==null){

            switch (type){
                case 0:
                    view=View.inflate(context, R.layout.atype,null);
                    holdera=new ViewHoldera();
                    holdera.a_iv=view.findViewById(R.id.a_iv);
                    holdera.a_net=view.findViewById(R.id.a_net);
                    holdera.a_time=view.findViewById(R.id.a_time);
                    holdera.a_title=view.findViewById(R.id.a_title);
                    view.setTag(holdera);
                    break;
                case 1:
                    view=View.inflate(context, R.layout.btype,null);
                    holderb=new ViewHolderb();
                    holderb.b_iv=view.findViewById(R.id.b_iv);
                    holderb.b_net=view.findViewById(R.id.b_net);
                    holderb.b_time=view.findViewById(R.id.b_time);
                    holderb.b_title=view.findViewById(R.id.b_title);
                    view.setTag(holderb);
                    break;
            }
        }else{
            switch (type){
                case 0:
                    holdera= (ViewHoldera) view.getTag();
                    break;
                case 1:
                    holderb= (ViewHolderb) view.getTag();
                    break;
            }
        }
        Bean.ResultBean.DataBean b=list.get(i);
        switch (type){
            case 0:
                holdera.a_title.setText(b.getTitle());
                holdera.a_net.setText(b.getAuthor_name());
                holdera.a_time.setText(b.getDate());
                ImageLoader.getInstance().displayImage(b.getThumbnail_pic_s(),holdera.a_iv);
                break;
            case 1:
                holderb.b_title.setText(b.getTitle());
                holderb.b_net.setText(b.getAuthor_name());
                holderb.b_time.setText(b.getDate());
                ImageLoader.getInstance().displayImage(b.getThumbnail_pic_s(),holderb.b_iv);
                break;
        }
        return view;
    }

    class ViewHoldera{
        ImageView a_iv;
        TextView a_title,a_net,a_time;
    }
    class ViewHolderb{
        ImageView b_iv;
        TextView b_title,b_net,b_time;
    }
}
