package com.example.smartrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView imgIconVN;
    ImageView imgIconENG;
    Button btnLoginStaff;
    Button btnLoginDiners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        OnClick();
    }

    private void OnClick() {
        btnLoginStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginStaffActivity.class);
                startActivity(i);
                finish();
            }
        });

        //sự kiện click icon cờ VN sẽ chuyển sang ngôn ngữ tiếng Việt
        imgIconVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiLanguage("vi");
                finish();
            }
        });

        //sự kiện click icon cờ England sẽ chuyển sang ngôn ngữ tiếng Anh
        imgIconENG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiLanguage("en");
                finish();
            }
        });
    }
    public void multiLanguage(String language){
        Locale locale = new Locale(language);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration
                ,getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void AnhXa() {
        btnLoginStaff = (Button) findViewById(R.id.btn_LoginStaff);
        btnLoginDiners = (Button) findViewById(R.id.btn_LoginDiners);
        imgIconVN = (ImageView) findViewById(R.id.img_IconVN);
        imgIconENG = (ImageView) findViewById(R.id.img_IconEng);
    }
}