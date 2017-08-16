package app.temp.red.red.ui.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.bitmap.BitmapManager;
import com.hkf.coffee.ui.activity.BaseFragmentActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * 登录界面
 * Created by huangkangfa on 2017/8/6.
 */
public class LoginActivity extends BaseFragmentActivity {

    @Bind(R.id.register)
    TextView register;
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headImgOthers;
    @Bind(R.id.btn_entry)
    Button btnEntry;
    @Bind(R.id.icon)
    ImageView icon;
    @Bind(R.id.number)
    EditText number;
    @Bind(R.id.search_iv_delete)
    ImageView searchIvDelete;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.img_show)
    ImageView imgShow;
    @Bind(R.id.forget_password)
    TextView forgetPassword;

    private boolean idHidden = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        headImgBack.setVisibility(GONE);
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
        headImgOthers.setVisibility(GONE);
        BitmapManager.displayRound(mActivity, icon, 100, R.drawable.ic_pic_loding);
    }

    @OnClick({R.id.register, R.id.btn_entry, R.id.number, R.id.search_iv_delete, R.id.img_show,R.id.forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.number:
                number.addTextChangedListener(new EditChangedListener());
                break;
            case R.id.search_iv_delete:
                number.setText("");
                searchIvDelete.setVisibility(GONE);
                break;
            case R.id.register:
                GotoActivityManager.goRegisterActivity(LoginActivity.this);
                break;
            case R.id.btn_entry:
                GotoActivityManager.goHomeActivity(LoginActivity.this);
                break;
            case R.id.img_show:
                if (idHidden) {
                    Log.e("123", "1");
                    //设置EditText文本为可见的
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    Log.e("123", "2");
                    //设置EditText文本为隐藏的
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                idHidden = !idHidden;
                etPassword.postInvalidate();
                //切换后将EditText光标置于末尾
                CharSequence charSequence = etPassword.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
                break;
            case R.id.forget_password:
                GotoActivityManager.goResetPasswordActivity(LoginActivity.this);
                break;
        }
    }




    private class EditChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            searchIvDelete.setVisibility("".equals(charSequence.toString())?View.GONE:View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }

}
