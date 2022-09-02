package com.hualong.mylib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hualong.lib.dialog.DYLoadingDialog;


public class MainActivity extends AppCompatActivity {
    private DYLoadingDialog mDYLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDYLoadingDialog = new DYLoadingDialog(this);
        mDYLoadingDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDYLoadingDialog.dismiss();
    }
}