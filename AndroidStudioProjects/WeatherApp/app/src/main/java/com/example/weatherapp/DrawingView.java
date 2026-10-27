package com.example.weatherapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {

    private Paint paint;
    private ArrayList<Float> points;
    private int currentColor;
    private float lastX, lastY;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        currentColor = Color.BLACK;
        points = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(currentColor);
        for (int i = 0; i < points.size() - 4; i += 4) {
            float startX = points.get(i);
            float startY = points.get(i + 1);
            float endX = points.get(i + 2);
            float endY = points.get(i + 3);
            canvas.drawLine(startX, startY, endX, endY, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                points.add(x);
                points.add(y);
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                points.add(lastX);
                points.add(lastY);
                points.add(x);
                points.add(y);
                lastX = x;
                lastY = y;
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        return true;
    }

    public void clear() {
        points.clear();
        invalidate();
    }

    public void setColor(int color) {
        currentColor = color;
    }
}
