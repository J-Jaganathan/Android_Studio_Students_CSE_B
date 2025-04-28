package com.example.exp_9;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the title in the ActionBar
        setTitle("MainActivity");

        // Find the menu button and set a click listener
        Button menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(v -> {
            // Show a popup menu when the button is clicked
            PopupMenu popup = new PopupMenu(MainActivity.this, menuButton);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.main_menu, popup.getMenu());

            // Set a listener for menu item clicks
            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();

                if (id == R.id.action_settings) {
                    Toast.makeText(MainActivity.this, "Settings Selected", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.action_about) {
                    Toast.makeText(MainActivity.this, "About Selected", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.action_exit) {
                    Toast.makeText(MainActivity.this, "Exit Selected", Toast.LENGTH_SHORT).show();
                    finish(); // Close the app
                    return true;
                }

                return false;
            });

            popup.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_exit) {
            Toast.makeText(this, "Exit Selected", Toast.LENGTH_SHORT).show();
            finish(); // Close the app
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
