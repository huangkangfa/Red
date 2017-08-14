package app.temp.red.red.ui.dialog;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hkf.coffee.phone.DensityUtil;
import com.hkf.coffee.ui.activity.BaseActivity;
import com.hkf.coffee.ui.view.BaseDialog;

import app.temp.red.red.R;

/**
 * 底部上弹弹框
 * Created by Administrator on 2016/12/17.
 */
public class ChooseDialog extends BaseDialog {
    LinearLayout buttonLayout;
    TextView cancelTv;

    public ChooseDialog(BaseActivity activity) {
        super(activity);

        setContentView(R.layout.dialog_choose, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.BOTTOM);
        buttonLayout=findViewById(R.id.button_layout);
        cancelTv=findViewById(R.id.cancel);

        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void refreshView(final String[] data) {
        buttonLayout.removeAllViews();
        int size = data.length;
        if (size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            TextView textView = new TextView(mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,DensityUtil.dp2px(42));
            layoutParams.setMargins(0, DensityUtil.dp2px(5), 0, DensityUtil.dp2px(5));
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundColor(Color.parseColor("#00eeeeee"));
            final String content = data[i];
            textView.setText(content);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setTextSize(15);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.click(mType, content, finalI);
                    }
                    dismiss();
                }
            });
            buttonLayout.addView(textView);

            if (i<size-1) {
                View l = new View(mActivity);
                LinearLayout.LayoutParams line = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,DensityUtil.dp2px(1));
                line.setMargins(DensityUtil.dp2px(1),0,DensityUtil.dp2px(1), 0);
                l.setLayoutParams(line);
                l.setBackgroundColor(Color.parseColor("#e5e5e5"));
                buttonLayout.addView(l);
            }
        }
    }

    private ChooseItemClickListener mItemClickListener;
    private String mType;

    public interface ChooseItemClickListener {
        void click(String type, String content, int index);
    }


    public void setChooseItemClickListener(ChooseItemClickListener l) {
        mItemClickListener = l;
    }


    public void setType(String type) {
        mType = type;
    }
}
