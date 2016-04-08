package com.cxh.note.fragment;

import android.util.Log;
import android.widget.Toast;

import com.cxh.note.R;

/**
 * Created by Administrator on 2016/3/24.
 */
public class LazyLoadDataPreLoadViewFragment3 extends BaseLazyLoadDataFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lazy_viewpager3;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("test", "LazyLoadDataPreLoadViewFragment3 + onResume");
    }

    @Override
    protected void loadData() {
        Log.e("test", "LazyLoadDataPreLoadViewFragment3 + loadData");
        Toast.makeText(mContext, "load data3", Toast.LENGTH_SHORT).show();
    }
}
