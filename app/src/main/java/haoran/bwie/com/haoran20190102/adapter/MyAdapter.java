package haoran.bwie.com.haoran20190102.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import haoran.bwie.com.haoran20190102.R;
import haoran.bwie.com.haoran20190102.bean.MyBeam;

public class MyAdapter extends BaseAdapter {
    private List<MyBeam.DataBean.MiaoshaBean> list;
    private Context context;

    public MyAdapter(List<MyBeam.DataBean.MiaoshaBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_style, null);
            ViewHolder viewHolder1 = new ViewHolder();
            viewHolder1.imageView = convertView.findViewById(R.id.item_image);
            viewHolder1.name = convertView.findViewById(R.id.item_name);
            viewHolder1.price = convertView.findViewById(R.id.item_price);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getList().get(position).getImages()).into(viewHolder.imageView);
        viewHolder.name.setText(list.get(position).getList().get(position).getTitle());
        viewHolder.price.setText(list.get(position).getList().get(position).getPrice());
        return null;
    }

    class ViewHolder {
        ImageView imageView;
        TextView name;
        TextView price;
    }
}
