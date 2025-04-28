package com.example.exp_5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView textProgress;
    private Button btnLoadImage1, btnLoadImage2;
    private final Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        textProgress = findViewById(R.id.textProgress);
        btnLoadImage1 = findViewById(R.id.btnLoadImage1);
        btnLoadImage2 = findViewById(R.id.btnLoadImage2);

        // Set click listeners
        btnLoadImage1.setOnClickListener(v -> loadImage(1));
        btnLoadImage2.setOnClickListener(v -> loadImage(2));
    }

    private void loadImage(int imageId) {
        // Show progress
        runOnUiThread(() -> {
            progressBar.setVisibility(View.VISIBLE);
            textProgress.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
            textProgress.setText("0%");
            imageView.setImageBitmap(null);
        });

        executor.execute(() -> {
            // Simulate loading progress
            for (int i = 0; i <= 100; i++) {
                final int progress = i;
                runOnUiThread(() -> {
                    progressBar.setProgress(progress);
                    textProgress.setText(progress + "%");
                });

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Load the image
            int resId = (imageId == 1) ? R.drawable.download : R.drawable.images;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);

            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                textProgress.setVisibility(View.GONE);

                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    Toast.makeText(MainActivity.this, "Error loading image", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}