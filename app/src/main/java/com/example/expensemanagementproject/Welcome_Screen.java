package com.example.expensemanagementproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        final ImageView iv =(ImageView) findViewById(R.id.welcome_img);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.animate_welcome);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.welcome_2);
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
