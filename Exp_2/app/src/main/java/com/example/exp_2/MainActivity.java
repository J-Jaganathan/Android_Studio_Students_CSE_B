package com.example.exp_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.editText1);
        EditText e2 = findViewById(R.id.editText2);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        TextView t = findViewById(R.id.textView1);

        b1.setOnClickListener(v -> {
            try {
                double num1 = Double.parseDouble(e1.getText().toString());
                double num2 = Double.parseDouble(e2.getText().toString());
                t.setText(String.format("%s + %s = %.2f",
                        e1.getText(), e2.getText(), num1 + num2));
            } catch (NumberFormatException e) {
                t.setText("Invalid input");
            }
        });

        b2.setOnClickListener(v -> {
            try {
                double num1 = Double.parseDouble(e1.getText().toString());
                double num2 = Double.parseDouble(e2.getText().toString());
                t.setText(String.format("%s - %s = %.2f",
                        e1.getText(), e2.getText(), num1 - num2));
            } catch (NumberFormatException e) {
                t.setText("Invalid input");
            }
        });

        b3.setOnClickListener(v -> {
            try {
                double num1 = Double.parseDouble(e1.getText().toString());
                double num2 = Double.parseDouble(e2.getText().toString());
                t.setText(String.format("%s * %s = %.2f",
                        e1.getText(), e2.getText(), num1 * num2));
            } catch (NumberFormatException e) {
                t.setText("Invalid input");
            }
        });

        b4.setOnClickListener(v -> {
            try {
                double num1 = Double.parseDouble(e1.getText().toString());
                double num2 = Double.parseDouble(e2.getText().toString());
                if (num2 == 0) {
                    t.setText("Cannot divide by zero");
                } else {
                    t.setText(String.format("%s / %s = %.2f", e1.getText(), e2.getText(), num1 / num2));
                }
            } catch (NumberFormatException e) {
                t.setText("Invalid input");
            }
        });
    }
}