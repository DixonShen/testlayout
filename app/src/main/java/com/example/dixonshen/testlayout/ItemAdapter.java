package com.example.dixonshen.testlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Z003R98D on 2/28/2017.
 */

public class ItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<InfoItem> mItems;

    public ItemAdapter(Context context, List<InfoItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public int getCount(){
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        TextView content;
        if (mItems.get(position).getHasSubItem()) {

        } else {

        }
        return converView;
    }
}
