package com.riska.riskatulmahmudah.antrianpasien;

import android.app.ProgressDialog;
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

    ProgressDialog progressdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_no_pasient);
        ButterKnife.bind(this);

        progressdialog = new ProgressDialog(this);
        progressdialog.setMessage("Mencari No Pasient");
        progressdialog.show();
        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    progressdialog.dismiss();
                    Intent intent = new Intent(getApplicationContext(), PasienActivity.class);
                    intent.putExtra("no", getIntent().getStringExtra("user_id"));
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
