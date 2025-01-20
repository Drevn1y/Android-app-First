package com.msi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class activity_main2 extends AppCompatActivity {

    private MediaPlayer mem1, mem2, mem3, puk, smex;

    private MediaPlayer[] list = new MediaPlayer[5];
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mem1 = MediaPlayer.create(this, R.raw.mem1);
        mem2 = MediaPlayer.create(this, R.raw.mem2);
        mem3 = MediaPlayer.create(this, R.raw.mem3);
        smex = MediaPlayer.create(this, R.raw.smex);
        puk = MediaPlayer.create(this, R.raw.puk);

        list[0] = mem1;
        list[1] = mem2;
        list[2] = mem3;
        list[3] = smex;
        list[4] = puk;
    }


    public void random_player(View v) {
        int rd = random.nextInt(5);
        sound_player(list[rd]);
    }

    private void sound_player(MediaPlayer media)  {
        if (media != null && !media.isPlaying()) {
            media.start();
        }
    }

    public void backNewActivity (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}