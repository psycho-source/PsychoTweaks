package com.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class display extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        setContentView(R.layout.display);

        Toolbar toolbar5 = (Toolbar) findViewById(R.id.toolbar5);
        toolbar5.setTitle(R.string.display);
        setSupportActionBar(toolbar5);
        if (getSupportActionBar() != null) {
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
            upArrow.setColorFilter(getThemeAccentColor(display.this), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      switch(position)
      {
          case 0: Toast.makeText(parent.getContext(), "Selected: Blue" , Toast.LENGTH_LONG).show();
          break;
          case 1: Toast.makeText(parent.getContext(), "Selected: Green", Toast.LENGTH_LONG).show();
          break;
          case 2: Toast.makeText(parent.getContext(), "Selected: Purple", Toast.LENGTH_LONG).show();
              break;
          case 3: Toast.makeText(parent.getContext(), "Selected: Grey", Toast.LENGTH_LONG).show();
              break;
          case 4: Toast.makeText(parent.getContext(), "Selected: Yellow", Toast.LENGTH_LONG).show();
              break;
          case 5: Toast.makeText(parent.getContext(), "Selected: Pink", Toast.LENGTH_LONG).show();
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
