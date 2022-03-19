package com.example.gridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class productAdapter extends BaseAdapter {

    private Context context;
    private int Layout;
    private List<product> listProduct;

    public productAdapter(Context context, int layout, List<product> listProduct) {
        this.context = context;
        Layout = layout;
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(Layout, null);

        TextView txtHeader = view.findViewById(R.id.textView_Header);
        TextView txtDes = view.findViewById(R.id.textView_des);
        TextView txtPrice = view.findViewById(R.id.textView_Price);
        ImageView imgMain = view.findViewById(R.id.imgView_main);

        product donutItem = listProduct.get(i);
        txtHeader.setText(donutItem.getDonutName());
        txtDes.setText(donutItem.getDonutDes());
        txtPrice.setText(donutItem.getDonutPrice());
        imgMain.setImageResource(donutItem.getDonutImg());

        return view;
    }
}
