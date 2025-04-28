package com.example.exp_3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnTouchListener {

    private ImageView drawingCanvas;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    // Shape tracking
    private float startX, startY;
    private int currentShape = 0; // 0=Line, 1=Circle, 2=Rectangle, 3=Square
    private final String[] shapes = {"Line", "Circle", "Rectangle", "Square"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize drawing tools
        Display display = getWindowManager().getDefaultDisplay();
        bitmap = Bitmap.createBitmap(display.getWidth(), display.getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        // Setup canvas
        drawingCanvas = findViewById(R.id.drawingCanvas);
        drawingCanvas.setImageBitmap(bitmap);
        drawingCanvas.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                float endX = event.getX();
                float endY = event.getY();
                drawShape(startX, startY, endX, endY);
                drawingCanvas.invalidate();

                // Cycle to next shape
                currentShape = (currentShape + 1) % shapes.length;
                break;
        }
        return true;
    }

    private void drawShape(float startX, float startY, float endX, float endY) {
        switch (currentShape) {
            case 0: // Line
                canvas.drawLine(startX, startY, endX, endY, paint);
                break;

            case 1: // Circle
                float radius = (float) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                canvas.drawCircle(startX, startY, radius, paint);
                break;

            case 2: // Rectangle
                canvas.drawRect(startX, startY, endX, endY, paint);
                break;

            case 3: // Square
                float side = Math.max(Math.abs(endX - startX), Math.abs(endY - startY));
                canvas.drawRect(startX, startY, startX + side, startY + side, paint);
                break;
        }
    }
}