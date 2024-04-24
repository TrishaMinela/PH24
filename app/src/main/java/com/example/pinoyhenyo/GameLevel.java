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

        btnEasy = findViewById(R.id.btnEasy);
        btnMedium = findViewById(R.id.btnMedium);
        btnHard = findViewById(R.id.btnHard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background image for Easy level
                imgGameLevelBackground.setImageResource(R.drawable.easy_clicked);
                startGameScreen("Easy");
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background image for Medium level
                imgGameLevelBackground.setImageResource(R.drawable.medium_clicked);
                startGameScreen("Medium");
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background image for Hard level
                imgGameLevelBackground.setImageResource(R.drawable.hard_clicked);
                startGameScreen("Hard");
            }
        });
    }

    private void startGameScreen(String level) {
        Intent intent = new Intent(GameLevel.this, GameScreen.class);
        intent.putExtra("LEVEL", level);
        startActivity(intent);
    }
}
