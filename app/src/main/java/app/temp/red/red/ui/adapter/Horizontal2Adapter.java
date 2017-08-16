package app.temp.red.red.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import app.temp.red.red.R;

/**
 *
 * Created by huangkangfa on 2017/8/11.
 */
public class Horizontal2Adapter extends BaseAdapter{
    private Context context;
    private List<String> data;

    public Horizontal2Adapter(Context context, List<String> data){
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
        ViewHolder holder=null;
        if(view==null){
            holder=new ViewHolder();
            view=View.inflate(context, R.layout.item_adapter_horizontal2,null);
            holder.rl=view.findViewById(R.id.ll1);
            holder.txt=view.findViewById(R.id.ll1_txt);
            holder.ll1_choose=view.findViewById(R.id.ll1_choose);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }

        holder.txt.setText(data.get(i));

        return view;
    }

    static class ViewHolder{
        RelativeLayout rl;
        TextView txt;
        TextView ll1_choose;
    }

}
