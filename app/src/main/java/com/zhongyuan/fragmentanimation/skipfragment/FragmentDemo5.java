package com.zhongyuan.fragmentanimation.skipfragment;

import android.view.View;
import android.widget.Toast;

import com.zhongyuan.fragmentanimation.R;

/**
 * Created by zy01060 on 2018/1/4.
 */

public class FragmentDemo5 extends BaseFragment implements View.OnClickListener {

    @Override
    public int setLayoutId() {
        return R.layout.fragment_demo5;
    }

    @Override
    protected void initView(View rootView) {
        rootView.findViewById(R.id.bt_click).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startFragment(R.id.fl_main_content, FragmentDemo6.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getActivity(), "FragmentDemo5", Toast.LENGTH_SHORT).show();
    }
}
