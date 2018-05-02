package com.hutao.app.hendaframwork.fragment.childFragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hutao.app.hendaframwork.R;
import com.hutao.app.hendaframwork.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends BaseFragment {

    @Override
    public int getLayout() {
        return R.layout.fragment_child;
    }

    public static final int[] COLORS = {Color.RED, Color.BLUE, Color.GREEN};

    @Override
    public void handEvent() {

        mRootView.setBackgroundColor(COLORS[(int) (Math.random()*3)]);
//        mRootView.setBackgroundColor(Color.RED);
    }

}
