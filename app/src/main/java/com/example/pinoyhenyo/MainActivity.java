package com.example.pinoyhenyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgHomeScreen;
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        imgHomeScreen = findViewById(R.id.imgHomeScreen);
        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the image source to show button clicked state
                imgHomeScreen.setImageResource(R.drawable.play_clicked);

                // Start GameScreen activity after a short delay
                imgHomeScreen.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, GameLevel.class);
                        startActivity(intent);
                    }
                }, 500);  // 0.5 seconds delay
            }
        });
    }
}
