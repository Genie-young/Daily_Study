package com.example.examplecollection;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    /* 이미지 슬라이더 관련 부분 */
    ImageSlider adapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*액티비티 전환 부분 */
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        Button nameButton =(Button) findViewById(R.id.nameButton);

        /* 이미지 슬라이더 실행 구현부 */
        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new ImageSlider(this);
        viewPager.setAdapter(adapter);

        /* 액티비티 전환 실행 버튼 구현부 */
        nameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("nameText", name);
                startActivity(intent);
            }
        });

    }
}
