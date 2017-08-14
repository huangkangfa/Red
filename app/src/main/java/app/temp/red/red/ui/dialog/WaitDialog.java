package app.temp.red.red.ui.dialog;

import android.os.Handler;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;
import com.hkf.coffee.ui.view.BaseDialog;

import app.temp.red.red.R;
import butterknife.Bind;

/**
 * 等待弹框
 * @author wanglei 2014年12月14日 下午6:55:31
 */
public class WaitDialog extends BaseDialog {
    @Bind(R.id.content)
    TextView contentTv;

    private Handler handler = new Handler();

    public WaitDialog(BaseActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_wait, WRAP_CONTENT, WRAP_CONTENT, false);
    }


    /**
     * 显示弹框
     */
    public static WaitDialog show(BaseActivity activity) {
        WaitDialog dialog = new WaitDialog(activity);
        dialog.show();
        return dialog;
    }

    public void show(int time) {
        show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, time);
    }


    public void setContent(String content) {
        contentTv.setText(content);
    }
}
