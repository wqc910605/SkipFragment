package com.zhongyuan.fragmentanimation.skipfragment;

import android.view.View;
import android.widget.Button;

import com.zhongyuan.fragmentanimation.R;

import butterknife.Bind;

/**
 * Created by zy01060 on 2018/1/4.
 */

public class FragmentDemo4 extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.bt_click)
    Button mBtClick;
    @Override
    public int setLayoutId() {
        return R.layout.fragment_demo4;
    }
    @Override
    protected void initView(View rootView) {
        mBtClick.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        startFragment(R.id.fl_main_content, FragmentDemo5.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ((MainActivity) getActivity()).getBottomNavigationBar().setVisibility(View.VISIBLE);
    }


}
