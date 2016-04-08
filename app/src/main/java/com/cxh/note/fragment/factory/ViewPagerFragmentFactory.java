package com.cxh.note.fragment.factory;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.cxh.note.fragment.LazyLoadDataPreLoadViewFragment1;
import com.cxh.note.fragment.LazyLoadDataPreLoadViewFragment2;
import com.cxh.note.fragment.LazyLoadDataPreLoadViewFragment3;
import com.cxh.note.fragment.LazyLoadDataPreLoadViewFragment4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/24.
 */
public class ViewPagerFragmentFactory {
    private static Map<Integer, Fragment> mCaches = new LinkedHashMap<>();

    public static Fragment getFragment(int position) {
        Fragment temp = mCaches.get(position);
        if (temp != null) {
            Log.e("test", "get from caches");
            return temp;
        }
        switch (position) {

            case 0:
                temp = new LazyLoadDataPreLoadViewFragment1();
                break;
            case 1:
                temp = new LazyLoadDataPreLoadViewFragment2();
                break;
            case 2:
                temp = new LazyLoadDataPreLoadViewFragment3();
                break;
            case 3:
                temp = new LazyLoadDataPreLoadViewFragment4();
                break;
        }
        Log.e("test", "put to cache");
        mCaches.put(position, temp);
        return temp;
    }
}
