package com.example.a235.myapplication.Page;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.example.a235.myapplication.R;

public class BasePage {
    public View mRootView;
    public Context context;
    public FrameLayout flContent;

    public BasePage(Context context) {
        this.context = context;
        mRootView= initView();

    }

    /**
     * 初始化视图
     * @return
     */
    public View initView() {
        View view = View.inflate(context,R.layout.layout,null);

        return view;
    }

    /**
     * 初始化数据
     */
    public void iniData(){

    }
}