package com.cxh.note.activity;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cxh.note.R;
import com.cxh.note.adapter.base.CommonAdapter;
import com.cxh.note.adapter.base.ViewHolder;
import com.cxh.note.bean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class ListItemAnimationActivity extends BaseActivity {
    private ListView listView;
    private List<Bean> mDatas;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_content;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.listView);
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
        for(int i = 0; i < 9; i ++) {
            mDatas.add(new Bean("title" + i , "content" + i));
        }
        listView.setAdapter(new CommonAdapter<Bean>(this, mDatas, R.layout.item_test) {
            @Override
            public void convert(ViewHolder holder, Bean bean) {
                final int position = holder.getPosition();
                final View convertView = holder.getConvertView();
                if (mDatas.get(holder.getPosition()).isClose) {
                    ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = 80;
                        convertView.setLayoutParams(layoutParams);
                    }

                } else {
                    ViewGroup.LayoutParams layoutParams =  convertView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = 160;
                        convertView.setLayoutParams(layoutParams);
                    }
                }


                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i = 0;
                        int end = 0;
                        if (mDatas.get(position).isClose) {
                            i = 80;
                            end = 160;
                        } else {
                            i = 160;
                            end = 80;
                        }
                        mDatas.get(position).isClose = !mDatas.get(position).isClose;
                        ValueAnimator animator = ValueAnimator.ofInt(i, end);
                        animator.setDuration(400);
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
                                layoutParams.height = (Integer) animation.getAnimatedValue();

                                convertView.setLayoutParams(layoutParams);
                            }
                        });
                        animator.start();
                    }
                });
            }
        });
    }

//    class MyAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return mDatas.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return mDatas.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(final int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                convertView = View.inflate(getActivity(), R.layout.item_test, null);
//            } else {
//
//            }
//            if (mDatas.get(position).isClose) {
//                ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
//                if (layoutParams != null) {
//
//                    layoutParams.height = 80;
//                    convertView.setLayoutParams(layoutParams);
//                }
//
//            } else {
//                ViewGroup.LayoutParams layoutParams = convertView.getLayoutParams();
//                if (layoutParams != null) {
//
//                    layoutParams.height = 160;
//                    convertView.setLayoutParams(layoutParams);
//                }
//            }
////            final View viewf = View.inflate(getActivity(), R.layout.item_test, null);
//            final View finalConvertView = convertView;
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//                @Override
//                public void onClick(View v) {
//                    int i = 0;
//                    int end = 0;
//                    if (mDatas.get(position).isClose) {
//                        i = 80;
//                        end = 160;
//                    } else {
//                        i = 160;
//                        end = 80;
//                    }
//                    mDatas.get(position).isClose = !mDatas.get(position).isClose;
//                    ValueAnimator animator = ValueAnimator.ofInt(i, end);
//                    animator.setDuration(400);
//                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animation) {
//                            ViewGroup.LayoutParams layoutParams = finalConvertView.getLayoutParams();
//                            layoutParams.height = (Integer) animation.getAnimatedValue();
//
//                            finalConvertView.setLayoutParams(layoutParams);
//                        }
//                    });
//                    animator.start();
//                }
//            });
//            return convertView;
//        }
//    }

}
