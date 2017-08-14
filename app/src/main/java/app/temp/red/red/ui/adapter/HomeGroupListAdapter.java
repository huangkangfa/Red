package app.temp.red.red.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.temp.red.red.R;

/**
 * Created by huangkangfa on 2017/8/10.
 */

public class HomeGroupListAdapter extends BaseAdapter{
    private Context context;
    private List<String> data;

    public HomeGroupListAdapter(Context context,List<String> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder hodler=null;
        if(view==null){
            hodler=new ViewHolder();
            view=View.inflate(context, R.layout.adapter_item_grouplist,null);
            hodler.txt=view.findViewById(R.id.txt);
            view.setTag(hodler);
        }else{
            hodler= (ViewHolder) view.getTag();
        }
        String name=data.get(i);
        hodler.txt.setText(name);
        return view;
    }

    static class ViewHolder{
        TextView txt;
    }
}
