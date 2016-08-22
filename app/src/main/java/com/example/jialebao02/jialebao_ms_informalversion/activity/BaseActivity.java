package com.example.jialebao02.jialebao_ms_informalversion.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jialebao02.jialebao_ms_informalversion.R;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	}

	public void setTitleBar(String title) {
		TextView tvName = (TextView) findViewById(R.id.tv_title);
		tvName.setText(title);
	}

	public void initBackButton() {
		ImageView backButton = (ImageView) this.findViewById(R.id.iv_back);
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finishActivity();
			}
		});
	}

	public void finishActivity() {
		finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	protected void setImmerseLayout(View view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window window = getWindow();
			/*
			 * window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
			 * , WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			 */
			window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

			int statusBarHeight = getStatusBarHeight(this.getBaseContext());
			view.setPadding(0, statusBarHeight, 0, 0);
		}
	}

	/**
	 * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
	 *
	 * @return 返回状态栏高度的像素值。
	 */
	public int getStatusBarHeight(Context context) {
		int result = 0;
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = context.getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

}
