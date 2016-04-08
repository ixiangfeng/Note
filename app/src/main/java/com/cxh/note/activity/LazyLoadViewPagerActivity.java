package com.cxh.note.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.cxh.note.R;
import com.cxh.note.fragment.LazyLoadFragment1;
import com.cxh.note.fragment.LazyLoadFragment2;
import com.cxh.note.fragment.LazyLoadFragment3;
import com.cxh.note.fragment.LazyLoadFragment4;
import com.cxh.note.widget.CustomRadioButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxh on 2016/3/24.
 */
public class LazyLoadViewPagerActivity extends BaseActivity {
    private ViewPager viewPager;

    private RadioGroup rg;
    private CustomRadioButton rb1, rb2, rb3, rb4;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lazyloaddata_preloadview;
    }

    int currentPosition;
    @Override
    protected void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (currentPosition) {
                    case 0:
                        rb1.setAlpha(1-positionOffset);
                        rb2.setAlpha(positionOffset);
                        break;


                    case 3:
                        rb3.setAlpha(1-positionOffset);
                        rb4.setAlpha(positionOffset);
                        break;

                }
//                Log.e("offset222", positionOffset + "");
//                rb1.setAlpha(1 - positionOffset);
//                rb2.setAlpha(positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                switch (position) {
                    case 0:
                        rb1.setAlpha(1);
                        rb2.setAlpha(0);
                        rb3.setAlpha(0);
                        rb4.setAlpha(0);
                        break;
                    case 1:
                        rb1.setAlpha(0);
                        rb2.setAlpha(1);
                        rb3.setAlpha(0);
                        rb4.setAlpha(0);
                        break;
                    case 2:
                        rb1.setAlpha(0);
                        rb2.setAlpha(0);
                        rb3.setAlpha(1);
                        rb4.setAlpha(0);
                        break;
                    case 3:
                        rb1.setAlpha(0);
                        rb2.setAlpha(0);
                        rb3.setAlpha(0);
                        rb4.setAlpha(1);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (CustomRadioButton) findViewById(R.id.rb1);
        rb2 = (CustomRadioButton) findViewById(R.id.rb2);
        rb3 = (CustomRadioButton) findViewById(R.id.rb3);
        rb4 = (CustomRadioButton) findViewById(R.id.rb4);
    }

    @Override
    protected void initData() {
        mFragments.add(LazyLoadFragment1.newInstance("11111111"));
        mFragments.add(LazyLoadFragment2.newInstance("22222222"));
        mFragments.add(LazyLoadFragment3.newInstance("33333333"));
        mFragments.add(LazyLoadFragment4.newInstance("44444444"));
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        rg.check(R.id.rb1);
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
