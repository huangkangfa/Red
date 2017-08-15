package app.temp.red.red.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hkf.coffee.phone.DensityUtil;
import com.hkf.coffee.phone.ScreenUtil;

import java.util.List;

import app.temp.red.red.R;

/**
 * 横向滑动菜单
 * Created by linkui on 2016/12/1.
 */

public class HorizontalMenu extends LinearLayout {
    private HorizontalScrollView horizontalScrollView;
    public RadioGroup optionRg;
    private int screenWidth;
    private int count=5;  //几等分

    public HorizontalMenu(Context context) {
        super(context);
        initView(context);

    }

    public HorizontalMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public HorizontalMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_horizontal_menu, this, true);
        optionRg = (RadioGroup) findViewById(R.id.option);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalscrollview);
        screenWidth = ScreenUtil.getWidth();
    }

    public void initMenu(List<String> nameList, int index){
        optionRg.removeAllViews();
        optionRg.setGravity(Gravity.CENTER);
        for (int i = 0; i < nameList.size(); i++) {
            RadioButton rb = (RadioButton) LayoutInflater.from(getContext()).inflate(R.layout.item_horzontal_menu, null);
            rb.setText(nameList.get(i));
            rb.setGravity(Gravity.CENTER);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(DensityUtil.dp2px(50), RadioGroup
                    .LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(DensityUtil.dp2px(5),0,DensityUtil.dp2px(5),0);
            rb.setMinimumWidth((int) (screenWidth / count));
            rb.setLayoutParams(layoutParams);
            rb.setTag(i);
            optionRg.addView(rb);
        }
        optionRg.setOnCheckedChangeListener(onCheckedChangeListener);
        if(index <nameList.size()){
            ((RadioButton) optionRg.getChildAt(index)).setChecked(true);
            horizontalScrollView.smoothScrollTo((int) (screenWidth / count)*index, 0);
        }else{
            if(nameList.size()>0){
                ((RadioButton) optionRg.getChildAt(0)).setChecked(true);
            }
        }

    }

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int RadiobuttonId = group.getCheckedRadioButtonId();
            RadioButton bt = (RadioButton) group.findViewById(RadiobuttonId);
            horizontalScrollView.smoothScrollTo(bt.getLeft() - (int) (screenWidth / count), 0);
            if(indexChangeCallBack != null){
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                int index = (int) radioButton.getTag();
                indexChangeCallBack.change(index);
            }
        }
    };

    /**
     * 移动到指定位置
     */
    public void setSmoothScrollTo(){

    }

    private IndexChangeCallBack indexChangeCallBack;

    public interface IndexChangeCallBack {
        void change(int index);
    }

    public void setIndexChangeCallBack(IndexChangeCallBack indexChangeCallBack) {
        this.indexChangeCallBack = indexChangeCallBack;
    }
}
