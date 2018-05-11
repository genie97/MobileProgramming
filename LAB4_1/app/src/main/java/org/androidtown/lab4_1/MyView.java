package org.androidtown.lab4_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private int paintColor = 0xFF0202f2;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;

    public MyView(Context c) {
        super(c);
        setupDrawing();
    }

    /*Set of drawing*/
    private void setupDrawing() {
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor); //color of paint
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(15); // line Thickness

        /*style of paint*/
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    /*Change images drawn in canvas to bitmap*/
    protected void onSizeChanged(int width, int height, int b_width, int b_height) {
        super.onSizeChanged(width, height, b_width, b_height);
        canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    /*drawing*/
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }


    /*Touch event*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX(); //get x-coordinate
        float touchY = event.getY(); //get y-coordinate

        switch (event.getAction()) {
            /*down action*/
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;

            /*move action*/
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;

            /*up action*/
            case MotionEvent.ACTION_UP:
                drawPath.lineTo(touchX, touchY);
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;

            default:
                return false;
        }
        invalidate(); //update event
        return true;
    }
}
