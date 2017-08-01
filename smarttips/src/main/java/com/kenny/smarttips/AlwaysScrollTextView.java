package com.kenny.smarttips;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;

/**
 * Created by Kenny on 2017/7/31 11:33.
 * Desc: Permanent loop of TextView.
 */

public class AlwaysScrollTextView extends android.support.v7.widget.AppCompatTextView {
    public AlwaysScrollTextView(Context context) {
        this(context, null);
    }

    public AlwaysScrollTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AlwaysScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSingleLine(true);
        setMarqueeRepeatLimit(-1);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);

    }

    @Override
    public boolean isFocused() {
        return true;
    }

}
