package com.fundoopay.fundoopay.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

public class CustomTextViewFB extends AppCompatTextView {

    private static final String TAG = CustomTextViewFB.class.getSimpleName();

    private boolean isRoundedEdge;
    public static String fontName="font/bauhaus93.ttf";

    public CustomTextViewFB(Context context) {
        super(context);
        init(null);
    }

    public CustomTextViewFB(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextViewFB(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
       // TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0);
        try {
            if (attrs != null) {
               /// isRoundedEdge = a.getBoolean(R.styleable.CustomTextView_isRoundedEdge, false);
               // fontName = a.getString(R.styleable.CustomTextView_fontName);
                setFont(fontName);
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
          //  a.recycle();
        }
    }

    public void setFont(String fontName) {
        this.fontName = fontName;
     //   Typeface typeface = FontCache.getTypeface(fontName, getContext());
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), fontName);
        setTypeface(typeface);
        invalidate();
        requestLayout();
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
        setFont(fontName);
    }

  /*  @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(isRoundedEdge){

            if(this.getBackground()!=null && this.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable)(this.getBackground().mutate());
                gradientDrawable = Utils.roundEdgeGradientDrawable(gradientDrawable, this.getHeight());
                Utils.setBackgroundCompat(this, gradientDrawable);
            }
        }
    }*/
}

