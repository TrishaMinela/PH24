package com.example.pinoyhenyo;

import android.hardware.SensorEventListener;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class GameScreen extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Vibrator vibrator;
    private WordLoader wordLoader;
    private String currentWord;
    private ImageView categoryImageView;
    private TextView wordTextView;
    private String level;
    private String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        wordTextView = findViewById(R.id.wordTextView);

        // Retrieve the level and file name from the intent extras
        level = getIntent().getStringExtra("LEVEL");
        fileName = getFileNameForLevel(level);


        // Initialize Sensor Manager and Vibrator
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        // Load words from text file based on the selected level
        InputStream inputStream = getResources().openRawResource(getResources().getIdentifier(fileName, "raw", getPackageName()));
        wordLoader = new WordLoader(inputStream);
        showNextWord();

//        // Set background image based on game state
//        ImageView backgroundImageView = findViewById(R.id.backgroundImageView);
//        int gameState = getIntent().getIntExtra("game_state", 0); // Assuming you pass the game state as an integer extra
//        switch (gameState) {
//            case 0: // Normal mode
//                backgroundImageView.setImageResource(R.drawable.normal_background);
//                break;
//            case 1: // Wrong answer
//                backgroundImageView.setImageResource(R.drawable.wrong_background);
//                break;
//            case 2: // Correct answer
//                backgroundImageView.setImageResource(R.drawable.correct_background);
//                break;
//            default:
//                break;
//        }
    }

    private String getFileNameForLevel(String level) {
        switch (level) {
            case "Easy":
                return "easy";
            case "Medium":
                return "medium";
            case "Hard":
                return "hard";
            default:
                throw new IllegalArgumentException("Invalid level: " + level);
        }
    }


    private void showNextWord() {
        currentWord = wordLoader.getRandomWord();
        // Display the currentWord in your TextView
        wordTextView.setText(currentWord);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float z = sensorEvent.values[2];

        if (z < -9.0) { // Phone flipped down
            // Handle correct answer
            // Update UI, add points, etc.
            vibrator.vibrate(200); // Vibrate for feedback
            showNextWord();
        } else if (z > 9.0) { // Phone flipped up
            // Skip to next word
            showNextWord();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //will not use
    }
}
