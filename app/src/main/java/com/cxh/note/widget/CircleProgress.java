package com.cxh.note.widget;

import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cxh on 2015/11/6.
 * 240度环形进度View
 */
public class CircleProgress extends View {
    /**
     * mPaint 画笔
     */
    private Paint mPaint;

    /**
     * mProgress 进度
     */
    private int mProgress;

    /**
     * mProgressBounds文字边界信息
     */
    private Rect mProgressBounds;

    /**
     * mSymbolBounds 百分比符号边界信息
     */
    private Rect mSymbolBounds;
    private ArgbEvaluator evaluate;

    public CircleProgress(Context context) {
        this(context, null);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * 初始化
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(LAYER_TYPE_SOFTWARE, mPaint);
         }
        mPaint = new Paint();
        evaluate = new ArgbEvaluator();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(getResources().getDisplayMetrics().density * 1);
        mProgressBounds = new Rect();
        mSymbolBounds = new Rect();
    }

    /**
     * 公共方法，设置进度
     * @param progress 进度
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void setProgress(int progress) {
        mProgress = progress;
        if (progress < 0) {
            mProgress = 0;
        }
        if (progress > 100) {
            mProgress = 100;
        }
        invalidate();

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onDraw(Canvas canvas) {
//        mPaint.setColor(Color.parseColor("#66ffffff"));
        //移动原点到画布中心，并旋转对应角度，画出所有刻度
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(-120);
        for (int i = 0; i < 25; i++) {
//            if (i > 16) {
//                mPaint.setColor(Color.parseColor("#66ffffff"));
//            }else if (i > 8) {
//                mPaint.setColor(Color.parseColor("#66ffffff"));
//            }
            if (i / 25.0f < mProgress / 100.0f) {

                mPaint.setColor((Integer) evaluate.evaluate(mProgress / 100.0f, Color.GRAY, Color.GREEN));
            } else {
                mPaint.setColor(Color.GRAY);
            }
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(0, -getHeight() / 2, 0, -getHeight() / 2 + getWidth()/15, mPaint);
            canvas.rotate(10);
        }

        //获取进度宽高等信息
        mPaint.setTextSize(getWidth()/3);
        mPaint.getTextBounds(mProgress + "",0,(mProgress + "").length(),mProgressBounds);

        //获取百分比符号宽高等信息
        mPaint.setTextSize(getWidth()/6);
        mPaint.getTextBounds(" %",0,2,mSymbolBounds);

        //旋转画布，画文字
        canvas.rotate(-130);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(getWidth()/3);
        canvas.drawText(mProgress + "", -(mProgressBounds.width()/2 + mSymbolBounds.width()/2 ), mProgressBounds.height()/2, mPaint);
        mPaint.setTextSize(getWidth()/6);
        canvas.drawText(" %", -(mProgressBounds.width()/2 + mSymbolBounds.width()/2) + mProgressBounds.width(), mProgressBounds.height()/2, mPaint);
//        super.onDraw(canvas);
    }
}
