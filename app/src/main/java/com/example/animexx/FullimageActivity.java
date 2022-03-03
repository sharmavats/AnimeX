package com.example.animexx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class FullimageActivity extends AppCompatActivity {
    private ImageView FullImage;
    private Button Apply ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        FullImage = findViewById(R.id.fullimage);
        Apply = findViewById(R.id.open_bottom_sheet);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(FullImage);

        Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");

            }
        });
    }

    private void setBackground() {
        Bitmap bitmap = ((BitmapDrawable)FullImage.getDrawable()).getBitmap();

        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(this,"ERROR : "+ e.getMessage() , Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}