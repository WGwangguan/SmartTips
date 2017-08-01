package com.kenny.smarttips;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.kenny.smarttips.listener.AnimationOptionalListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 2017/7/31 14:19.
 * Desc: Handle the notice display and hide.
 */

public class NotificationManager {

    private static NotificationManager notificationManager;

    private boolean showing;

    private List<SmartTips> smartTipses;

    private TipsView currentTipsView;

    private NotificationManager() {
        smartTipses = new ArrayList<>();
    }

    public static synchronized NotificationManager Instance() {
        if (notificationManager == null)
            notificationManager = new NotificationManager();
        return notificationManager;
    }

    public void add(SmartTips smartTips) {
        if (!smartTipses.contains(smartTips)) {
            smartTipses.add(smartTips);
            notifyUpdate();
        }
    }

    public void remove() {
        if (currentTipsView != null && smartTipses.size() != 0) {
            SmartTips smartTips = smartTipses.remove(0);
            Animation animation = AnimationUtils.loadAnimation(currentTipsView.getContext(), smartTips.getConfig().outAnimationRes);
            animation.setAnimationListener(new AnimationOptionalListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    ((ViewGroup) currentTipsView.getParent()).removeView(currentTipsView);
                    currentTipsView = null;
                    showing = false;
                    notifyUpdate();
                }
            });
            currentTipsView.startAnimation(animation);
        }
    }

    public void cancelAll() {
        if (showing) {
            remove();
            smartTipses.clear();
        }
    }

    private void notifyUpdate() {
        if (!showing && smartTipses.size() != 0) {
            SmartTips smartTips = smartTipses.get(0);

            currentTipsView = new TipsView(smartTips.getActivity());
            currentTipsView.setNotice(smartTips.getConfig().strNotice);
            currentTipsView.setImageLeft(smartTips.getConfig().leftImageRes);
            currentTipsView.setImageRight(smartTips.getConfig().rightImageRes);
            currentTipsView.setNoticeTextColor(smartTips.getConfig().noticeColor);
            currentTipsView.setLeftImageClickListener(smartTips.getConfig().leftImageClickListener);
            currentTipsView.setRightImageClickListener(smartTips.getConfig().rightImageClickListener);
            currentTipsView.setBackgroundColor(smartTips.getActivity().getResources().getColor(smartTips.getConfig().backgroundColor));

            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            smartTips.getActivity().addContentView(currentTipsView, lp);

            Animation animation = AnimationUtils.loadAnimation(smartTips.getActivity(), smartTips.getConfig().inAnimationRes);
            currentTipsView.startAnimation(animation);

            showing = true;
        }

    }

}
