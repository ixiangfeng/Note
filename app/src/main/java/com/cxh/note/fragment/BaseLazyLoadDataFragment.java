package com.cxh.note.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/3/24.
 */
public abstract class BaseLazyLoadDataFragment extends Fragment {
    protected View rootView;
    protected Context mContext;

    private boolean hasLoadData;
    private boolean hasInit;
    boolean isVisibleToUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("test", this.toString());
        initView();
        initData();
        mContext = getActivity();
        hasInit = true;
        if (!hasLoadData && isVisibleToUser) {
            Log.e("test", "onActivityCreated loadData");
            hasLoadData = true;
            loadData();
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser && !hasLoadData && hasInit) {
            hasLoadData = true;
            Log.e("test", "setUserVisibleHint loadData");
            loadData();
        }
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void loadData();
}
