package com.cxh.note.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxh.note.R;
import com.cxh.note.activity.HomeActivity;
import com.cxh.note.listener.MenuClickToHomeListener;

/**
 * Created by cxh on 2016/3/21.
 */
public class HomeMenuFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private ImageView iv_menu_top;
    private TextView tv_menu;
    private TextView tv_menu1;
    private TextView tv_menu2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_menu, null);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setListener();
    }

    private void setListener() {
        iv_menu_top.setOnClickListener(this);
        tv_menu1.setOnClickListener(this);
        tv_menu2.setOnClickListener(this);
        tv_menu.setOnClickListener(this);
    }

    private void initView() {
        iv_menu_top = (ImageView) rootView.findViewById(R.id.iv_menu_top);
        tv_menu1 = (TextView) rootView.findViewById(R.id.tv_menu1);
        tv_menu2 = (TextView) rootView.findViewById(R.id.tv_menu2);
        tv_menu = (TextView) rootView.findViewById(R.id.tv_menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu_top:
                if (getActivity() instanceof MenuClickToHomeListener) {
                    ((HomeActivity) (getActivity())).closeDrawer();
                }
                Toast.makeText(getActivity(),"img click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_menu:
                setClickId(MenuClickToHomeListener.MENU);
                break;
            case R.id.tv_menu1:
                setClickId(MenuClickToHomeListener.MENU1);
                break;
            case R.id.tv_menu2:
                setClickId(MenuClickToHomeListener.MENU2);
                break;

        }
    }

    private void setClickId(int resId) {
        if (getActivity() instanceof MenuClickToHomeListener) {
            ((MenuClickToHomeListener) (getActivity())).getClickId(resId);
        }
    }

}
