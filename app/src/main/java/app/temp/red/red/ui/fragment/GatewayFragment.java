package app.temp.red.red.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hkf.coffee.ui.fragment.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import app.temp.red.red.R;
import app.temp.red.red.ui.view.CircleStage;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页-网关模块
 * Created by huangkangfa on 2017/8/9.
 */
public class GatewayFragment extends BaseFragment {
    @Bind(R.id.cs)
    CircleStage cs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_gateway, container);
        ButterKnife.bind(this, view);
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "#ff0000");
        map.put(4, "#ff0000");
        map.put(5, "#00ff00");
        map.put(6, "#00ff00");
        map.put(7, "#00ff00");
        map.put(8, "#00ff00");
        map.put(9, "#0000ff");
        map.put(10, "#0000ff");
        map.put(11, "#0000ff");
        cs.setColors(map);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
