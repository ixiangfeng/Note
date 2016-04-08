package com.cxh.note.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxh on 2016/3/21.
 */
public abstract  class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        putFinishList(this);
        setContentView(getLayoutId());
        initView();
        setListener();
        initData();
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeFromFinishList(this);
    }

    protected abstract void setListener();

    protected abstract void initView();

    protected abstract void initData() ;

    private static final List<BaseActivity> mActivitys = new ArrayList<>();

    public synchronized static void finishAll() {
        for (BaseActivity f : mActivitys) {
            f.exit();
        }
    }

    public synchronized void finishAllExcept(BaseActivity activity) {
        for (BaseActivity finish : mActivitys) {
            if (!finish.equals(activity)) {
                finish.exit();
            }
        }
    }

    public synchronized void putFinishList(BaseActivity activity) {
        mActivitys.add(activity);
    }

    public synchronized void removeFromFinishList(BaseActivity activity) {
        mActivitys.remove(activity);
    }

    private synchronized void exit() {
        try {
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            finish();
        }
    }


    @Override
    public void onClick(View v) {

    }
}
