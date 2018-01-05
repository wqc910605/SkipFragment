package com.zhongyuan.fragmentanimation.skipfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhongyuan.fragmentanimation.Constant;
import com.zhongyuan.fragmentanimation.R;

import butterknife.ButterKnife;

/**
 * Created by zy01060 on 2018/1/4.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    public abstract int setLayoutId();

    protected abstract void initView(View rootView);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        int backStackEntryCount = fragmentManager.getBackStackEntryCount();

        if (backStackEntryCount <= Constant.currentCount) {//模拟返回键
            onBackPressed();
        }
        Constant.currentCount = backStackEntryCount;
    }
    //fragment的返回键操作
    public void onBackPressed() {
    }

    public void startFragment(int containId, Class<? extends Fragment> clazz, Bundle bundle) {
        //注意v4包的配套使用
        try {
            Fragment fragment = clazz.newInstance();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.right_enter, R.anim.left_exit, R.anim.left_enter, R.anim.right_exit)
                    .replace(containId, fragment)
                    .addToBackStack(null)
                    .commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void startFragment(int containId, Class<? extends Fragment> clazz) {
        startFragment(containId, clazz, null);
    }
}
