package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button hackButton;
    private TextView statusText;
    private ImageView tuxImage;
    private View backgroundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hackButton = findViewById(R.id.hackButton);
        statusText = findViewById(R.id.statusText);
        tuxImage = findViewById(R.id.tuxImage);
        backgroundView = findViewById(R.id.backgroundView);

        tuxImage.setVisibility(View.GONE);
        statusText.setText("Готов к взлому Linux");

        backgroundView.setBackgroundColor(getResources().getColor(android.R.color.black));
        hackButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        hackButton.setTextColor(getResources().getColor(android.R.color.black));
        statusText.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

        hackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHackingProcess();
            }
        });
    }

    private void startHackingProcess() {
        hackButton.setEnabled(false);
        statusText.setText("Начинаем взлом...");

        new Handler().postDelayed(() -> {
            statusText.setText("Обход защиты...");
            new Handler().postDelayed(() -> {
                statusText.setText("Получение root-доступа...");
                new Handler().postDelayed(() -> {
                    statusText.setText("Успешно! Root получен!");
                    new Handler().postDelayed(() -> {
                        hackButton.setVisibility(View.GONE);
                        statusText.setVisibility(View.GONE);

                        tuxImage.setVisibility(View.VISIBLE);

                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

                        new Handler().postDelayed(() -> {
                            Animation zoomIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in);
                            tuxImage.startAnimation(zoomIn);
                        }, 5000);

                    }, 1000);
                }, 1500);
            }, 1500);
        }, 1000);
    }
}