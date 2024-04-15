package com.example.pinoyhenyo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        // Set background image based on game state
        ImageView backgroundImageView = findViewById(R.id.backgroundImageView);
        int gameState = getIntent().getIntExtra("game_state", 0); // Assuming you pass the game state as an integer extra
        switch (gameState) {
            case 0: // Normal mode
                backgroundImageView.setImageResource(R.drawable.normal_background);
                break;
            case 1: // Wrong answer
                backgroundImageView.setImageResource(R.drawable.wrong_background);
                break;
            case 2: // Correct answer
                backgroundImageView.setImageResource(R.drawable.correct_background);
                break;
            default:
                break;
        }
    }
}
