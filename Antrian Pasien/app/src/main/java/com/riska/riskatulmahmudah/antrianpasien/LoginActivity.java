package com.riska.riskatulmahmudah.antrianpasien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button btnperawat,btnpasien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnpasien=(Button)findViewById(R.id.btnpasien);
        btnperawat=(Button)findViewById(R.id.btnperawat);

        btnperawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginPerawatActivity.class);
                startActivity(intent);
            }
        });
        btnpasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),LoginPasienActivity.class);
                Intent intent = new Intent(getApplicationContext(),LoginNoPasient.class);
                startActivity(intent);
            }
        });
    }
}
