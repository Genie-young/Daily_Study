package com.example.examplecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sub);
        TextView nameText = (TextView) findViewById(R.id.nameText);

        Intent intent = getIntent();
        //만약 인텐트 객체에 nameText속성이 없다면 강제종료.
        Log.v("tag",intent.getStringExtra("nameText").toString());
        Log.v("test","==========================================");
        nameText.setText(intent.getStringExtra("nameText").toString());

    }
}
