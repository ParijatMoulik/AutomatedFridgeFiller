package com.example.automatedff;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class popup_viewInfo extends AppCompatActivity {


    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_view_info);

        text=findViewById(R.id.pop_veg);

        Intent intent=getIntent();
        final String vege=intent.getStringExtra("vegetable");
        text.setText(vege);


    }
}
