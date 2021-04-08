package com.utssttbbandung.npm19552011182;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView zodiak;
    private String detail;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        com.utssttbbandung.npm19552011182.Zodiak zo = getIntent().getParcelableExtra("ZODIAK");

        zodiak = findViewById(R.id.textDetail);
        image = findViewById(R.id.imgZodiak);
        image.setImageResource(Integer.parseInt(zo.getImage()));

        detail = "<b>"+zo.getZodiak()+" </b>" + zo.getDetail();
        zodiak.setText(Html.fromHtml(detail));
    }
}