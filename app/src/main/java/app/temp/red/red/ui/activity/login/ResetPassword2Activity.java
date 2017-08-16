package app.temp.red.red.ui.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.others.ToastUtil;
import com.hkf.coffee.ui.activity.BaseFragmentActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 重置密码界面2
 * Created by huangkangfa on 2017/8/6.
 */
public class ResetPassword2Activity extends BaseFragmentActivity {

    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.new_password)
    EditText newPassword;
    @Bind(R.id.sure_newpassword)
    EditText sureNewpassword;
    @Bind(R.id.btn_entry)
    Button btnEntry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword2);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));

    }

    @OnClick({R.id.head_img_back,R.id.new_password,  R.id.sure_newpassword,  R.id.btn_entry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.new_password:
             //填写新密码
                break;
            case R.id.sure_newpassword:
                //确认新密码
                break;
            case R.id.btn_entry:
                if(newPassword.getText().toString().equals(sureNewpassword.getText().toString())){

                }else {
                    ToastUtil.showShort(mActivity,"两次密码输入不一致，请重新输入");
                }
                //确定
                break;
        }
    }

}
