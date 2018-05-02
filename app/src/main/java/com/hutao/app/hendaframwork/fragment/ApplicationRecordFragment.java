package com.hutao.app.hendaframwork.fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

/**
 * 申请记录
 */
import com.hutao.app.hendaframwork.R;
import com.hutao.app.hendaframwork.adapter.MyFragmentAdapter;
import com.hutao.app.hendaframwork.base.BaseFragment;
import com.hutao.app.hendaframwork.fragment.childFragment.ChildFragment;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRecordFragment extends BaseFragment {

    private TabLayout tab_layout;
    private MyFragmentAdapter pagerAdapter;
    private ViewPager vp;
    private List<BaseFragment> fragmentList;

    @Override
    public int getLayout() {
        return R.layout.fragment_application_record;
    }

    @Override
    public void handEvent() {

        initView();
        initWidghtEvent();
        initFragment();
        setAdapter();
        setListener();
    }

    private void setListener() {
//        tab_layout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vp));

        tab_layout.setupWithViewPager(vp);
    }

    private void initWidghtEvent() {
        tab_layout.setTabMode(TabLayout.MODE_FIXED);
        tab_layout.addTab(tab_layout.newTab().setText("代办"));
        tab_layout.addTab(tab_layout.newTab().setText("进行中"));
        tab_layout.addTab(tab_layout.newTab().setText("已结束"));
    }

    private void initView() {
        tab_layout = findView(R.id.tab_layout);
        vp = findView(R.id.vp);
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(BaseFragment.newInstance("1", "2", ChildFragment.class));
        fragmentList.add(BaseFragment.newInstance("1", "2", ChildFragment.class));
        fragmentList.add(BaseFragment.newInstance("1", "2", ChildFragment.class));
    }

    private void setAdapter() {
        pagerAdapter = new MyFragmentAdapter(getChildFragmentManager(), fragmentList);
        vp.setAdapter(pagerAdapter);
        vp.setCurrentItem(0);
    }

}
