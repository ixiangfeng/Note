package com.cxh.note.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 单一item的ListView/GridView通用的Adapter
 *
 * @param <T> 泛型指定数据源的类型
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	/**
	 * 上下文
	 */
	protected Context mContext;

	/**
	 * AbsListView数据源
	 */
	protected List<T> mDatas;

	/**
	 * 填充器
	 */
	protected LayoutInflater mInflater;

	/**
	 * 布局id
	 */
	private int layoutId;

	/**
	 * 构造方法，做初始化处理
	 * @param context 上下文
	 * @param datas 数据源
	 * @param layoutId 布局id
	 */
	public CommonAdapter(Context context, List<T> datas, int layoutId) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = datas;
		this.layoutId = layoutId;
	}


	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position)	{
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
				layoutId, position);
		convert(holder, getItem(position));
		return holder.getConvertView();
	}

	/**
	 * 要实现的抽象方法，相当于getView里面的处理
	 *
	 * @param holder 对应View的ViewHolder
	 * @param t 实体数据类Bean
	 */
	public abstract void convert(ViewHolder holder, T t);

}
