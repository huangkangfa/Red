package app.temp.red.red.ui.dialog;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hkf.coffee.phone.DensityUtil;
import com.hkf.coffee.ui.activity.BaseActivity;
import com.hkf.coffee.ui.view.BaseDialog;

import app.temp.red.red.R;

/**
 * 提示通用弹窗
 * Created by linkui on 2016/12/7.
 */

public class HintDialog extends BaseDialog {
    TextView tv_title;
    TextView tv_content;
    Button btn_yes;
    Button btn_left;
    Button btn_right;

    public HintDialog(BaseActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_hint, DensityUtil.dp2px(260), WRAP_CONTENT, true);
        setGravity(Gravity.CENTER);
        tv_title=findViewById(R.id.tv_title);
        tv_content=findViewById(R.id.tv_content);
        btn_yes=findViewById(R.id.btn_yes);
        btn_left=findViewById(R.id.btn_left);
        btn_right=findViewById(R.id.btn_right);
        initListener();
    }

    private void initListener() {
        btn_yes.setOnClickListener(onClickListener);
        btn_left.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

    /**
     * 设置标题 默认隐藏
     * @param title
     */
    public void setTitle(String title){
        tv_title.setVisibility(View.VISIBLE);
        tv_title.setText(title);
    }
    /**
     * 设置内容
     * @param content
     */
    public void setContent(CharSequence content){
        tv_content.setText(content);
    }
    /**
     * 设置内容 对齐方式 默认居中
     * @param Gravity
     */
    public void setContentGravity(int Gravity){
        tv_content.setGravity(Gravity);
    }
    public void setRightBtnText(String text){
        btn_yes.setVisibility(View.GONE);
        btn_left.setVisibility(View.VISIBLE);
        btn_right.setVisibility(View.VISIBLE);
        btn_right.setText(text);
    }
    public void setCenterBtnText(String text){
        btn_yes.setVisibility(View.VISIBLE);
        btn_left.setVisibility(View.GONE);
        btn_right.setVisibility(View.GONE);
        btn_yes.setText(text);
    }
    public void setRightBtnOnClick(View.OnClickListener onClickListener){
        btn_right.setOnClickListener(onClickListener);
    }
    public void setMidBtnOnClick(View.OnClickListener onClickListener){
        btn_yes.setOnClickListener(onClickListener);
    }
}
