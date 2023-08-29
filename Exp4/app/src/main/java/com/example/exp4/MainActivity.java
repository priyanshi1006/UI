package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button register, login;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    Intent loginIntent, registerIntent;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("credential", MODE_PRIVATE);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        db = new DBHelper(getApplicationContext());
        loginIntent = new Intent(MainActivity.this, LoginActivity.class);

        if(sp.contains("username") && sp.contains("password"))
            startActivity(loginIntent);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();

                ArrayList<HashMap<String, String>> res = db.find(uname);

                if(res.size() == 0)
                {
                    Toast.makeText(MainActivity.this, "Username is not valid", Toast.LENGTH_SHORT).show();
                }

                for (HashMap<String, String> re : res) {
                    if(re.get("username").equals(pwd))
                    {
                        edit = sp.edit();
                        edit.putString("username", uname);
                        edit.putString("password", pwd);
                        edit.commit();
                        startActivity(loginIntent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Credentials is not valid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                ArrayList<HashMap<String, String>> res = db.find(uname);

                if(res.size() == 0) {
                    edit = sp.edit();
                    edit.putString("username", uname);
                    edit.putString("password", pwd);
                    edit.commit();
                    db.insertQuery(uname, pwd);
                    startActivity(loginIntent);

                }
                else {
                    Toast.makeText(MainActivity.this, "Username is already Exist", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}