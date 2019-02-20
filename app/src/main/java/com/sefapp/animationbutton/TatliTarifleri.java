package com.sefapp.animationbutton;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 11.08.2018.
 */

public class TatliTarifleri extends AppCompatActivity {
    List<Corbalar> corba = new ArrayList<>();
    List<TarifCorba> tariflist = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Context context = this;
    ListView list_tatlitarifleri;

    String[] names = {"->1 su bardağı kadar kırmızı mercimek",
            "->1,5 yemek kaşığı kadar bulgur",
            "->1,5 yemek kaşığı kadar pirinç",
            "->1 adet soğan",
            "->2 ya da 3 diş sarımsak",
            "->4 ya da 5 yemek kaşığı kadar sıvı yağ",
            "->1 yemek kaşığı kadar domates salçası",
            "->8 su bardağı kadar su ya da tavuk suyu (1 su bardağı 200 ml.)\n",
            "->Bir tutam tuz",
            "->Bir tutam pul biber",
            "->Bir tutam kekik",
            "->Bir tutam nane",
            "->Yarım limonun suyu",};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tatlitarifleri);

        list_tatlitarifleri = findViewById(R.id.listview_tatlitarifleri);

        corba.add(new Corbalar("Tavuk Sote", R.drawable.yemek_tavuksote));
        corba.add(new Corbalar("Mücver(Müjver)", R.drawable.yemek_mucver));
        corba.add(new Corbalar("Bostan Patlıcan Kebabı", R.drawable.yemek_patlicankebab));
        corba.add(new Corbalar("Karnıyarık", R.drawable.yemek_karniyarik));
        corba.add(new Corbalar("Mercimek Köftesi", R.drawable.yemek_mercimekkofte));
        corba.add(new Corbalar("Kıymalı Yeşil Fasulye", R.drawable.yemek_yesilmercimek));


        CustomAdapter customAdapter = new CustomAdapter(context, corba);
        list_tatlitarifleri.setAdapter(customAdapter);


        list_tatlitarifleri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //bu bölümde tıklanılan çorbadan sonra alert dialog gelecek içerisinde listview olacak ve bilgiler array olarak tutulacak
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater ınflater = LayoutInflater.from(context);
                View alertview = ınflater.inflate(R.layout.custom_alertdialog, null);
                TextView alerttext = alertview.findViewById(R.id.textView_alert);
                ListView alertlist = alertview.findViewById(R.id.listView_alert);


                adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, names);
                alertlist.setAdapter(adapter);


                // tariflist.add(new TarifCorba("sefa"));

                //CustomAlertDialog customAlertDialog = new CustomAlertDialog(context, tariflist);
                // alertlist.setAdapter(customAlertDialog);

                alerttext.setText(corba.get(i).getAdi().toString());
                builder.setView(alertview);
                builder.show();

            }
        });



    }
}
