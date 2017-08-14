package app.temp.red.red.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/4/1.
 */

public class LeftMenuView extends LinearLayout{

    public LeftMenuView(Context context) {
        super(context);
        initView(context);
    }

    public LeftMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LeftMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initData() {

    }

    private void initView(Context context) {
//        LayoutInflater.from(context).inflate(R.layout.view_home_left,this,true);
    }

}
