package com.cxh.note.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

import com.cxh.note.R;

/**
 * Created by Administrator on 2016/3/24.
 */
public class CustomRadioButton extends RadioButton {
    private Bitmap defaultImg;
    private Bitmap selectImg;
    private Paint mPaint;

    public CustomRadioButton(Context context) {
        this(context, null);
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomRadioButton, defStyleAttr, 0);
        defaultImg = ((BitmapDrawable)typedArray.getDrawable(R.styleable.CustomRadioButton_defaultImg)).getBitmap();
        selectImg = ((BitmapDrawable)typedArray.getDrawable(R.styleable.CustomRadioButton_selectImg)).getBitmap();
        setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(getResources(),selectImg), null, null);
        Log.e("test", "getTransparentBitmap" + defaultImg.getWidth() + "+" + defaultImg.getHeight());
        Log.e("test", "getTransparentBitmap" + selectImg.getWidth() + "+" + selectImg.getHeight());
//        setButtonDrawable(defaultImg);
        typedArray.recycle();
    }

    public Bitmap getTransparentBitmap(Bitmap source, int number) {
        int [] argb = new int[source.getWidth()*source.getHeight()];
        source.getPixels(argb,0,source.getWidth(),0,0,source.getWidth(), source.getHeight());
        number = number * 255 / 100;
        for(int i = 0; i < argb.length; i++) {
            if(argb[i] != 0)
            argb[i] = (number << 24)|(argb[i] &0x00FFFFFF);
        }
        source = Bitmap.createBitmap(argb,source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        return source;
    }

    public void setAlpha(float alpha) {
        Bitmap defaultBitmap = getTransparentBitmap(defaultImg, 100);
        Bitmap selectBitmap = getTransparentBitmap(selectImg, (int) ((alpha) * 100));
        Drawable[] drawables = new Drawable[2];
        drawables[0] = new BitmapDrawable(getResources(),defaultBitmap);
        drawables[1] = new BitmapDrawable(getResources(),selectBitmap);
        LayerDrawable layerDrawable = new LayerDrawable(drawables);
        setCompoundDrawablesWithIntrinsicBounds(null, layerDrawable, null, null);
        DrawableCompat.setTint(drawables[0],0xfffff);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        setDrawable
    }
}
