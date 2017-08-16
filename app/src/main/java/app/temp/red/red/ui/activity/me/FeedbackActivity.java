package app.temp.red.red.ui.activity.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 反馈界面
 * Created by huangkangfa on 2017/8/9.
 */
public class FeedbackActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.et_feedback)
    EditText etFeedback;
    @Bind(R.id.txt_number)
    TextView txtNumber;
    @Bind(R.id.btn_feedback)
    Button btnFeedback;

    private static int NUMBER = 150;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        headTxtTitle.setText("建议与反馈");
    }


    @OnClick({R.id.head_img_back, R.id.et_feedback, R.id.btn_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.et_feedback:
                etFeedback.addTextChangedListener(new TextWatcher() {
                    private CharSequence temp;
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }
                    @Override
                    public void afterTextChanged(Editable editable) {
                        int num = NUMBER - editable.toString().length();
                        txtNumber.setText(num+"");
                    }
                });
                break;
            case R.id.btn_feedback:
                //提交
                break;
        }
    }

}
