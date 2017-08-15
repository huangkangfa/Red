package app.temp.red.red.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.bitmap.BitmapManager;

import java.util.List;

import app.temp.red.red.R;

/**
 *
 * Created by huangkangfa on 2017/8/11.
 */
public class VerticalAdapter extends BaseAdapter{
    private Context context;
    private List<String> data;

    public VerticalAdapter(Context context,List<String> data){
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
            view=View.inflate(context, R.layout.item_adapter_vertical,null);
            holder.rl=view.findViewById(R.id.rl);
            holder.img=view.findViewById(R.id.item_img);
            holder.txt_d=view.findViewById(R.id.item_txt_d);
            holder.txt_t=view.findViewById(R.id.item_txt_t);
            holder.ll_t=view.findViewById(R.id.item_ll_t);
            holder.add=view.findViewById(R.id.tv_add);
            holder.btn_open=view.findViewById(R.id.btn_open);
            holder.btn_close=view.findViewById(R.id.btn_close);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.txt_d.setText(data.get(i));
        BitmapManager.displayCircular(context,holder.img,R.mipmap.ic_launcher);
        if (i==data.size()-1){
            holder.img.setVisibility(View.GONE);
            holder.txt_t.setVisibility(View.GONE);
            holder.txt_d.setVisibility(View.GONE);
            holder.ll_t.setVisibility(View.GONE);
            holder.add.setVisibility(View.VISIBLE);
            holder.add.setText(data.get(i));
        }
        return view;
    }

    static class ViewHolder{
        private RelativeLayout rl;
        private LinearLayout ll_t;
        private ImageView img;
        private TextView txt_t;
        private TextView txt_d;
        private TextView add;
        private ImageView btn_open;
        private ImageView btn_close;
    }
}
