package com.cxh.note.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cxh.note.R;


/**
 * Created by Administrator on 2016/3/25.
 */
public class TestActivity extends BaseActivity {
    private ImageView iv;
    private Button button;
    private Drawable drawable;
    private Bitmap bitmap;
    private Drawable drawable1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    protected void initData() {


        drawable1 = getResources().getDrawable(R.mipmap.customer_default);
        drawable = getResources().getDrawable(R.mipmap.customer_pressed);
        drawable = drawable.mutate();
        drawable = DrawableCompat.wrap(drawable);
//        drawable2 = new BitmapDrawable(getResources(),drawable)
        Drawable[] layers = new Drawable[2];
        layers[0] = drawable1;
        layers[1] = drawable;
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        DrawableCompat.setTint(drawable, 0x00000000);
        iv.setImageDrawable(layerDrawable);
    }

    public Bitmap getTransparentBitmap(Bitmap source, int number) {
        int[] argb = new int[source.getWidth() * source.getHeight()];
        source.getPixels(argb, 0, source.getWidth(), 0, 0, source.getWidth(), source.getHeight());
        number = number * 255 / 100;
        for (int i = 0; i < argb.length; i++) {
            if(argb[i] != 0)
            argb[i] = (number << 24) | (argb[i] & 0x00FFFFFF);
        }
        source = Bitmap.createBitmap(argb, source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        return source;
    }


    private int number = 0x00ff0000;

    @Override
    public void onClick(View v) {
//        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        DrawableCompat.setTint(drawable, number += 0x11000000);
//        iv.setImageDrawable(drawable);
//        iv.setImageBitmap(getTransparentBitmap(bitmap, number += 10));
    }




    private void sendRequest() {
        RequestQueue newRequestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e("volley5", response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        newRequestQueue.add(request);

    }
}
