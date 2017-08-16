package app.temp.red.red.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.entry.ExpandableListViewChildItemData;
import app.temp.red.red.entry.ExpandableListViewItemData;

/**
 * Created by huangkangfa on 2017/8/16.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<ExpandableListViewItemData> data;

    public ExpandableListViewAdapter(Context context,List<ExpandableListViewItemData> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return data.get(i).getData().size();
    }

    @Override
    public Object getGroup(int i) {
        return data.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return data.get(i).getData().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override   //是否给定分组视图及其子元素视图的ID对应的后台数据改变而保持该ID不变
    public boolean hasStableIds() {
        return true;
    }

    @Override   //指定分组中指定子元素视图是否可以被选择
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ParentViewHolder parentViewHolder=null;
        if(view==null){
            view=View.inflate(context, R.layout.item_expandable_adapter_horizontal,null);
            parentViewHolder=new ParentViewHolder();
            parentViewHolder.name=view.findViewById(R.id.ll1_txt);
            parentViewHolder.select=view.findViewById(R.id.ll1_choose);
            view.setTag(parentViewHolder);
        }else{
            parentViewHolder= (ParentViewHolder) view.getTag();
        }
        if (data.size()!=0) {
            parentViewHolder.name.setText(data.get(i).getName());
            final int finalI=i;
            parentViewHolder.select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean b=!data.get(finalI).isSelected();
                    setChildAll(finalI,b);
                    data.get(finalI).setSelected(b);
                }
            });
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder=null;
        if(view==null){
            view=View.inflate(context,R.layout.item_expandable_adapter_horizontal2,null);
            childViewHolder=new ChildViewHolder();
            childViewHolder.name=view.findViewById(R.id.ll_txt);
            childViewHolder.checkBox=view.findViewById(R.id.ll_choose);
            view.setTag(childViewHolder);
        }else{
            childViewHolder= (ChildViewHolder) view.getTag();
        }
        if (data.get(i).getData().size()!=0) {
            childViewHolder.name.setText(data.get(i).getData().get(i1).getName());
            childViewHolder.checkBox.setChecked(data.get(i).getData().get(i1).isSelected());
            final int finalI=i;
            final int finalI1=i1;
            childViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    data.get(finalI).getData().get(finalI1).setSelected(b);
                    boolean kb=true;
                    for(int k=0;k<data.get(finalI).getData().size();k++){
                        if(!data.get(finalI).getData().get(k).isSelected()){
                            kb=false;
                            break;
                        }
                    }
                    data.get(finalI).setSelected(kb);
                }
            });
        }
        return view;
    }

    //设置对应子项全选或全取消
    private void setChildAll(int i,boolean flag){
        List<ExpandableListViewChildItemData> x=data.get(i).getData();
        for(int j=0;j<x.size();j++){
            x.get(j).setSelected(flag);
        }
        notifyDataSetChanged();
    }

    static class ParentViewHolder{
        TextView name;
        TextView select;
    }

    static class ChildViewHolder{
        TextView name;
        CheckBox checkBox;
    }
}
