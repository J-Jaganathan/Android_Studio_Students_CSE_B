package com.example.exp_10;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static MainActivity inst;
    private TextView alarmStatus;
    private TimePicker timePicker;
    private Button setAlarmButton;
    private boolean alarmSet = false;
    private PendingIntent pendingIntent;

    public static MainActivity instance() {
        return inst;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        inst = this;
        timePicker = findViewById(R.id.timePicker1);
        setAlarmButton = findViewById(R.id.button1);
        alarmStatus = findViewById(R.id.alarmStatus);

        timePicker.setIs24HourView(false);

        setAlarmButton.setOnClickListener(v -> {
            if (!alarmSet) {
                setAlarm();
            } else {
                cancelAlarm();
            }
        });
    }

    private void setAlarm() {
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        alarmTime.set(Calendar.MINUTE, timePicker.getMinute());
        alarmTime.set(Calendar.SECOND, 0);

        Calendar currentTime = Calendar.getInstance();

        if (alarmTime.compareTo(currentTime) <= 0) {
            Toast.makeText(this, "Invalid time! Please set a future time.", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), pendingIntent);

        alarmSet = true;
        alarmStatus.setText("ALARM ON");
        alarmStatus.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        setAlarmButton.setText("CANCEL ALARM");
        Toast.makeText(this, "Alarm is set!", Toast.LENGTH_SHORT).show();
    }

    private void cancelAlarm() {
        if (pendingIntent != null) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.cancel(pendingIntent);
        }

        alarmSet = false;
        alarmStatus.setText("ALARM OFF");
        alarmStatus.setTextColor(getResources().getColor(android.R.color.holo_red_light));
        setAlarmButton.setText("SET ALARM");
        Toast.makeText(this, "Alarm cancelled!", Toast.LENGTH_SHORT).show();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "AlarmChannel";
            String description = "Channel for Alarm Notifications";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("alarm_channel", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void updateAlarmStatus(String status) {
        runOnUiThread(() -> {
            if (status.equals("ON")) {
                alarmStatus.setText("ALARM ON");
                alarmStatus.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            } else {
                alarmStatus.setText("ALARM OFF");
                alarmStatus.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            }
        });
    }
}