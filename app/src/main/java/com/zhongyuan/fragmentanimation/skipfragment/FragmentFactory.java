package com.zhongyuan.fragmentanimation.skipfragment;

import android.support.v4.app.Fragment;

/**
 * Created by zy01060 on 2018/1/4.
 */

public class FragmentFactory {
    public static Fragment createFragment(Class<? extends Fragment> clazz) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) clazz.newInstance();
            return fragment;
        } catch (InstantiationException e) {
            fragment = null;
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            fragment = null;
            e.printStackTrace();
        }
        return fragment;
    }
}
