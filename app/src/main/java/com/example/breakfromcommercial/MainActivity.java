package com.example.breakfromcommercial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMuteUnmute = findViewById(R.id.btnMuteUnmute);
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        btnMuteUnmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (audioManager.getRingerMode()) {
                    case AudioManager.RINGER_MODE_NORMAL:
                        audioManager.adjustVolume(AudioManager.ADJUST_TOGGLE_MUTE, AudioManager.FLAG_SHOW_UI);
                        break;
                    case AudioManager.RINGER_MODE_SILENT:
                        audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
                        break;
                    case AudioManager.RINGER_MODE_VIBRATE:
                        audioManager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
                        break;

                }
            }
        });
    }
    public void launchWebsite(View view) {
        Uri webpage = Uri.parse("https://www.google.com/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
    public void openPdf(View view) {
        startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
    }
}