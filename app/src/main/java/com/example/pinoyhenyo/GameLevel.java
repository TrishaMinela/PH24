package com.example.pinoyhenyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class GameLevel extends AppCompatActivity {

    private ImageView imgGameLevelBackground;
    private Button btnEasy, btnMedium, btnHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_level);

        imgGameLevelBackground = findViewById(R.id.imgGameLevelBackground);
        btnEasy = findViewById(R.id.btnEasy);
        btnMedium = findViewById(R.id.btnMedium);
        btnHard = findViewById(R.id.btnHard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background image for Easy level with delay
                imgGameLevelBackground.setImageResource(R.drawable.easy_clicked);
                imgGameLevelBackground.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGameScreen("Easy");
                    }
                }, 500);  // 0.5 seconds delay
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background image for Medium level with delay
                imgGameLevelBackground.setImageResource(R.drawable.medium_clicked);
                imgGameLevelBackground.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGameScreen("Medium");
                    }
                }, 500);  // 0.5 seconds delay
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background image for Hard level with delay
                imgGameLevelBackground.setImageResource(R.drawable.hard_clicked);
                imgGameLevelBackground.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGameScreen("Hard");
                    }
                }, 500);  // 0.5 seconds delay
            }
        });
    }

    private void startGameScreen(String level) {
        Intent intent = new Intent(GameLevel.this, GameScreen.class);
        intent.putExtra("LEVEL", level);
        startActivity(intent);
    }
}
