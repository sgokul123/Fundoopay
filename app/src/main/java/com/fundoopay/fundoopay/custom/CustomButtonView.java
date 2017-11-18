package com.fundoopay.fundoopay.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

public class CustomButtonView extends View {

    public static final int END_SLOP = 1;
    public static final int START_SLOP = 2;

    private int mPosition;
    private Rect mRect;
    private Paint mPaint;
    private Path mPath;
    private static final int SQURE_SIZE = 300;
    public CustomButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomButtonView(Context context, int position) {
        super(context);
        mPosition = position;
        init(null);

    }
    public CustomButtonView(Context context) {
        super(context);
        init(null);

    }

    public CustomButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    public CustomButtonView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

    }

    private void init(@Nullable AttributeSet attrs){
        mRect = new Rect();
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public void swapColor(){
        mPaint.setColor(mPaint.getColor() == Color.GREEN ? Color.BLUE : Color.GREEN);
    }

    public void setSlop(int slope){
        mPosition = slope;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        switch (mPosition){
            case 1:
                mPath.moveTo(0,0);
                mPath.lineTo(width - 20,0);
                mPath.lineTo(width + 20,height);
                mPath.lineTo(0,height);
                mPath.close();
                mPaint.setColor(Color.TRANSPARENT);
                break;
            case 2:
                mPath.moveTo(-20,0);
                mPath.lineTo(width,0);
                mPath.lineTo(width,height);
                mPath.lineTo(20,height);
                mPath.close();
                mPaint.setColor(Color.RED);
                break;
        }
        canvas.drawPath(mPath,mPaint);
        canvas.clipPath(mPath);
    }
}