package com.example.progressdiaglog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText seconds;
    TextView showMsg;
    Button sleep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seconds = (EditText) findViewById(R.id.Seconds);
        showMsg = (TextView) findViewById(R.id.ShowMsg);
        sleep = (Button) findViewById(R.id.button);

        sleep.setOnClickListener(new View.OnClickListener() {
            /** @noinspection deprecation*/
            @Override
            public void onClick(View view) {
                ProgresssDialog ps = new ProgresssDialog();
                ps.execute(seconds.getText().toString());
            }
        });
    }
    /** @noinspection deprecation*/
    public class ProgresssDialog extends AsyncTask<String, String, String> {
        ProgressDialog pd;
        private String response;
        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
            pd = ProgressDialog.show(MainActivity.this,"Progress Dialog","Slept for "+ seconds.getText().toString());
        }

        @SuppressLint("WrongThread")
        protected String doInBackground(String... params) {
            response = "sleeping";
            publishProgress(response);

            int second = Integer.parseInt(params[0]);
            for(int i=0; i<second; i++)
            {
                try {
                    Thread.sleep(1000);
                    response = "slept comlete "+(i+1)+" of "+ second + "seconds";
                    publishProgress(response);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            return response;

        }

        @Override
        protected void onProgressUpdate(String... values) {
//            super.onProgressUpdate(values);
            showMsg.setText(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);
            pd.dismiss();
            showMsg.setText(result);
        }

    }

}