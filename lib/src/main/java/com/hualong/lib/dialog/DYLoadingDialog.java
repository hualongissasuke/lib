package com.hualong.lib.dialog;

import android.content.Context;

import androidx.appcompat.app.AppCompatDialog;

import com.hualong.lib.R;
import com.hualong.lib.callback.Callback;
import com.hualong.lib.util.LooperUitl;
import com.hualong.lib.widget.DYLoadingView;

/**
 * <pre>
 *  @author：hualong
 *  @time：2022/9/2 11:16.
 *  @desc:抖音加载框
 * <pre>
 */
public class DYLoadingDialog extends AppCompatDialog {
    private DYLoadingView mDYLoadingView;

    public DYLoadingDialog(Context context) {
        super(context, R.style.Loading_DY);

        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        mDYLoadingView = new DYLoadingView(getContext());
        setCanceledOnTouchOutside(false);
        getDelegate().setContentView(mDYLoadingView);
    }

    /**
     * 获取抖音加载View
     */
    public DYLoadingView getDYLoadingDialog() {
        return mDYLoadingView;
    }

    /**
     * 显示
     */
    public void show() {
        if (!isShowing()) {
            super.show();
            mDYLoadingView.start();
        }
    }

    /**
     * 隐藏
     */
    public void dismiss() {
        if(isShowing()){
            super.dismiss();
            LooperUitl.runOnMainThread(() -> mDYLoadingView.stop());
        }
    }


}
