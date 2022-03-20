package com.droideve.apps.sugoi;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 自定義彈窗
 */
public class CustomDialog extends Dialog {

    TextView tvLoadingTx;
    ImageView ivLoading;

    public CustomDialog(Context context) {
        this(context, R.style.loading_dialog, "載入中...");

    }

    protected CustomDialog(Context context, int theme, String string) {
        super(context, theme);
        setCanceledOnTouchOutside(true);//點選其他區域時 true 關閉彈窗 false 不關閉彈窗
        setContentView(R.layout.loading_dialog);//載入佈局
        tvLoadingTx = findViewById(R.id.tv_loading_tx);
        tvLoadingTx.setText(string);
        ivLoading = findViewById(R.id.iv_loading);
        // 載入動畫
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.loading_animation);
        // 使用ImageView顯示動畫
        ivLoading.startAnimation(hyperspaceJumpAnimation);

        getWindow().getAttributes().gravity = Gravity.CENTER;//居中顯示
        getWindow().getAttributes().dimAmount = 0.5f;//背景透明度 取值範圍 0 ~ 1
    }

    //關閉彈窗
    @Override
    public void dismiss() {
        super.dismiss();
    }
}