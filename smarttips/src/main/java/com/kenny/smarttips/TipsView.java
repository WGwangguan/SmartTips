package com.kenny.smarttips;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kenny.smarttips.listener.LeftImageClickListener;
import com.kenny.smarttips.listener.RightImageClickListener;

/**
 * Created by Kenny on 2017/7/31 10:16.
 * Desc:
 */

public class TipsView extends RelativeLayout {

    ImageView imageLeft;
    ImageView imageRight;
    TextView textNotice;

    String strNotice;

    @DrawableRes
    int imageLeftRes;

    @DrawableRes
    int imageRightRes;

    int noticeColor;

    int backgroundColor;

    LeftImageClickListener leftImageClickListener;

    RightImageClickListener rightImageClickListener;

    public TipsView(Context context) {
        this(context, null);
    }

    public TipsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TipsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.tips_view_layout, this);

        imageLeft = (ImageView) findViewById(R.id.image_icon_left);
        imageRight = (ImageView) findViewById(R.id.image_icon_right);
        textNotice = (TextView) findViewById(R.id.text_notice);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AlwaysScrollTextView);
        strNotice = ta.getString(R.styleable.AlwaysScrollTextView_notice);
        imageLeftRes = ta.getResourceId(R.styleable.AlwaysScrollTextView_left_icon, R.drawable.ic_notifications_active_black_18dp);
        imageRightRes = ta.getResourceId(R.styleable.AlwaysScrollTextView_right_icon, R.drawable.ic_close_black_18dp);
        noticeColor = ta.getResourceId(R.styleable.AlwaysScrollTextView_noticeColor, android.R.color.primary_text_light);
        backgroundColor = ta.getResourceId(R.styleable.AlwaysScrollTextView_backgroundColor, android.R.color.transparent);
        ta.recycle();

        imageLeft.setImageResource(imageLeftRes);
        imageRight.setImageResource(imageRightRes);
        textNotice.setText(strNotice);
        textNotice.setTextColor(noticeColor);
        super.setBackgroundColor(getResources().getColor(backgroundColor));

        imageLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftImageClickListener != null)
                    leftImageClickListener.onLeftClick();
            }
        });

        imageRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightImageClickListener != null)
                    rightImageClickListener.onRightClick();
            }
        });

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setNotice(String notice) {
        if (!TextUtils.isEmpty(notice))
            textNotice.setText(notice);
    }

    public void setImageLeft(@DrawableRes int leftRes) {
        imageLeft.setImageResource(leftRes);
    }

    public void setImageRight(@DrawableRes int rightRes) {
        imageRight.setImageResource(rightRes);
    }

    public void setNoticeTextColor(int colorRes) {
        textNotice.setTextColor(getResources().getColor(colorRes));
    }

    public void setLeftImageClickListener(LeftImageClickListener listener) {
        leftImageClickListener = listener;
    }

    public void setRightImageClickListener(RightImageClickListener listener) {
        rightImageClickListener = listener;
    }

    public void setBackgroundColor(int colorRes) {
        super.setBackgroundColor(colorRes);
    }

}
