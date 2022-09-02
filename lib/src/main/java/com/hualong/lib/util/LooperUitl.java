package com.hualong.lib.util;

import android.os.Handler;
import android.os.Looper;

import com.hualong.lib.callback.Callback;

/**
 * <pre>
 *  @author：hualong
 *  @time：2022/9/2 11:37.
 *  @desc:有消息循环的线程工具类
 * <pre>
 */
public class LooperUitl {
    /**
     * 主线程Handler
     */
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    /** 是否在主线程 */
    public static boolean isMainLooper(){
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /** 在主线程中执行 */
    public static void runOnUiThread(Runnable runnable){
        MAIN_HANDLER.post(runnable);
    }

    /** 在主线程中执行 */
    public static void runOnMainThread(Callback callback){
        if(callback == null) return;
        if(isMainLooper()) callback.callback();
        else runOnUiThread(() -> {
            callback.callback();
        });
    }
}
