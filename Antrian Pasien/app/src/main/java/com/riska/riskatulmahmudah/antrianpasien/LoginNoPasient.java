package com.riska.riskatulmahmudah.antrianpasien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginNoPasient extends AppCompatActivity {

    @BindView(R.id.edt_login)
    EditText edtLogin;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_no_pasient);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String no = edtLogin.getText().toString().trim();
        if(no.equals("")){
            Toast.makeText(this, "Masukan No antrian", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), PasienActivity.class);
            intent.putExtra("no", no);
            startActivity(intent);
        }

    }
}
