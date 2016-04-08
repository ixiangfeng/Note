package com.cxh.note.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cxh.note.R;
import com.cxh.note.adapter.base.CommonAdapter;
import com.cxh.note.adapter.base.ViewHolder;
import com.cxh.note.bean.HomeFragmentContentListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class HomeContentFragment extends Fragment {
    private ListView listView;
    private List<HomeFragmentContentListItem> mDatas;

    private String packagePref = "com.cxh.note.activity.";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_content, null);
        listView = (ListView) rootView.findViewById(R.id.listView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDatas = new ArrayList<>();
        mDatas.add(new HomeFragmentContentListItem("listView item 点击展开收缩动画", packagePref + "ListItemAnimationActivity"));
        mDatas.add(new HomeFragmentContentListItem("viewpager预加载view,懒加载data", packagePref + "LazyLoadDataPreLoadViewActivity"));
        mDatas.add(new HomeFragmentContentListItem("viewpager懒加载view和data", packagePref + "LazyLoadViewPagerActivity"));
        mDatas.add(new HomeFragmentContentListItem("240度环形进度View", packagePref + "CircleProgressViewActivity"));
        mDatas.add(new HomeFragmentContentListItem("测试5", packagePref + "TestActivity"));
        listView.setAdapter(new CommonAdapter<HomeFragmentContentListItem>(getActivity(), mDatas, R.layout.item_home_fragment_content) {
            @Override
            public void convert(ViewHolder holder, final HomeFragmentContentListItem item) {
                holder.setText(R.id.tv_title, item.title);
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            startActivity(new Intent(getActivity(), Class.forName(item.activityFullName)));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
