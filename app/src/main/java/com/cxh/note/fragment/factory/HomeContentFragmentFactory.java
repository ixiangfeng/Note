package com.cxh.note.fragment.factory;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.cxh.note.fragment.HomeContentFragment;
import com.cxh.note.fragment.HomeContentFragment1;
import com.cxh.note.fragment.HomeContentFragment2;
import com.cxh.note.listener.MenuClickToHomeListener;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by cxh on 2016/3/23.
 */
public class HomeContentFragmentFactory {

    private static Map<Integer, Fragment> mCaches = new LinkedHashMap<>();

    public static Fragment getFragment(int index) {
        Fragment temp = mCaches.get(index);
        if (temp != null) {
            Log.e("test", temp + "**" + temp);
            return temp;
        }
        switch (index) {
            case MenuClickToHomeListener.MENU:
                temp = new HomeContentFragment();
                break;
            case MenuClickToHomeListener.MENU1:
                temp = new HomeContentFragment1();
                break;
            case MenuClickToHomeListener.MENU2:
                temp = new HomeContentFragment2();
                break;
        }
        Log.e("test", temp + "||||||" + temp);
        mCaches.put(index, temp);
        return temp;
    }
}
