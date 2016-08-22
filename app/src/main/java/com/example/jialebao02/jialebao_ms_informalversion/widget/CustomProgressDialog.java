package com.example.jialebao02.jialebao_ms_informalversion.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jialebao02.jialebao_ms_informalversion.R;

/**
 * Created by 陶聪 on 2016-08-22.
 */
public class CustomProgressDialog extends Dialog {
    private static CustomProgressDialog customProgressDialog = null;
    Context context;

    public CustomProgressDialog(Context context) {
        super(context);
        this.context = context;
    }

    public CustomProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    public static CustomProgressDialog createDialog(Context context) {
        customProgressDialog = new CustomProgressDialog(context, R.style.CustomProgressDialog);
        customProgressDialog.setContentView(R.layout.customprogressdialog);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return customProgressDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (customProgressDialog == null) {
            return;
        }
        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.iv_loadingImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

    }

    public CustomProgressDialog setTitile(String strTitle) {
        return customProgressDialog;
    }

    public CustomProgressDialog setMessage(String strMessage) {
        TextView tvMsg = (TextView) customProgressDialog.findViewById(R.id.tv_loadingmsg);

        if (tvMsg != null) {
            tvMsg.setText(strMessage);
        }

        return customProgressDialog;
    }

    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        if (isvalidContext() && this.isShowing()) {
            super.dismiss();
        }
    }

    public boolean isvalidContext() {

        Activity activity = (Activity) context;
        if (activity==null|| activity.isFinishing()) {
            return false;
        } else {
            return true;
        }
    }
}
