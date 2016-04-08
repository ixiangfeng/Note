package com.cxh.note.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.cxh.note.R;
import com.cxh.note.fragment.factory.ViewPagerFragmentFactory;
import com.cxh.note.widget.CustomRadioButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxh on 2016/3/24.
 */
public class LazyLoadDataPreLoadViewActivity extends BaseActivity {
    private ViewPager viewPager;

    private RadioGroup rg;
    private CustomRadioButton rb1, rb2, rb3, rb4;

    private List<Fragment> mFragments = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_lazyloaddata_preloadview;
    }

    @Override
    protected void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                rb1.setAlpha(position);
//                rb2.setAlpha(1-position);
            }

            @Override
            public void onPageSelected(int position) {
//                switch (position) {
//                    case 0:
//                        rb1.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.home_pressed, 0, 0);
//                        rb2.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.customer_default, 0, 0);
//                        rb3.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.report_default ,0,0);
//                        rb4.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.set_default,0,0);
//                        break;
//                    case 1:
//                        rb1.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.home_default,0,0);
//                        rb2.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.customer_pressed,0,0);
//                        rb3.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.report_default,0,0);
//                        rb4.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.set_default,0,0);
//                        break;
//
//                    case 2:
//                        rb1.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.home_default,0,0);
//                        rb2.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.customer_default,0,0);
//                        rb3.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.report_pressed,0,0);
//                        rb4.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.set_default,0,0);
//                        break;
//
//                    case 3:
//                        rb1.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.home_default,0,0);
//                        rb2.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.customer_default,0,0);
//                        rb3.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.report_default,0,0);
//                        rb4.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.set_pressed,0,0);
//                        break;
//                }

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
//        mFragments.add(new LazyLoadDataPreLoadViewFragment1());
//        mFragments.add(new LazyLoadDataPreLoadViewFragment2());
//        mFragments.add(new LazyLoadDataPreLoadViewFragment3());
//        mFragments.add(new LazyLoadDataPreLoadViewFragment4());
        mFragments.add(ViewPagerFragmentFactory.getFragment(0));
        mFragments.add(ViewPagerFragmentFactory.getFragment(1));
        mFragments.add(ViewPagerFragmentFactory.getFragment(2));
        mFragments.add(ViewPagerFragmentFactory.getFragment(3));
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
    }

    class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

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
