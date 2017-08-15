package app.temp.red.red.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hkf.coffee.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import app.temp.red.red.ui.activity.HomeActivity;
import app.temp.red.red.ui.adapter.VerticalAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-场景模块
 * Created by huangkangfa on 2017/8/9.
 */

public class SceneFragment extends BaseFragment {
    @Bind(R.id.head_rl_head)
    RelativeLayout headRlHead;  //顶部栏
    @Bind(R.id.head_img_persion)
    ImageView headImgPersion;  //群组列表展示
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;  //群组昵称
    @Bind(R.id.gv)
    GridView gv;

    VerticalAdapter adapter_vertical;
    SeekBar s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_scene, container);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        final List<String> data2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            data2.add("测试数据" + i);
        }

        data2.add("添加");
        adapter_vertical=new VerticalAdapter(getContext(),data2);
        gv.setAdapter(adapter_vertical);
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i<data2.size()-1){
                    Intent it=new Intent(HomeActivity.ACTION_NAME);
                    it.putExtra("类型","选择弹框");
                    mActivity.sendBroadcast(it);
                }
                return true;
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i<data2.size()-1)
                    GotoActivityManager.goWeekProgramActivity(mActivity);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.head_img_others, R.id.head_img_persion, R.id.head_txt_title})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.head_img_others:
                //更多

                break;
            case R.id.head_img_persion:
                //头像

                break;
            case R.id.head_txt_title:
                //群组昵称

                break;
        }
    }
}
