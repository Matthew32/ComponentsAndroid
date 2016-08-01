package com.example.matthew.componentsandroid.View.ViewUtils;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

/**
 * Created by matthew on 01/08/2016.
 */
public class DrawerLayoutMatthew extends DrawerLayout {

    public DrawerLayoutMatthew(Context context) {
        super(context);
    }

    public DrawerLayoutMatthew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawerLayoutMatthew(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
