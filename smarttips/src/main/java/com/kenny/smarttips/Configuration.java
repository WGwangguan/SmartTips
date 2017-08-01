package com.kenny.smarttips;

import android.support.annotation.AnimRes;
import android.support.annotation.DrawableRes;

import com.kenny.smarttips.listener.LeftImageClickListener;
import com.kenny.smarttips.listener.RightImageClickListener;

/**
 * Created by Kenny on 2017/7/31 16:11.
 * Desc:
 */

public class Configuration {
    public static final Configuration DEFAULT;
    private static final String DEFAULT_NOTICE = "Please set your notice here.";

    static {
        DEFAULT = new Builder().build();
    }

    final String strNotice;
    final LeftImageClickListener leftImageClickListener;
    final RightImageClickListener rightImageClickListener;
    final int noticeColor;
    final int backgroundColor;
    @DrawableRes
    final int leftImageRes;
    @DrawableRes
    final int rightImageRes;
    @AnimRes
    final int inAnimationRes;
    @AnimRes
    final int outAnimationRes;

    private Configuration(Builder builder) {
        this.noticeColor = builder.noticeColor;
        this.leftImageRes = builder.leftImageRes;
        this.rightImageRes = builder.rightImageRes;
        this.strNotice = builder.strNotice;
        this.leftImageClickListener = builder.leftImageClickListener;
        this.rightImageClickListener = builder.rightImageClickListener;
        this.backgroundColor = builder.backgroundColor;
        this.inAnimationRes = builder.inAnimationRes;
        this.outAnimationRes = builder.outAnimationRes;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "strNotice='" + strNotice + '\'' +
                ", leftImageClickListener=" + leftImageClickListener +
                ", rightImageClickListener=" + rightImageClickListener +
                ", noticeColor=" + noticeColor +
                ", backgroundColor=" + backgroundColor +
                ", leftImageRes=" + leftImageRes +
                ", rightImageRes=" + rightImageRes +
                ", inAnimationRes=" + inAnimationRes +
                ", outAnimationRes=" + outAnimationRes +
                '}';
    }

    public static class Builder {

        private int backgroundColor = android.R.color.transparent;
        private int noticeColor = android.R.color.primary_text_light;
        private String strNotice = DEFAULT_NOTICE;
        private LeftImageClickListener leftImageClickListener;
        private RightImageClickListener rightImageClickListener;
        @DrawableRes
        private int leftImageRes = R.drawable.ic_notifications_active_black_18dp;
        @DrawableRes
        private int rightImageRes = R.drawable.ic_close_black_18dp;
        @AnimRes
        private int inAnimationRes = R.anim.slide_in_top;
        @AnimRes
        private int outAnimationRes = R.anim.slide_out_top;

        public Builder setLeftImageIcon(@DrawableRes int imageRes) {
            this.leftImageRes = imageRes;
            return this;
        }

        public Builder setRightImageIcon(@DrawableRes int imageRes) {
            this.rightImageRes = imageRes;
            return this;
        }

        public Builder setNoticeColor(int color) {
            this.noticeColor = color;
            return this;
        }

        public Builder setNotice(String notice) {
            this.strNotice = notice;
            return this;
        }

        public Builder setLeftImageClickListener(LeftImageClickListener listener) {
            this.leftImageClickListener = listener;
            return this;
        }

        public Builder setRightImageClickListener(RightImageClickListener listener) {
            this.rightImageClickListener = listener;
            return this;
        }

        public Builder setBackgroundColor(int color) {
            this.backgroundColor = color;
            return this;
        }

        public Builder setInAnimation(@AnimRes int animRes) {
            this.inAnimationRes = animRes;
            return this;
        }

        public Builder setOutAnimation(@AnimRes int animRes) {
            this.outAnimationRes = animRes;
            return this;
        }


        public Configuration build() {
            return new Configuration(this);
        }


    }
}
