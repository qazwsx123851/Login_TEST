package com.example.oolong.login_test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    RelativeLayout rellay1,rellay2;
    EditText etName,etPassword;
    Animation uptodown,downtoup;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
            img.setAnimation(uptodown);
            rellay1.setAnimation(uptodown);
            rellay2.setAnimation(uptodown);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imgView_logo);
        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        handler.postDelayed(runnable, 2000);

    }

    public void Login(View view) {
        etName = findViewById(R.id.etuserName);
        String name = etName.getText().toString();
        etPassword = findViewById(R.id.etPassword);
        String password = etPassword.getText().toString();

        if(new String("test123").equals(name) && new String("123456").equals(password)) {
            img.setAnimation(downtoup);
            rellay1.setAnimation(downtoup);
            rellay2.setAnimation(downtoup);
            img.setVisibility(View.INVISIBLE);
            rellay1.setVisibility(View.INVISIBLE);
            rellay2.setVisibility(View.INVISIBLE);

            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
            };

            handler.postDelayed(runnable, 470);
        }
    }
}
