package com.example.a2340c_team45.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RectangleWallView extends View {

    private Paint wallPaint;
    private int wallWidth;
    private int wallHeigth;

    private int x;
    private int y;

    public RectangleWallView(Context context) {
        super(context);

        wallPaint = new Paint();
        wallPaint.setColor(0xFF000000); // Set wall color to black
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        float rectWidth = width * 0.5f; // 50% of screen width
        float rectHeight = height * 0.5f; // 50% of screen height

        float left = (width - rectWidth) / 2;
        float top = (height - rectHeight) / 2;
        setWallHeigth((int) rectHeight);
        setWallWidth((int) rectWidth);
        float right = left + rectWidth;
        float bottom = top + rectHeight;

        canvas.drawRect(left, top, right, bottom, wallPaint);
    }

    public int getWallHeigth() {
        return wallHeigth;
    }

    public int getWallWidth() {
        return wallWidth;
    }

    public void setWallHeigth(int wallHeigth) {
        this.wallHeigth = wallHeigth;
    }

    public void setWallWidth(int wallWidth) {
        this.wallWidth = wallWidth;
    }


    public int GetX() {
        return x;
    }

    public int GetY(){

        return y;
    }

}
