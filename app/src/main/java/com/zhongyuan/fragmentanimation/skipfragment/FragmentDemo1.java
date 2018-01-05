package com.zhongyuan.fragmentanimation.skipfragment;

import android.view.View;
import android.widget.Button;

import com.zhongyuan.fragmentanimation.R;


/**
 * Created by zy01060 on 2018/1/4.
 */

public class FragmentDemo1 extends BaseFragment {


    @Override
    public int setLayoutId() {
        return R.layout.fragment_demo1;
    }

    @Override
    protected void initView(View rootView) {
        Button bt_click = rootView.findViewById(R.id.bt_click);
        bt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getBottomNavigationBar().setVisibility(View.GONE);
                startFragment(R.id.fl_main_content, FragmentDemo4.class);
            }
        });
    }


    private boolean isFirst = false;


    /*public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return AnimationUtils.loadAnimation(getActivity(), R.anim.right_enter);
        } else {
            return AnimationUtils.loadAnimation(getActivity(), R.anim.left_exit);
        }
    }*/
}
