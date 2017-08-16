package app.temp.red.red.ui.activity.groups;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.others.ToastUtil;
import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import app.temp.red.red.ui.adapter.VerticalAdapter;
import app.temp.red.red.ui.dialog.ChooseDialog;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr2.PtrClassicFrameLayout;
import in.srain.cube.views.ptr2.PtrDefaultHandler2;
import in.srain.cube.views.ptr2.PtrFrameLayout;

/**
 * 我的群组列表界面
 * Created by huangkangfa on 2017/8/9.
 */
public class MyGroupListActivity extends BaseActivity implements ChooseDialog.ChooseItemClickListener {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.gv)
    GridView gv;
    @Bind(R.id.ptr_Layout)
    PtrClassicFrameLayout pullToRefreshLayout;


    VerticalAdapter adapter_vertical;


    private ChooseDialog dialog_choose;

    private String[] data_choose1 = new String[]{
            "导入模板", "手动模式", "设备锁", "详情"
    };
    private String[] data_choose2 = new String[]{
            "导入模板", "手动模式", "设备锁", "工程锁", "详情"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygrouplist);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
        initData();
        initRefresh();
        initDialog();
    }

    //初始化数据
    private void initData() {
        final List<String> data2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            data2.add("测试数据" + i);
        }

        data2.add("添加");
        adapter_vertical = new VerticalAdapter(mActivity, data2);
        gv.setAdapter(adapter_vertical);
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i < data2.size() - 1) {
                    dialog_choose.show();
                }
                return true;
            }
        });
    }

    //初始化弹框
    private void initDialog() {
        dialog_choose = new ChooseDialog(mActivity);
        dialog_choose.refreshView(data_choose1);
        dialog_choose.setChooseItemClickListener(this);
    }

    //初始化下拉刷新
    private void initRefresh() {
        pullToRefreshLayout.setMode(PtrFrameLayout.Mode.BOTH);
        pullToRefreshLayout.disableWhenHorizontalMove(true);
        pullToRefreshLayout.setLastUpdateTimeRelateObject(this);
        pullToRefreshLayout.setPtrHandler(new PtrDefaultHandler2() {

            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                ToastUtil.showShort(mActivity, "加载更多");
                pullToRefreshLayout.refreshComplete();
//                pullToRefreshLayout.setMode(PtrFrameLayout.Mode.REFRESH);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ToastUtil.showShort(mActivity, "下拉刷新");
//                long time = System.currentTimeMillis();
//                if (time - lastRefrshTime < 1 * 1000) {
                pullToRefreshLayout.refreshComplete();
//                    return;
//                }
//                lastRefrshTime = time;
            }

            @Override
            public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
                return super.checkCanDoLoadMore(frame, gv, footer);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, gv, header);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void click(String type, String content, int index) {
        switch (content) {
            case "导入模板":
                GotoActivityManager.goFormworkActivity1(mActivity, "群组");
                break;

            case "手动模式":
                GotoActivityManager.goManualModeActivity(mActivity, "群组");
                break;

            case "设备锁":
                break;

            case "工程锁":
                break;

            case "详情":
                GotoActivityManager.goSceneDetailActivity(mActivity, "群组");
                break;

            case "删除":
                break;
        }
    }

    @OnClick({R.id.head_img_back, R.id.head_txt_others})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.head_txt_others:
                break;
        }
    }
}
