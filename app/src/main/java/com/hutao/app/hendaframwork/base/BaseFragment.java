package com.hutao.app.hendaframwork.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public View mRootView;

    public BaseFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static BaseFragment newInstance(String param1, String param2, Class fragmentCla) {
        BaseFragment fragment = null;
        try {
            fragment = (BaseFragment) fragmentCla.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(this.getActivity()).inflate(getLayout(), null);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handEvent();
    }

    public <T> T findView(int viewId) {
        T t = (T)mRootView.findViewById(viewId);
        return t;
    }

    public abstract int getLayout();

    public abstract void handEvent();

}
