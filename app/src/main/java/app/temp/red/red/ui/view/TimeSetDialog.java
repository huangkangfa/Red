package app.temp.red.red.ui.view;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.geek.chenming.wheelview.view.LoopView;
import com.hkf.coffee.others.ToastUtil;
import com.hkf.coffee.phone.ScreenUtil;
import com.hkf.coffee.ui.activity.BaseActivity;
import com.hkf.coffee.ui.view.BaseDialog;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;

/**
 * 延时时间选择
 * Created by Administrator on 2016/12/22.
 */

public class TimeSetDialog extends BaseDialog {
    TextView title;      //标题
    TextView cancelTv;   //取消
    TextView confirmTv;  //确定
    LoopView loopView1;  //时间轮滑1
    LoopView loopView2;  //时间轮滑2
    LoopView loopView3;  //时间轮滑3

    private List<String> datas1=new ArrayList<>(); ;
    private List<String> datas2=new ArrayList<>();;
    private List<String> datas3=new ArrayList<>();;

    public TimeSetDialog(BaseActivity activity) {
        super(activity);

        setContentView(R.layout.dialog_time_set, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.BOTTOM);
        title=findViewById(R.id.title);
        cancelTv=findViewById(R.id.cancel);
        confirmTv=findViewById(R.id.confirm);
        loopView1=findViewById(R.id.time_loop1);
        loopView2=findViewById(R.id.time_loop2);
        loopView3=findViewById(R.id.time_loop3);

        initData();
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        confirmTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setClickListener != null) {
                    int index1 = loopView1.getSelectedItem();
                    int index2 = loopView2.getSelectedItem();
                    int index3 = loopView3.getSelectedItem();
                    if(index2<=index1){
                        ToastUtil.showShort(getContext(),"结束时间必须大于开始时间");
                    }else{
                        setClickListener.click(datas1,datas2,datas3,index1,index2,index3);
                        dismiss();
                    }
                }else{
                    dismiss();
                }
            }
        });
    }

    private void initData() {
        datas1.clear();
        datas2.clear();
        datas3.clear();
        datas1.add("00:00");
        datas1.add("00:30");
        datas1.add("01:00");
        datas1.add("01:30");
        datas1.add("02:00");
        datas1.add("02:30");
        datas1.add("03:00");
        datas1.add("03:30");
        datas1.add("04:00");
        datas1.add("04:30");
        datas1.add("05:00");
        datas1.add("05:30");
        datas1.add("06:00");
        datas1.add("06:30");
        datas1.add("07:00");
        datas1.add("07:30");
        datas1.add("08:00");
        datas1.add("08:30");
        datas1.add("09:00");
        datas1.add("09:30");
        datas1.add("10:00");
        datas1.add("10:30");
        datas1.add("11:00");
        datas1.add("11:30");
        datas1.add("12:00");
        datas1.add("12:30");
        datas1.add("13:00");
        datas1.add("13:30");
        datas1.add("14:00");
        datas1.add("14:30");
        datas1.add("15:00");
        datas1.add("15:30");
        datas1.add("16:00");
        datas1.add("16:30");
        datas1.add("17:00");
        datas1.add("17:30");
        datas1.add("18:00");
        datas1.add("18:30");
        datas1.add("19:00");
        datas1.add("19:30");
        datas1.add("20:00");
        datas1.add("20:30");
        datas1.add("21:00");
        datas1.add("21:30");
        datas1.add("22:00");
        datas1.add("22:30");
        datas1.add("23:00");
        datas1.add("23:30");
        datas1.add("24:00");

        loopView1.setNotLoop();
        loopView1.measuredWidth = ScreenUtil.getWidth()/3;
        loopView1.setTextSize(18);
        loopView1.setItems(datas1);
        loopView1.setCenterColor(Color.parseColor("#ffffff"));
        loopView1.setInitPosition(12);

        datas2.addAll(datas1);

        loopView2.setNotLoop();
        loopView2.measuredWidth = ScreenUtil.getWidth()/3;
        loopView2.setTextSize(18);
        loopView2.setItems(datas2);
        loopView2.setCenterColor(Color.parseColor("#ffffff"));
        loopView2.setInitPosition(13);

        for(int i=0;i<31;i++){
            datas3.add((i+5)+"℃");
        }
        loopView3.setNotLoop();
        loopView3.measuredWidth = ScreenUtil.getWidth()/3;
        loopView3.setTextSize(18);
        loopView3.setItems(datas3);
        loopView3.setCenterColor(Color.parseColor("#ffffff"));
        loopView3.setInitPosition(20);
    }

    private SetClickListener setClickListener;

    public interface SetClickListener {
        void click(List<String> dataList1,List<String> dataList2,List<String> dataList3, int index1, int index2, int index3);
    }

    public void setSelectItemClickListener(SetClickListener l) {
        setClickListener = l;
    }
}
