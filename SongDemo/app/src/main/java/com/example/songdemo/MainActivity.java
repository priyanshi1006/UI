package com.example.songdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

/** @noinspection deprecation*/
public class MainActivity extends AppCompatActivity {

    private Button btn;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        mp = new MediaPlayer();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    pauseMusic();
                } else {
                    playMusic();
                }
            }
        });
        Button btn2 = findViewById(R.id.getMusic);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.reset();
                pickMusic();
            }
        });
    }
    public void pickMusic() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 1) {
                Uri selectedMusicUri = (Uri)data.getData();
                if (selectedMusicUri != null) {
                    String pathFromUri = getRealPathFromURI(this, selectedMusicUri);
                    try {
                        mp.setDataSource(this, selectedMusicUri);
                        mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private String getRealPathFromURI(Context context, Uri contentUri) {
        String[] projection = { MediaStore.Audio.Media.DATA };
        CursorLoader loader = new CursorLoader(context, contentUri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    private void pauseMusic(){
        if(mp!=null){
            mp.pause();
            btn.setText("Play");
        }
    }
    private  void playMusic(){
        if(mp!=null){
            mp.start();
            btn.setText("Pause");
        }
    }
}