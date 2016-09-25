package com.example.user.viewpagerapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/9/25.
 */

public class ViewPagerActivity extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    private List<View> views;
    private int[] guideimages = {R.drawable.guide1,R.drawable.guide2,R.drawable.guide3,R.drawable.guide4};

    private ImageView[] points;
    private LinearLayout linearLayout;

    private int currentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        views = new ArrayList<View>();
        for (int i:guideimages){
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(i);
            imageView.setLayoutParams(layoutParams);
            views.add(imageView);
        }
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(views);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout_points);

        points = new ImageView[guideimages.length];
        for (int i=0;i<linearLayout.getChildCount();i++){
            points[i] = (ImageView)linearLayout.getChildAt(i);
            points[i].setImageResource(R.drawable.points_normal);

        }
        currentposition =0;
        points[currentposition].setImageResource(R.drawable.points_select);


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentposition = position;
        for (int i=0;i<linearLayout.getChildCount();i++){
            points[i] = (ImageView)linearLayout.getChildAt(i);
            points[i].setImageResource(R.drawable.points_normal);

        }
        points[position].setImageResource(R.drawable.points_select);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
