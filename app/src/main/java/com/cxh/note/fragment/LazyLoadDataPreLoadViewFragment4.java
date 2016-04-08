package com.cxh.note.fragment;

import android.util.Log;
import android.widget.Toast;

import com.cxh.note.R;

/**
 * Created by cxh on 2016/3/24.
 */
public class LazyLoadDataPreLoadViewFragment4 extends BaseLazyLoadDataFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lazy_viewpager4;
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
        Log.e("test", "LazyLoadDataPreLoadViewFragment4 + onResume");
    }

    protected void loadData() {
        Log.e("test", "LazyLoadDataPreLoadViewFragment4 + loadData");
        Toast.makeText(mContext, "load data4", Toast.LENGTH_SHORT).show();
    }
}
