package com.example.pinoyhenyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class WordLoader {

    private ArrayList<String> words;
    private Random random;

    public WordLoader(InputStream inputStream) {
        words = new ArrayList<>();
        random = new Random();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
