package com.example.liushibujuview.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 实现流式布局 由于没有用onMesure测量，所以本布局一定是要固定高度，如match_parent
 * 
 * @author Administrator Yang
 * 
 */
public class BUILayout extends RelativeLayout {

	public BUILayout(Context context) {
		super(context);
	}

	public BUILayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@SuppressLint("NewApi")
	public BUILayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/* 定义左边间距 */
	private final int MARGIN_LEFT = 20;
	/* 定义上部间距 */
	private final int MARGIN_TOP = 20;

	@Override
	protected void onLayout(boolean changed, int left, int top, int r, int b) {
		// 当前ViewGroup的总宽度
		int mViewWidth = getMeasuredWidth();

		// 定义起始的位置
		int mCurrWidth = MARGIN_LEFT;
		int mCurrHeight = MARGIN_TOP;

		// 得到子项个数
		int childCount = getChildCount();
		// 循环设置每个子项的位置
		for (int i = 0; i < childCount; i++) {
			View childView = getChildAt(i);
			// 得到子view的宽高
			int width = childView.getMeasuredWidth();
			int height = childView.getMeasuredHeight();

			// 换行
			if (mCurrWidth + width + MARGIN_LEFT > mViewWidth) {
				mCurrWidth = MARGIN_LEFT;
				mCurrHeight += height + MARGIN_TOP;
			}
			// 执行ChildView的绘制
			childView.layout(mCurrWidth, mCurrHeight, mCurrWidth + width,
					mCurrHeight + height);

			// 记录当前宽度
			mCurrWidth += width + MARGIN_LEFT;
		}

	}
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
