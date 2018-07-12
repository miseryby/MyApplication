package com.example.a235.myapplication;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a235.myapplication.Page.BasePage;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    private List<View> mViewList;
    private ViewPager vp;
    private RadioGroup rg;
    private static final String[] CONTENT = new String[] { "Recent", "Artists", "Albums", "Songs", "Genres","Recent", "Artists", "Albums", "Songs", "Genres" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout );
        vp =(ViewPager) findViewById( R.id.vp );
        rg =findViewById( R.id.rg );
        setView();

        MyAdapter myAdapter =new MyAdapter();
      vp.setAdapter( myAdapter );
        //把viewpage和TabPageIndicator关联
        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager( vp );
//      rg.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
//          @Override
//          public void onCheckedChanged(RadioGroup radioGroup, int i) {
//              switch (i){
//                  case R.id.btn1:
//                      vp.setCurrentItem( 0 ,false);
//                      break;
//                  case R.id.btn2:
//                      vp.setCurrentItem( 1 ,false);
//                      break;
//                  case R.id.btn3:
//                      vp.setCurrentItem( 2,false );
//                      break;
//                  case R.id.btn4:
//                      vp.setCurrentItem( 3,false );
//                      break;
//              }
//          }
//      } );
    }
    private  void setView(){
        mViewList =new ArrayList<>(  );
        View v1 = View.inflate( MainActivity.this,R.layout.view1,null );
        View v2 = View.inflate( MainActivity.this,R.layout.view2,null );
        View v3 = View.inflate( MainActivity.this,R.layout.view3,null );
        View v4 = View.inflate( MainActivity.this,R.layout.view4,null );
        mViewList.add( v1 );
        mViewList.add( v2);
        mViewList.add( v3 );
        mViewList.add( v4 );
    }
    private class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return CONTENT.length;//告诉viewpage，我有多少条数据，要加载
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;//官方推荐写法
        }

        /**
         * 页签显示数据的方法
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //先使每页page上显示text文本
            // 本page要展示的内容。替换掉Fragmenlayout那张白纸。 改变子类自己的界面数据与样式。暂时先用textview代表整块view
            TextView textView = new TextView(MainActivity.this);
            textView.setText(CONTENT[position]);//为每一页加载的page设置显示的内容
            textView.setTextSize(25);
            textView.setGravity( Gravity.CENTER);
            textView.setTextColor( Color.GREEN);

            //别忘记把view添加到page里面
            container.addView(textView);
            return textView;

        }

    }

}
