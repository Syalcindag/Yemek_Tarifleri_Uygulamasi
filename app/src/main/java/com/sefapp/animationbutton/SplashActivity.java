package com.sefapp.animationbutton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sefa on 4.08.2018.
 */

public class SplashActivity extends AppCompatActivity {
   Context context = this;
   ImageView imageview_splash;
   TextView text_splash;
   Animation frombottom;
   Animation frombottom2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        new sayfaGecisi().start();
        imageview_splash = findViewById(R.id.imageview_splash);
        text_splash = findViewById(R.id.text7);
        frombottom2 = AnimationUtils.loadAnimation(context, R.anim.frombottom2);
        frombottom = AnimationUtils.loadAnimation(context, R.anim.frombottom);
        text_splash.setAnimation(frombottom2);
        imageview_splash.setAnimation(frombottom);
    }



    private class sayfaGecisi extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Intent ıntent = new Intent(context, Menu.class );
                startActivity(ıntent);
                finish();
            }
        }
    }
}
