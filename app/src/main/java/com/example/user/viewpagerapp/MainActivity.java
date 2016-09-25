package com.example.user.viewpagerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button viewpager_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager_btn = (Button) findViewById(R.id.viewpager_btn);
        viewpager_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.viewpager_btn:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ViewPagerActivity.class);
                startActivity(intent);
                break;

            default:
                break;

        }
    }
}
