package com.example.liushibujuview.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * ʵ����ʽ���� ����û����onMesure���������Ա�����һ����Ҫ�̶��߶ȣ���match_parent
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

	/* ������߼�� */
	private final int MARGIN_LEFT = 20;
	/* �����ϲ���� */
	private final int MARGIN_TOP = 20;

	@Override
	protected void onLayout(boolean changed, int left, int top, int r, int b) {
		// ��ǰViewGroup���ܿ��
		int mViewWidth = getMeasuredWidth();

		// ������ʼ��λ��
		int mCurrWidth = MARGIN_LEFT;
		int mCurrHeight = MARGIN_TOP;

		// �õ��������
		int childCount = getChildCount();
		// ѭ������ÿ�������λ��
		for (int i = 0; i < childCount; i++) {
			View childView = getChildAt(i);
			// �õ���view�Ŀ��
			int width = childView.getMeasuredWidth();
			int height = childView.getMeasuredHeight();

			// ����
			if (mCurrWidth + width + MARGIN_LEFT > mViewWidth) {
				mCurrWidth = MARGIN_LEFT;
				mCurrHeight += height + MARGIN_TOP;
			}
			// ִ��ChildView�Ļ���
			childView.layout(mCurrWidth, mCurrHeight, mCurrWidth + width,
					mCurrHeight + height);

			// ��¼��ǰ���
			mCurrWidth += width + MARGIN_LEFT;
		}

	}
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}
