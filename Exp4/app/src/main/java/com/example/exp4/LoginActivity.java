package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sp;
    Button logout;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences("credential", MODE_PRIVATE);

        logout = (Button) findViewById(R.id.logout);
        t1 = (TextView) findViewById(R.id.show);

        String s = "Hellow " + sp.getString("username", null);
        t1.setText(s);

        Intent mainAct = new Intent(LoginActivity.this, MainActivity.class);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = sp.edit();
                edit.clear();
                edit.commit();
                startActivity(mainAct);
            }
        });
    }
}