package com.example.exp_1;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float fontSize = 20f;
    private int colorCount = 1;
    private int styleCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        // Change Font Size
        button1.setOnClickListener(view -> {
            textView1.setTextSize(fontSize);
            fontSize += 5;
            if (fontSize > 50) fontSize = 20;
        });

        // Change Font Color
        button2.setOnClickListener(view -> {
            switch (colorCount) {
                case 1:
                    textView1.setTextColor(Color.parseColor("#7f00ff")); // Purple
                    break;
                case 2:
                    textView1.setTextColor(Color.parseColor("#00FF00")); // Green
                    break;
                case 3:
                    textView1.setTextColor(Color.parseColor("#FF0000")); // Red
                    break;
                case 4:
                    textView1.setTextColor(Color.parseColor("#0000FF")); // Blue
                    break;
            }
            colorCount = (colorCount == 4) ? 1 : colorCount + 1;
        });

        // Change Font Style
        button3.setOnClickListener(view -> {
            Typeface typeface;
            int style;
            switch (styleCount) {
                case 1:
                    typeface = Typeface.DEFAULT;
                    style = Typeface.ITALIC;
                    break;
                case 2:
                    typeface = Typeface.MONOSPACE;
                    style = Typeface.NORMAL;
                    break;
                case 3:
                    typeface = Typeface.SANS_SERIF;
                    style = Typeface.BOLD;
                    break;
                case 4:
                    typeface = Typeface.SERIF;
                    style = Typeface.BOLD_ITALIC;
                    break;
                default:
                    typeface = Typeface.DEFAULT;
                    style = Typeface.NORMAL;
            }
            textView1.setTypeface(typeface, style);
            styleCount = (styleCount == 4) ? 1 : styleCount + 1;
        });
    }
}