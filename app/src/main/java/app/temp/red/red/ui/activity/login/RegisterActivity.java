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
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseFragmentActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * 注册界面
 * Created by huangkangfa on 2017/8/6.
 */
public class RegisterActivity extends BaseFragmentActivity {

    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.tv_code)
    TextView tvCode;
    @Bind(R.id.btn_entry)
    Button btnEntry;
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.number)
    EditText number;
    @Bind(R.id.search_iv_delete)
    ImageView searchIvDelete;

    private TimeCount timeCount = new TimeCount(60000, 1000);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
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

    @OnClick({R.id.tv_code, R.id.btn_entry, R.id.head_img_back,R.id.number, R.id.search_iv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                timeCount.start();
                break;
            case R.id.btn_entry:
                //注册
                break;
            case R.id.head_img_back:
                finish();
                break;
            case R.id.number:
                number.addTextChangedListener(new EditChangedListener());
                break;
            case R.id.search_iv_delete:
                number.setText("");
                searchIvDelete.setVisibility(GONE);
                break;
        }
    }

}
