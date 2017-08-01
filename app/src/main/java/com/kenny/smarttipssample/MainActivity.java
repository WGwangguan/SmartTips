package com.kenny.smarttipssample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kenny.smarttips.Configuration;
import com.kenny.smarttips.SmartTips;
import com.kenny.smarttips.listener.RightImageClickListener;

public class MainActivity extends AppCompatActivity {

    static int i = 1;
    Configuration.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new Configuration.Builder();
        builder.setNotice(getString(R.string.notice))
                .setOutAnimation(android.R.anim.slide_out_right)
                .setRightImageClickListener(new RightImageClickListener() {
                    @Override
                    public void onRightClick() {
                        SmartTips.hideLast();
                    }
                });

    }

    public void show(View view) {
        StringBuilder strBuilder = new StringBuilder();
        for (int j = 0; j < 5; j++) {
            strBuilder.append("我是第" + i + "条通知");
        }
        i++;
        builder.setNotice(strBuilder.toString());
        SmartTips.makeNotice(this, builder.build()).show();
    }

    public void cancelAll(View view) {
        SmartTips.cancelAll();
    }

}
