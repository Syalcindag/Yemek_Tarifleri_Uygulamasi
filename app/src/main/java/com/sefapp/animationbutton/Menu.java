package com.sefapp.animationbutton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Sefa on 1.08.2018.
 */

public class Menu  extends AppCompatActivity{
    Button buton_anayemek, buton_corba, buton_tatli, buton_ozeltarif;

    TextView baslik;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        baslik =findViewById(R.id.textView);
        buton_anayemek = findViewById(R.id.button_anayemek);
        buton_corba = findViewById(R.id.button_corba);
        buton_tatli =findViewById(R.id.button_tatli);
        buton_ozeltarif =findViewById(R.id.button_ozeltarif);




      /*  Animation shake = AnimationUtils.loadAnimation(context, R.anim.shake);
        buton.startAnimation(shake);
      */
      // Animation textanim = AnimationUtils.loadAnimation(context, R.anim.text_anim);
      //  baslik.clearAnimation();
      //  baslik.startAnimation(textanim);



       Animation fadein = AnimationUtils.loadAnimation(context, R.anim.fade_in);
       baslik.startAnimation(fadein);

        final Animation milkshake = AnimationUtils.loadAnimation(context, R.anim.milkshake);

        buton_corba.startAnimation(milkshake);
        buton_anayemek.startAnimation(milkshake);
        buton_tatli.startAnimation(milkshake);
        buton_ozeltarif.startAnimation(milkshake);

        buton_corba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // view.startAnimation(milkshake);
                Intent ıntent = new Intent(context, Sicakcorba.class);
                startActivity(ıntent);
            }
        });



        buton_tatli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(context, TatliTarifleri.class);
                startActivity(ıntent);
            }
        });


        buton_anayemek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent = new Intent(context, YemekTarifleri.class);
                startActivity(ıntent);
            }
        });

    }

}
