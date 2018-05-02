package com.hutao.app.hendaframwork.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hutao.app.hendaframwork.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> mFragmentList;
    private String[] titleList = {"a", "b", "c"};

    public MyFragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList[position];
    }
}
