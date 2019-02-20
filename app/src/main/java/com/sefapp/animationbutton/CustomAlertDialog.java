package com.sefapp.animationbutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 8.08.2018.
 */

public class CustomAlertDialog extends BaseAdapter {

    List<TarifCorba> tarifCorbaList = new ArrayList<>();
    LayoutInflater ınflater;
    Context context;

    public CustomAlertDialog(Context context, List<TarifCorba> tarifCorbaList) {
        this.tarifCorbaList = tarifCorbaList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tarifCorbaList.size();
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
        View tarif =ınflater.inflate(R.layout.activity_alertdialog,null);
        TextView textView = tarif.findViewById(R.id.textView_alert);

        TarifCorba tarifCorba = tarifCorbaList.get(i);
        textView.setText(tarifCorba.getAdi());
        return tarif;
    }
}
