package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = user.getText().toString();
                String password = pass.getText().toString();

                if(uname.equals("Kevin") && password.equals("Kevin"))
                {
                    Toast.makeText(MainActivity.this, "Credential is valid", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Credential is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}