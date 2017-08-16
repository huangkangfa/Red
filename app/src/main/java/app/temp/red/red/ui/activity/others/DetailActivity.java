package app.temp.red.red.ui.activity.others;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.bitmap.BitmapManager;
import com.hkf.coffee.intent.IntentManager;
import com.hkf.coffee.others.log.LogUtil;
import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hkf.coffee.intent.IntentManager.onActivityResult_SysBitmapIntent;

/**
 * 场景详情界面
 * Created by huangkangfa on 2017/8/15.
 */
public class DetailActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.ll1)
    RelativeLayout ll1;
    @Bind(R.id.ll2)
    RelativeLayout ll2;
    @Bind(R.id.ll3)
    RelativeLayout ll3;
    @Bind(R.id.img)
    ImageView img;

    private boolean isCanEdit;  //是否处于编辑模式

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
        headTxtOthers.setVisibility(View.VISIBLE);
        headTxtOthers.setText("编辑");
        isCanEdit = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.head_img_back, R.id.head_txt_others, R.id.ll1, R.id.ll2, R.id.ll3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.head_txt_others:
                if (isCanEdit) {
                    //保存操作
                    //...
                    headTxtOthers.setText("编辑");
                } else {
                    headTxtOthers.setText("保存");
                }
                isCanEdit = !isCanEdit;
                break;
            case R.id.ll1:
                //修改昵称
                break;
            case R.id.ll2:
                //更换图片
                if (isCanEdit) {
                    IntentManager.goSysBitmapIntent(mActivity, getPicture);
                }
                break;
            case R.id.ll3:
                //当前设备数量---暂不处理
                break;
        }
    }

    private final int getPicture = 101;  //获取图片标识

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == getPicture) {
            try {
                String url = onActivityResult_SysBitmapIntent(mActivity, data).getPath();
                BitmapManager.display(mActivity,img,url);
            } catch (Exception e) {
                LogUtil.e("照片获取失败："+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
