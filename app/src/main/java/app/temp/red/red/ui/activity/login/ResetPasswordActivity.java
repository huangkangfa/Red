package app.temp.red.red.ui.activity.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.others.ToastUtil;
import com.hkf.coffee.ui.activity.BaseFragmentActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * 重置密码界面
 * Created by huangkangfa on 2017/8/6.
 */
public class ResetPasswordActivity extends BaseFragmentActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.img_reset_phone)
    ImageView imgResetPhone;
    @Bind(R.id.et_reset_phone)
    EditText etResetPhone;
    @Bind(R.id.search_iv_delete)
    ImageView searchIvDelete;
    @Bind(R.id.rl_reset_phone)
    RelativeLayout rlResetPhone;
    @Bind(R.id.tv_black2)
    TextView tvBlack2;
    @Bind(R.id.img_reset_code)
    ImageView imgResetCode;
    @Bind(R.id.et_code)
    EditText etCode;
    @Bind(R.id.tv_code_thread)
    TextView tvCodeThread;
    @Bind(R.id.tv_code)
    TextView tvCode;
    @Bind(R.id.rl_reset_code)
    RelativeLayout rlResetCode;
    @Bind(R.id.tv_black3)
    TextView tvBlack3;
    @Bind(R.id.btn_entry)
    Button btnEntry;


    private TimeCount timeCount = new TimeCount(60000, 1000);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
    }

    @OnClick({R.id.head_img_back,R.id.et_reset_phone, R.id.search_iv_delete, R.id.et_code,R.id.tv_code,R.id.btn_entry})
    public void onViewClicked(View view) {
        ToastUtil.showShort(mActivity, "店家");
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.et_reset_phone:
                etResetPhone.addTextChangedListener(new EditChangedListener());
                break;
            case R.id.search_iv_delete:
                etResetPhone.setText("");
                searchIvDelete.setVisibility(GONE);
                break;
            case R.id.et_code:
                //验证码填入框
                break;
            case R.id.tv_code:
                timeCount.start();
                break;
            case R.id.btn_entry:
                GotoActivityManager.goResetPassword2Activity(ResetPasswordActivity.this);
                break;
        }
    }

    private class EditChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            searchIvDelete.setVisibility("".equals(charSequence.toString()) ? View.GONE : View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tvCode.setClickable(false);
            tvCode.setText(millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            tvCode.setText("重新获取");
            tvCode.setClickable(true);
        }
    }

}