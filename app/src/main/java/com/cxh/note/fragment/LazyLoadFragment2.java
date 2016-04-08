package com.cxh.note.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/25.
 */
public class LazyLoadFragment2 extends BaseLazyLoadFragment {

    public static LazyLoadFragment2 newInstance(String title) {
        LazyLoadFragment2 fragment1 = new LazyLoadFragment2();
        Bundle args = new Bundle();
        args.putString("key_fragment_title", title);
        fragment1.setArguments(args);
        return fragment1;
    }

    private String title;
    private TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("key_fragment_title");
//        Trace.d(title + "onCreate");
        Log.e("test3", title + "onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("test3", title + "onResume");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("test3", title + "onCreateView");
        tv = new TextView(getActivity());
        tv.setText("lazyload2");
        return tv;

    }

    @Override
    public void fetchData() {
        Log.e("test3", title + "fetchData");
        Toast.makeText(getActivity(), "lazyload data2", Toast.LENGTH_SHORT).show();
    }
}
