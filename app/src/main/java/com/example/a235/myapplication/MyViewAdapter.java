package com.example.a235.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyViewAdapter extends PagerAdapter {
    private List<View> list;
    @Override
    public int getCount() {
        return  list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView( list.get( position ) );
        return  list.get( position );
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView(list.get( position ));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return o ==view;
    }

    MyViewAdapter(List<View> list){
        this.list = list;
    }
}
