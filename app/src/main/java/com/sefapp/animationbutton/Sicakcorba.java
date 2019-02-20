package com.sefapp.animationbutton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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
 * Created by Sefa on 4.08.2018.
 */

public class Sicakcorba extends AppCompatActivity{
    List<Corbalar> corba = new ArrayList<>();
    List<TarifCorba> tariflist = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView liste;
    Context context = this;
    String[] ezogelin = {"Malzemeleri:",
            "->1 su bardağı kırmızı mercimek",
            "->2 yemek kaşığı pirinç",
            "->2 tatlı kaşığı bulgur",
            "->1 adet soğan",
            "->6 su bardağı sıcak su",
            "->1 yemek kaşığı salça",
            "->1 tatlı kaşığı tuz ",
            "->1 yemek kaşığı tereyağı",
            "Üzeri için:",
            "->1 tatlı kaşığı pul biber",
            "->1 tatlı kaşığı nane",
            "Nasıl yapılır?",
            "->Ortaboy bir tencereye yıkayıp süzdüğünüz mercimek, bulgur ve pirinci koyun. Üzerine suyu da ekleyerek haşlanmaya bırakın. Bu sırada başka bir ocakta tereyağı ile doğradığınız soğanları kavurun. Soğanların rengi dönmeden salçayı biraz sulandırıp ekleyin. Pişen salçalı karışımı mercimekli karışımın haşlandığı tencereye boşaltıp karıştırın. Çorbanın tuzunu atın. Malzemeler bütünleşecek. Yaklaşık 10 dakika pişirip kaynatın. Blendır kullanarak damak tadınıza göre malzemelerin iriliğini ayarlayın. Üzerine nane ve pul biber dökerek servis edebilirsiniz. Afiyet olsun..."};

    String[] mercimek = {"Malzemeleri:",
            "->1 su bardağı kırmızı mercimek",
            "->1 kuru soğan",
            "->1 yemek kaşığı un",
            "->1 patates",
            "->Et suyu",
            "->2 kaşık yağ",
            "->1 tatlı kaşığı tuz ",
            "->Salça",
            "Üzeri için:",
            "->Baharat",
            "Nasıl yapılır?",
            "->Düdüklü tencerenin içine  yıkadığınız mercimekleri koyun . Üzerine soyduğunuz patates ve soğanı ikiye bölüm atın. Göz kararı tuzunuzu da attıktan sonra üzerine et suyu ile birlikte toplamda 7-8 bardak kadar suyu koyun. Tamamını et suyu da koyabilirsiniz.\n" +
                    "\n" +
                    "Hemen hemen 20 dakika da pişecek olan çorbanızı ocaktan aldıktan sonra blendırdan geçirin. Patates ve soğan iyice ezilsin.\n" +
                    "\n" +
                    "Dilerseniz üzerine salçalı yağdan sos hazırlayıp baharatlarla servis edebilirsiniz."};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corba);

        liste = findViewById(R.id.listview_corba);


        corba.add(new Corbalar("Ezogelin Çorbası", R.drawable.corba_ezogelin));
        corba.add(new Corbalar("Mercimek Çorbası", R.drawable.corba_mercimek));
        corba.add(new Corbalar("Domates Çorbası", R.drawable.corba_domates));
        corba.add(new Corbalar("Yayla Çorbası", R.drawable.corba_yayla));
        corba.add(new Corbalar("Tarhana Çorbası", R.drawable.corba_tarhana));
        corba.add(new Corbalar("Şehriye Çorbası", R.drawable.corba_sehriye));




        CustomAdapter customAdapter = new CustomAdapter(context, corba);
        liste.setAdapter(customAdapter);

        //alert dialog için arraylist





        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //bu bölümde tıklanılan çorbadan sonra alert dialog gelecek içerisinde listview olacak ve bilgiler array olarak tutulacak
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater ınflater = LayoutInflater.from(context);
                View alertview = ınflater.inflate(R.layout.custom_alertdialog, null);
                TextView alerttext = alertview.findViewById(R.id.textView_alert);
                ListView alertlist = alertview.findViewById(R.id.listView_alert);


                if(corba.get(i).getAdi().equals("Ezogelin Çorbası")){
                    adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ezogelin );
                    alertlist.setAdapter(adapter);


                    alerttext.setText(corba.get(i).getAdi().toString());
                    builder.setView(alertview);
                    builder.show();
                }
                else  if(corba.get(i).getAdi().equals("Mercimek Çorbası")){
                    adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mercimek );
                    alertlist.setAdapter(adapter);


                    alerttext.setText(corba.get(i).getAdi().toString());
                    builder.setView(alertview);
                    builder.show();
                }


            }
        });



    }


}
