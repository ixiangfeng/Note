package com.cxh.note.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cxh.note.R;
import com.cxh.note.fragment.HomeMenuFragment;
import com.cxh.note.fragment.factory.HomeContentFragmentFactory;
import com.cxh.note.listener.MenuClickToHomeListener;

/**
 * Created by Administrator on 2016/3/21.
 */
public class HomeActivity extends BaseActivity implements MenuClickToHomeListener {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager supportFragmentManager;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    protected void setListener() {

    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        supportFragmentManager = getSupportFragmentManager();

        setDrawerView(HomeContentFragmentFactory.getFragment(MENU), R.id.fl_content);
        setDrawerView(new HomeMenuFragment(), R.id.fl_menu);
    }

    private void setDrawerView(Fragment fragment, int resId) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(resId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void initData() {
        initToolBar();
        setToggleDrawer();
    }

    private void initToolBar() {
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setToggleDrawer() {
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void getClickId(int resId) {
        setDrawerView(HomeContentFragmentFactory.getFragment(resId),R.id.fl_content);
        mDrawerLayout.closeDrawers();
    }

    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }
}
