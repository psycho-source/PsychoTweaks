package com.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    CardView card1, card2, card3, card4;
    int east;

    private static int getThemeAccentColor(Context context) {
        int colorAttr;
        colorAttr = android.R.attr.colorAccent;
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttr, outValue, true);
        return outValue.data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        east = 0;
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
            upArrow.setColorFilter(getResources().getColor(R.color.text_main_dark), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        final ImageView egg = (ImageView) findViewById(R.id.header1);
        egg.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                east++;
                if (east == 10) {
                    Toast.makeText(Main.this, "Hold On, You Will Break Things...", Toast.LENGTH_SHORT).show();
                }
                if (east == 20) {
                    Toast.makeText(Main.this, "Stop It", Toast.LENGTH_SHORT).show();
                }
                if (east == 30) {
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
                        display.class);
                startActivity(myIntent);
            }
        });

        card3 = (CardView) findViewById(R.id.card3);
        card3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Main.this,
                        status.class);
                startActivity(myIntent);
            }
        });

        card4 = (CardView) findViewById(R.id.card4);
        card4.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                final Intent intent = new Intent(Intent.ACTION_MAIN, null);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                final ComponentName cn = new ComponentName("org.cyanogenmod.cmparts", "org.cyanogenmod.cmparts.input.ButtonSettings");
                intent.setComponent(cn);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
