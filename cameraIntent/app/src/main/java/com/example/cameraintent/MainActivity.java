package com.example.cameraintent;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button capture;
    int ImageCaptureCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView);
        capture = (Button) findViewById(R.id.capt);

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt, ImageCaptureCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ImageCaptureCode)
        {
            if(resultCode == RESULT_OK)
            {

                Bitmap bp = (Bitmap) data.getExtras().get("data");
                img.setImageBitmap(bp);
                MediaStore.Images.Media.insertImage(getContentResolver(),bp,"img", "image");
                Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
            }
            if(resultCode == RESULT_CANCELED)
            {

            }
        }
    }
}