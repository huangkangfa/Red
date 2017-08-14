package app.temp.red.red.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hkf.coffee.ui.fragment.BaseFragment;

import app.temp.red.red.R;

/**
 * 首页-我的模块
 * Created by huangkangfa on 2017/8/9.
 */
public class MineFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_mine, container);
        return view;
    }
}
