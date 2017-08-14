package com.hkf.coffee.ui.view.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ScrollGridView extends GridView{
	public ScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs); 
    } 
    public ScrollGridView(Context context) {
        super(context); 
    } 
    public ScrollGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle); 
    }     
    @Override 
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {      
        int expandSpec = MeasureSpec.makeMeasureSpec( 
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST); 
        super.onMeasure(widthMeasureSpec, expandSpec); 
    } 
}