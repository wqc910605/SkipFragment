package com.zhongyuan.fragmentanimation.skipfragment;

import android.view.View;
import android.widget.Toast;

import com.zhongyuan.fragmentanimation.R;
import com.zhongyuan.fragmentanimation.skipfragment.BaseFragment;

/**
 * Created by zy01060 on 2018/1/4.
 */

public class FragmentDemo6 extends BaseFragment {

    @Override
    public int setLayoutId() {
        return R.layout.fragment_demo5;
    }

    @Override
    protected void initView(View rootView) {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getActivity(), "FragmentDemo6", Toast.LENGTH_SHORT).show();
    }
}
