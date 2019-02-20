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
 * Created by Sefa on 10.08.2018.
 */

public class YemekTarifleri extends AppCompatActivity {
    List<Corbalar> corba = new ArrayList<>();
    List<TarifCorba> tariflist = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Context context = this;
    ListView list_yemektarifleri;

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
            "->Yarım limonun suyu",
            "---YAPILIŞI---",
            "Düdüklü tencerenin içine  yıkadığınız mercimekleri koyun . Üzerine soyduğunuz patates ve soğanı ikiye bölüm atın. Göz kararı tuzunuzu da attıktan sonra üzerine et suyu ile birlikte toplamda 7-8 bardak kadar suyu koyun. Tamamını et suyu da koyabilirsiniz.\n" +
                    "\n" +
                    "Hemen hemen 20 dakika da pişecek olan çorbanızı ocaktan aldıktan sonra blendırdan geçirin. Patates ve soğan iyice ezilsin.\n" +
                    "\n" +
                    "Dilerseniz üzerine salçalı yağdan sos hazırlayıp baharatlarla servis edebilirsiniz."};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemektarifleri);
        list_yemektarifleri = findViewById(R.id.listview_yemektarifleri);

        corba.add(new Corbalar("Tavuk Sote", R.drawable.yemek_tavuksote));
        corba.add(new Corbalar("Mücver(Müjver)", R.drawable.yemek_mucver));
        corba.add(new Corbalar("Bostan Patlıcan Kebabı", R.drawable.yemek_patlicankebab));
        corba.add(new Corbalar("Karnıyarık", R.drawable.yemek_karniyarik));
        corba.add(new Corbalar("Mercimek Köftesi", R.drawable.yemek_mercimekkofte));
        corba.add(new Corbalar("Kıymalı Yeşil Fasulye", R.drawable.yemek_yesilmercimek));


        CustomAdapter customAdapter = new CustomAdapter(context, corba);
        list_yemektarifleri.setAdapter(customAdapter);


        list_yemektarifleri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //bu bölümde tıklanılan çorbadan sonra alert dialog gelecek içerisinde listview olacak ve bilgiler array olarak tutulacak
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater ınflater = LayoutInflater.from(context);
                View alertview = ınflater.inflate(R.layout.custom_alertdialog, null);
                TextView alerttext = alertview.findViewById(R.id.textView_alert);
                ListView alertlist = alertview.findViewById(R.id.listView_alert);

                //kontrol edilerek yemek tarifleri yazılacak
                if(corba.get(i).getAdi().equals("Tavuk Sote")){

                    adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, names);
                    alertlist.setAdapter(adapter);
                    alerttext.setText(corba.get(i).getAdi().toString());

                    builder.setView(alertview);
                    builder.show();

                }




            }
        });

    }
}
