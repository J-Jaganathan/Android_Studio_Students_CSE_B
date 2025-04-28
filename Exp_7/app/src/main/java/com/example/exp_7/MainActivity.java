package com.example.exp_7;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1001;
    private EditText pathEditText, contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pathEditText = findViewById(R.id.pathEditText);
        contentEditText = findViewById(R.id.contentEditText);
        Button readButton = findViewById(R.id.readButton);
        Button saveButton = findViewById(R.id.saveButton);

        // Set default path to a SAFE location (works on all Android versions)
        File defaultDir = getExternalFilesDir(null);  // No permissions needed for this dir
        pathEditText.setText(defaultDir + "/myfile.txt");

        readButton.setOnClickListener(v -> readFile());
        saveButton.setOnClickListener(v -> saveFile());
    }

    private boolean hasStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11+ - No permission needed for app-specific storage
            return true;
        } else {
            // Android 9 and below - Need READ/WRITE_EXTERNAL_STORAGE
            return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED;
        }
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },
                STORAGE_PERMISSION_REQUEST_CODE
        );
    }

    private void readFile() {
        if (!hasStoragePermission()) {
            requestStoragePermission();
            Toast.makeText(this, "Please grant storage permission first", Toast.LENGTH_SHORT).show();
            return;
        }

        String filePath = pathEditText.getText().toString();
        File file = new File(filePath);

        if (!file.exists()) {
            Toast.makeText(this, "File does not exist!", Toast.LENGTH_SHORT).show();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append('\n');
            }
            contentEditText.setText(text.toString());
            Toast.makeText(this, "File read successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error reading file: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void saveFile() {
        if (!hasStoragePermission()) {
            requestStoragePermission();
            Toast.makeText(this, "Please grant storage permission first", Toast.LENGTH_SHORT).show();
            return;
        }

        String filePath = pathEditText.getText().toString();
        File file = new File(filePath);

        try {
            // Create parent directories if they don't exist
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(contentEditText.getText().toString());
                Toast.makeText(this, "File saved successfully!", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving file: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied. Cannot access files.", Toast.LENGTH_LONG).show();
            }
        }
    }
}