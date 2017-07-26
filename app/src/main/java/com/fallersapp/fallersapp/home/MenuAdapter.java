package com.fallersapp.fallersapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fallersapp.fallersapp.R;

import java.util.ArrayList;

/**
 * Created by hamda on 26/07/2017.
 */

public class MenuAdapter extends BaseAdapter {
    Context context;
    ArrayList<mMenu> arrayList;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<mMenu> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<mMenu> arrayList) {
        this.arrayList = arrayList;
    }

    public MenuAdapter(Context context, ArrayList<mMenu> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mView = view;
        ViewHolder holder = new ViewHolder();

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_menu, null);
        }

        holder.menu = (TextView) view.findViewById(R.id.menu);
        holder.icon = (ImageView) view.findViewById(R.id.icon);

        mMenu menu = arrayList.get(i);

        holder.menu.setText(menu.getMenu());
        holder.icon.setImageResource(menu.getIcon());

        return view;
    }

    public class ViewHolder{
        TextView menu;
        ImageView icon;
    }
}
