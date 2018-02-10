package com.psycho;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;

public class Main extends AppCompatActivity {

    CardView card1, card2, card3;
    int east;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        east = 0;
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
            upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        final ImageView egg = (ImageView) findViewById(R.id.header1);
        egg.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                east++;
                if (east==10)
                {
                    Toast.makeText(Main.this, "Hold On, You Will Break Things...", Toast.LENGTH_SHORT).show();
                }
                if (east==20)
                {
                    Toast.makeText(Main.this, "Stop It", Toast.LENGTH_SHORT).show();
                }
                if (east==30)
                {
                    egg.setBackgroundResource(R.drawable.android_gradient_list);
                    AnimationDrawable animationDrawable = (AnimationDrawable) egg.getBackground();
                    animationDrawable.setEnterFadeDuration(2000);
                    animationDrawable.setExitFadeDuration(4000);
                    animationDrawable.start();
                    Toast.makeText(Main.this, "You Broke It. Happy Now?", Toast.LENGTH_LONG).show();
                }
            }
        });

        card1 = (CardView) findViewById(R.id.card1);
        card1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Main.this,
                        theme.class);
                startActivity(myIntent);
            }
        });

        card2 = (CardView) findViewById(R.id.card2);
        card2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Main.this,
                        Display.class);
                startActivity(myIntent);
            }
        });

        card3 = (CardView) findViewById(R.id.card3);
        card3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Main.this,
                        Buttons.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
