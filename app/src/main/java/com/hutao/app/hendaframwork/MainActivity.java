package com.hutao.app.hendaframwork;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hutao.app.hendaframwork.adapter.MyFragmentAdapter;
import com.hutao.app.hendaframwork.fragment.ApplicationRecordFragment;
import com.hutao.app.hendaframwork.base.BaseFragment;
import com.hutao.app.hendaframwork.fragment.ProblemListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyFragmentAdapter pagerAdapter;
    private ViewPager vp;
    private List<BaseFragment> fragmentList;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        setAdapter();
        setListener();
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd0:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rd1:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        RadioButton rd0 = (RadioButton) radioGroup.getChildAt(0);
                        rd0.setChecked(true);
                        break;
                    case 1:
                        RadioButton rd1 = (RadioButton) radioGroup.getChildAt(1);
                        rd1.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        vp = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(BaseFragment.newInstance("1", "2", ApplicationRecordFragment.class));
        fragmentList.add(BaseFragment.newInstance("1", "2", ProblemListFragment.class));
    }

    private void setAdapter() {
        pagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        vp.setAdapter(pagerAdapter);
        vp.setCurrentItem(0);
    }
}
