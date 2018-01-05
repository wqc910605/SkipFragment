package com.zhongyuan.fragmentanimation.skipfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zhongyuan.fragmentanimation.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    //    @BindView(R.id.fl_main_content)
//    FrameLayout mFlMainContent;
//    @BindView(R.id.bottom_navigation_bar)
//    BottomNavigationBar mBottomNavigationBar;
    private BottomNavigationBar mBottomNavigationBar;

    public BottomNavigationBar getBottomNavigationBar() {
        return mBottomNavigationBar;
    }

    private List<Fragment> mFragments = new ArrayList<>();

    private void assignViews() {
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        ButterKnife.bind(this);
        assignViews();
        initFragment();
        initBottomNavigationBar();
    }

    private void initBottomNavigationBar() {
        for (int i = 0; i < mFragments.size(); i++) {
            BottomNavigationItem navigationItem = new BottomNavigationItem(R.mipmap.ic_launcher, "home");
            mBottomNavigationBar.addItem(navigationItem);
        }
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor(R.color.red)
                .setInActiveColor(R.color.gray).initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    private void initFragment() {
        mFragments.add(FragmentFactory.createFragment(FragmentDemo1.class));
        mFragments.add(FragmentFactory.createFragment(FragmentDemo2.class));
        mFragments.add(FragmentFactory.createFragment(FragmentDemo3.class));
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragments.get(0)).commit();
    }


    //    private Fragment currentFragment = null;
    private FragmentTransaction fragmentTransaction = null;

    @Override
    public void onTabSelected(int position) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.right_enter, R.anim.left_exit, R.anim.left_enter, R.anim.right_exit);
        if (!mFragments.get(position).isAdded()) {
            fragmentTransaction.add(R.id.fl_main_content, mFragments.get(position)).addToBackStack(null);
        }
//        fragmentTransaction.replace(R.id.fl_main_content, mFragments.get(position)).commit();
        fragmentTransaction.show(mFragments.get(position));
    }

    @Override
    public void onTabUnselected(int position) {
        fragmentTransaction.hide(mFragments.get(position)).commit();
    }

    @Override
    public void onTabReselected(int position) {
//        startActivityForResult();
    }
    //判断当前正在运行的fragment
    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment visibleFragment = getVisibleFragment();
        if (visibleFragment == null) {
            return;
        }
        switch (visibleFragment.getClass().getSimpleName()) {
            case "FragmentDemo1":
                mBottomNavigationBar.selectTab(0);
                break;
            case "FragmentDemo2":
                mBottomNavigationBar.selectTab(1);
                break;
            case "FragmentDemo3":
                mBottomNavigationBar.selectTab(2);
                break;
        }
    }
}
