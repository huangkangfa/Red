package app.temp.red.red.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Map;

/**
 * Created by huangkangfa on 2017/8/11.
 */

public class CircleStage extends View {
    //细
    private Paint minPaint;
    private int minWidth=3;
    private String minColor="#333333";

    //粗
    private Paint maxPaint;
    private int maxWidth=40;
    private String maxColor="#ff88ff";

    int centre;  //圆心
    int radius;  //最外圆
    RectF oval;

    int tempAngle=360/24;
    private String[] colors=new String[24];


    public CircleStage(Context context) {
        super(context);
        initView();
    }

    public CircleStage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CircleStage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView(){
        minPaint = new Paint();
        minPaint.setAntiAlias(true);
        minPaint.setStyle(Paint.Style.STROKE);
        minPaint.setStrokeWidth(minWidth);
        minPaint.setColor(Color.parseColor(minColor));
        minPaint.setStrokeCap(Paint.Cap.ROUND);

        maxPaint = new Paint();
        maxPaint.setAntiAlias(true);
        maxPaint.setStyle(Paint.Style.STROKE);
        maxPaint.setStrokeWidth(maxWidth);
        maxPaint.setColor(Color.parseColor(maxColor));
        maxPaint.setStrokeCap(Paint.Cap.ROUND);
        resetColors();
    }

    private void resetColors() {
        for(int i=0;i<colors.length;i++){
            colors[i]="#999999";
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centre = getWidth()/2; //获取圆心的x坐标
        radius = centre; //圆环的外半径
        oval = new RectF(centre - radius+70, centre - radius+70, centre+ radius-70, centre + radius-70);  //用于定义的圆弧的形状和大小的界限

        //实际控制的圆环
        canvas.drawCircle(centre, centre, radius-70, maxPaint); //画出圆环
        canvas.drawCircle(centre, centre, radius-50, minPaint); //画出外细圆环
        canvas.drawCircle(centre, centre, radius-90, minPaint); //画出内细圆环

        //进度
        int startAngle=270;
        for(int i=0;i<colors.length;i++){
            maxPaint.setStrokeCap(Paint.Cap.BUTT);
            maxPaint.setStrokeWidth(maxWidth-1);
            maxPaint.setColor(Color.parseColor(colors[i]));
            canvas.drawArc(oval,startAngle,tempAngle,false, maxPaint);  //根据进度画圆弧
            startAngle+=tempAngle;
        }
    }

    /**
     * 设置色彩颜色
     * @param c
     */
    public void setColors(Map<Integer,String> c){
        resetColors();
        for(int x:c.keySet()){
            colors[x]=c.get(x);
        }
        invalidate();
    }
}
