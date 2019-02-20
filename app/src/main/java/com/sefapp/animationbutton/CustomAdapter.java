package com.sefapp.animationbutton;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 4.08.2018.
 */

public class CustomAdapter extends BaseAdapter {


    List<Corbalar> corba = new ArrayList<>();
    LayoutInflater ınflater;
    Context context;

    public CustomAdapter( Context context, List<Corbalar> yemek) {
        this.corba = yemek;
        this.context = context;
    }

    @Override
    public int getCount() {
        return corba.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ınflater = LayoutInflater.from(context);
        View satir =ınflater.inflate(R.layout.satir,null);
        TextView textView =satir.findViewById(R.id.textView_satir);
        ImageView ımageView = satir.findViewById(R.id.imageView_satir);
        Corbalar corbalar =corba.get(i);
        textView.setText(corbalar.getAdi());
       ımageView.setImageResource(corbalar.getResim());


        return satir;
    }
}
