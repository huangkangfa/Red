package app.temp.red.red.ui.dialog;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.phone.DensityUtil;
import com.hkf.coffee.ui.activity.BaseActivity;
import com.hkf.coffee.ui.view.BaseDialog;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.ui.adapter.HomeGroupListAdapter;

/**
 * 底部上弹弹框
 * Created by Administrator on 2016/12/17.
 */
public class GroupListDialog extends BaseDialog {
    ListView groupList;   //群组列表展示
    TextView groupIndex;
    RelativeLayout rl;

    private HomeGroupListAdapter adapter_group;
    private List<String> data_group;

    public GroupListDialog(BaseActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_grouplist,MATCH_PARENT,MATCH_PARENT);

        groupList=findViewById(R.id.groupList);
        groupIndex=findViewById(R.id.title);
        rl=findViewById(R.id.rl);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) groupIndex.getLayoutParams();
        layoutParams.setMargins(DensityUtil.dp2px(10), DensityUtil.dp2px(38), 0, 0);
        groupIndex.setLayoutParams(layoutParams);

        //群组列表初始化
        data_group = new ArrayList<>();
        adapter_group = new HomeGroupListAdapter(mActivity, data_group);
        groupList.setAdapter(adapter_group);

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    /**
     * 设置列表数据
     * @param data
     */
    public void setData(List<String> data){
        data_group.clear();
        data_group.addAll(data);
        adapter_group.notifyDataSetChanged();
    }

    /**
     * 设置列表短点击监听
     * @param listener
     */
    public void setGroupListOnItemClickListener(AdapterView.OnItemClickListener listener){
        groupList.setOnItemClickListener(listener);
    }

    /**
     * 设置列表长点击监听
     * @param listener
     */
    public void setGroupListOnItemLongClickListener(AdapterView.OnItemLongClickListener listener){
        groupList.setOnItemLongClickListener(listener);
    }

    /**
     * 设置标题文本
     * @param txt
     */
    public void setTitleText(String txt){
        groupIndex.setText(txt);
    }

    /**
     * 设置标题监听
     * @param listener
     */
    public void setGroupIndexListener(View.OnClickListener listener){
        groupIndex.setOnClickListener(listener);
    }

    private int getStatusBarHeight() {
        Resources resources = mActivity.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}
