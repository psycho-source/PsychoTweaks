package com.test;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class theme extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int RC_LOGIN = 100;
    private int ui;
    private SharedPreferences sharedHead;
    private SharedPreferences sharedThe;

    private static int getThemeAccentColor(Context context) {
        int colorAttr;
        colorAttr = android.R.attr.colorAccent;
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttr, outValue, true);
        return outValue.data;
    }

    public void setLay(int lay) {
        ui = lay;
        ImageButton prev = (ImageButton) findViewById(R.id.prev);
        ImageButton nex = (ImageButton) findViewById(R.id.nex);
        RelativeLayout spin = (RelativeLayout) findViewById(R.id.spin);
        if (ui == 3)
            nex.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        else
            nex.setColorFilter(getResources().getColor(R.color.trans), PorterDuff.Mode.SRC_ATOP);
        if (ui == 0)
            prev.setColorFilter(getResources().getColor(R.color.back), PorterDuff.Mode.SRC_ATOP);
        else
            prev.setColorFilter(getResources().getColor(R.color.trans), PorterDuff.Mode.SRC_ATOP);

        switch (ui) {
            case 0:
                final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
                rl.setBackgroundColor(getResources().getColor(R.color.back));
                ImageView stock = (ImageView) findViewById(R.id.bg);
                stock.setImageResource(R.drawable.ic_ui_stock);
                TextView Title = (TextView) findViewById(R.id.head);
                Title.setText(R.string.theme_stock);
                Title.setTextColor(getResources().getColor(R.color.text_main_stock));
                TextView Sub = (TextView) findViewById(R.id.sub);
                Sub.setText(R.string.theme_stock_desc);
                Sub.setTextColor(getResources().getColor(R.color.text_sub));
                spin.setVisibility(View.GONE);
                break;
            case 1:
                final RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl);
                rl1.setBackgroundColor(getResources().getColor(R.color.dark));
                ImageView dark = (ImageView) findViewById(R.id.bg);
                dark.setImageResource(R.drawable.ic_ui);
                TextView Title1 = (TextView) findViewById(R.id.head);
                Title1.setText(R.string.theme_dark);
                Title1.setTextColor(getResources().getColor(R.color.text_main_dark));
                TextView Sub1 = (TextView) findViewById(R.id.sub);
                Sub1.setText(R.string.theme_dark_desc);
                Sub1.setTextColor(getResources().getColor(R.color.text_sub));
                nex.setColorFilter(getResources().getColor(R.color.text_main_dark), PorterDuff.Mode.SRC_ATOP);
                prev.setColorFilter(getResources().getColor(R.color.text_main_dark), PorterDuff.Mode.SRC_ATOP);
                spin.setVisibility(View.GONE);
                break;
            case 2:
                final RelativeLayout rl2 = (RelativeLayout) findViewById(R.id.rl);
                rl2.setBackgroundColor(getResources().getColor(R.color.back));
                ImageView psycho = (ImageView) findViewById(R.id.bg);
                psycho.setImageResource(R.drawable.ic_ui);
                TextView Title2 = (TextView) findViewById(R.id.head);
                Title2.setText(R.string.theme_psycho);
                Title2.setTextColor(getThemeAccentColor(this));
                TextView Sub2 = (TextView) findViewById(R.id.sub);
                Sub2.setText(R.string.theme_psycho_desc);
                Sub2.setTextColor(getResources().getColor(R.color.text_sub));
                prev.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
                nex.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
                spin.setVisibility(View.VISIBLE);
                break;
            case 3:
                final RelativeLayout rl3 = (RelativeLayout) findViewById(R.id.rl);
                rl3.setBackgroundColor(getResources().getColor(R.color.black));
                ImageView black = (ImageView) findViewById(R.id.bg);
                black.setImageResource(R.drawable.ic_ui);
                TextView Title3 = (TextView) findViewById(R.id.head);
                Title3.setText(R.string.theme_black);
                Title3.setTextColor(getResources().getColor(R.color.text_main_dark));
                TextView Sub3 = (TextView) findViewById(R.id.sub);
                Sub3.setText(R.string.theme_black_desc);
                Sub3.setTextColor(getResources().getColor(R.color.text_sub));
                prev.setColorFilter(getResources().getColor(R.color.text_main_dark), PorterDuff.Mode.SRC_ATOP);
                spin.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme);

        sharedHead = PreferenceManager.getDefaultSharedPreferences(this);
        ui = sharedHead.getInt("themePost",0);
        setLay(ui);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar4);
        toolbar1.setBackgroundColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar1);
        if (getSupportActionBar() != null) {
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
            upArrow.setColorFilter(getResources().getColor(R.color.text_main_dark), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        ImageButton prev = (ImageButton) findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ui != 0)
                    setLay(ui - 1);
            }
        });

        ImageButton nex = (ImageButton) findViewById(R.id.nex);
        nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ui != 3)
                    setLay(ui + 1);
            }
        });

        Spinner header = (Spinner) findViewById(R.id.spinner);
        header.setOnItemSelectedListener(this);
        List<String> colors = new ArrayList<String>();
        colors.add("Blue");
        colors.add("Green");
        colors.add("Purple");
        colors.add("Grey");
        colors.add("Yellow");
        colors.add("Pink");
        ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colors);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        header.setAdapter(data);
        sharedHead = PreferenceManager.getDefaultSharedPreferences(this);
        int position= sharedHead.getInt("header",0);
        header.setSelection(position);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.Secd);
        fab.setBackgroundColor(getThemeAccentColor(this));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(theme.this, accent.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(theme.this, fab, getString(R.string.transition_dialog));
                startActivityForResult(intent, RC_LOGIN, options.toBundle());
            }
        });

        FloatingActionButton apply = (FloatingActionButton) findViewById(R.id.apply);
        apply.setBackgroundColor(getThemeAccentColor(this));
        sharedThe = PreferenceManager.getDefaultSharedPreferences(this);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedThe.edit();
                editor.putInt("themePost",ui);
                editor.apply();
                switch (ui) {
                    case 0:
                        //Settings.Secure.putInt(theme.this.getContentResolver(),
                        //       Settings.Secure.THEME_PRIMARY_COLOR, 0);
                        Toast.makeText(theme.this, "Stock Theme Applied", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //Settings.Secure.putInt(theme.this.getContentResolver(),
                        //       Settings.Secure.THEME_PRIMARY_COLOR, 1);
                        Toast.makeText(theme.this, "Dark Theme Applied", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //Settings.Secure.putInt(theme.this.getContentResolver(),
                        //      Settings.Secure.THEME_PRIMARY_COLOR, 2);
                        Toast.makeText(theme.this, "Psycho Theme Applied", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //Settings.Secure.putInt(theme.this.getContentResolver(),
                        //      Settings.Secure.THEME_PRIMARY_COLOR, 3);
                        Toast.makeText(theme.this, "Black Theme Applied", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        RelativeLayout colo = (RelativeLayout) findViewById(R.id.color);
        RelativeLayout colo1 = (RelativeLayout) findViewById(R.id.color1);
        sharedHead = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedHead.edit();
        editor.putInt("header",position);
        editor.apply();
        switch(position)
        {
            case 0:
                colo.setBackgroundColor(getResources().getColor(R.color.blue_accent_color));
                colo1.setBackgroundColor(getResources().getColor(R.color.blue_accent_color));
                break;
            case 1:
                colo.setBackgroundColor(getResources().getColor(R.color.green_accent_color));
                colo1.setBackgroundColor(getResources().getColor(R.color.green_accent_color));
                break;
            case 2:
                colo.setBackgroundColor(getResources().getColor(R.color.purple_accent_color));
                colo1.setBackgroundColor(getResources().getColor(R.color.purple_accent_color));
                break;
            case 3:
                colo.setBackgroundColor(getResources().getColor(R.color.grey_accent_color));
                colo1.setBackgroundColor(getResources().getColor(R.color.grey_accent_color));
                break;
            case 4:
                colo.setBackgroundColor(getResources().getColor(R.color.yellow_accent_color));
                colo1.setBackgroundColor(getResources().getColor(R.color.yellow_accent_color));
                break;
            case 5:
                colo.setBackgroundColor(getResources().getColor(R.color.pink_accent_color));
                colo1.setBackgroundColor(getResources().getColor(R.color.pink_accent_color));
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}