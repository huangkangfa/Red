package app.temp.red.red.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 昵称修改界面
 * Created by huangkangfa on 2017/8/9.
 */
public class SetNameActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.et_setname)
    EditText etSetname;

    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setname);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
        headTxtOthers.setText("保存");
        headTxtOthers.setVisibility(View.VISIBLE);
        init();
    }

    private void init() {
        name = getIntent().getStringExtra("name");
        etSetname.setText(name);
        etSetname.setSelection(etSetname.getText().length());
    }



    @OnClick({R.id.head_img_back, R.id.head_txt_others})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.head_txt_others:
                String str_name = etSetname.getText().toString();
                Intent data = new Intent();
                data.putExtra("name", str_name);
                setResult(20, data);
                finish();
                break;
        }
    }
}
