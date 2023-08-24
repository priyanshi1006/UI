package com.example.sqlite_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db = new DBHelper(MainActivity.this);
        TextView sname = (TextView) findViewById(R.id.name);
        TextView dept  = (TextView) findViewById(R.id.dept);

        Button b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertQuery(sname.getText().toString(), dept.getText().toString());

                sname.setText(db.show(1).toString());
            }
        });
    }
}