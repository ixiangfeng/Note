package com.cxh.note.activity;

import android.view.View;
import android.widget.Button;

import com.cxh.note.R;
import com.cxh.note.widget.CircleProgress;

/**
 * Created by cxh on 2016/3/28.
 */
public class CircleProgressViewActivity extends BaseActivity {
    private Button button;
    private CircleProgress circleProgress;
    private int progress;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_circle_progress_view;
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        button = (Button) findViewById(R.id.button);
        circleProgress = (CircleProgress) findViewById(R.id.circleProgress);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                circleProgress.setProgress(progress+=10);
                break;
        }
    }
}
