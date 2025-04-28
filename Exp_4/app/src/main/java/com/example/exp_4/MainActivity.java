package com.example.exp_4;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editRegNo, editName, editMarks;
    private Button btnAdd, btnView, btnViewAll, btnUpdate, btnDelete;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editRegNo = findViewById(R.id.editRegNo);
        editName = findViewById(R.id.editName);
        editMarks = findViewById(R.id.editMarks);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnViewAll = findViewById(R.id.btnViewAll);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // Create or open database
        db = openOrCreateDatabase("Students", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(regno VARCHAR PRIMARY KEY, name VARCHAR, mark VARCHAR);");

        // Set click listeners
        btnAdd.setOnClickListener(v -> addStudent());
        btnView.setOnClickListener(v -> viewStudent());
        btnViewAll.setOnClickListener(v -> viewAllStudents());
        btnUpdate.setOnClickListener(v -> updateStudent());
        btnDelete.setOnClickListener(v -> deleteStudent());
    }

    private void addStudent() {
        String regNo = editRegNo.getText().toString().trim();
        String name = editName.getText().toString().trim();
        String marks = editMarks.getText().toString().trim();

        if (regNo.isEmpty() || name.isEmpty() || marks.isEmpty()) {
            showMessage("Error", "Please enter all values");
            return;
        }

        try {
            db.execSQL("INSERT INTO student VALUES('"+regNo+"','"+name+"','"+marks+"');");
            showMessage("Success", "Record added");
            clearFields();
        } catch (Exception e) {
            showMessage("Error", "Registration number already exists");
        }
    }

    private void viewStudent() {
        String regNo = editRegNo.getText().toString().trim();

        if (regNo.isEmpty()) {
            showMessage("Error", "Please enter Reg. No.");
            return;
        }

        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE regno='"+regNo+"'", null);
        if (cursor.moveToFirst()) {
            editName.setText(cursor.getString(1));
            editMarks.setText(cursor.getString(2));
            showMessage("Success", "Record found");
        } else {
            showMessage("Error", "Invalid Reg. No.");
        }
        cursor.close();
    }

    private void viewAllStudents() {
        Cursor cursor = db.rawQuery("SELECT * FROM student", null);
        if (cursor.getCount() == 0) {
            showMessage("Error", "No records found");
            return;
        }

        StringBuilder buffer = new StringBuilder();
        while (cursor.moveToNext()) {
            buffer.append("Reg. No: ").append(cursor.getString(0)).append("\n");
            buffer.append("Name: ").append(cursor.getString(1)).append("\n");
            buffer.append("Mark: ").append(cursor.getString(2)).append("\n\n");
        }
        showMessage("Student Details", buffer.toString());
        cursor.close();
    }

    private void updateStudent() {
        String regNo = editRegNo.getText().toString().trim();
        String name = editName.getText().toString().trim();
        String marks = editMarks.getText().toString().trim();

        if (regNo.isEmpty()) {
            showMessage("Error", "Please enter Reg. No.");
            return;
        }

        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE regno='"+regNo+"'", null);
        if (cursor.moveToFirst()) {
            db.execSQL("UPDATE student SET name='"+name+"', mark='"+marks+"' WHERE regno='"+regNo+"'");
            showMessage("Success", "Record Modified");
            clearFields();
        } else {
            showMessage("Error", "Invalid Reg. No.");
        }
        cursor.close();
    }

    private void deleteStudent() {
        String regNo = editRegNo.getText().toString().trim();

        if (regNo.isEmpty()) {
            showMessage("Error", "Please enter Reg. No.");
            return;
        }

        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE regno='"+regNo+"'", null);
        if (cursor.moveToFirst()) {
            db.execSQL("DELETE FROM student WHERE regno='"+regNo+"'");
            showMessage("Success", "Record Deleted");
            clearFields();
        } else {
            showMessage("Error", "Invalid Reg. No.");
        }
        cursor.close();
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void clearFields() {
        editRegNo.setText("");
        editName.setText("");
        editMarks.setText("");
        editRegNo.requestFocus();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}