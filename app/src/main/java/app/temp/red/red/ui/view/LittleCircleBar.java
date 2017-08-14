package app.temp.red.red.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static java.lang.Math.PI;

/**
 * Created by huangkangfa on 2017/8/11.
 */

public class LittleCircleBar extends View {
    private int paintWidth = 15;

    private Paint paint0;  //背景
    private String color0 = "#ff88ff";
    private Paint paint1;  //拖动
    private String color1 = "#999999";
    private Paint paint2;  //小圆球
    private String color2 = "#000000";
    private int r;  //小圆半径


    int centre;  //圆心
    int radius;  //半径
    RectF oval;

    private int angle = 0;  //滑动的角度

    public LittleCircleBar(Context context) {
        super(context);
        initView();
    }

    public LittleCircleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LittleCircleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        paint0 = new Paint();
        paint0.setAntiAlias(true);
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setStrokeWidth(paintWidth);
        paint0.setColor(Color.parseColor(color0));
        paint0.setStrokeCap(Paint.Cap.ROUND);
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(paintWidth);
        paint1.setColor(Color.parseColor(color1));
        paint1.setStrokeCap(Paint.Cap.ROUND);
        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(r);
        paint2.setColor(Color.parseColor(color2));
        paint2.setStrokeCap(Paint.Cap.ROUND);
    }

    int height, width;  //宽高
    float minX,maxX;  //左右边界
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height = View.MeasureSpec.getSize(heightMeasureSpec);
        width = View.MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, height);  //这里面是原始的大小，需要重新计算可以修改本行
        //dosomething
        r = width / 23;
        minX=(float) (width * (1 - getCosWithAngle(45))) / 2;
        maxX=(float) (width * (1 + getCosWithAngle(45))) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centre = width / 2; //获取圆心的x坐标
        radius = centre; //圆环的外半径
        oval = new RectF(0, (float) (-0.9 * centre * (1 + getCosWithAngle(45))), 2 * centre, (float) (centre * (1 - getCosWithAngle(45))));  //用于定义的圆弧的形状和大小的界限
        canvas.drawArc(oval, 45, 90, false, paint0);  //画圆弧
        canvas.drawLine(width / 9, height / 4, minX, height / 15, paint1); //左
        canvas.drawLine(width - width / 9, height / 4, maxX, height / 15, paint0); //右
        paint1.setStrokeWidth(paintWidth + 2);
        canvas.drawArc(oval, 135, -angle, false, paint1);  //根据进度画圆弧


        float x = width * (1 - getCosWithAngle(44.5 + angle)) / 2;
        float y = (float) (0.9*getPercentageHeight(angle)+r/4);
        oval = new RectF(x - r / 2, y - r / 2, x + r / 2, y + r / 2);
        canvas.drawArc(oval, 0, 360, false, paint2);  //根据进度画圆球
    }

    /**
     * 根据角度获取cos值
     *
     * @param num
     * @return
     */
    private float getCosWithAngle(double num) {
        return (float) Math.cos(2 * PI / 360 * num);
    }

    /**
     * 根据角度获取sin值
     *
     * @param num
     * @return
     */
    private float getSinWithAngle(double num) {
        return (float) Math.sin(2 * PI / 360 * num);
    }

    /**
     * 根据角度计算百分比的高度
     *
     * @return
     */
    private float getPercentageHeight(int num) {
        double temp = centre * getCosWithAngle(45);

        if (num <= 3) {
            num = 3;
        } else if (num >= 87) {
            num = 87;
        }

        if (num >= 0 && num <= 45) {
            return (float) (centre * getCosWithAngle(45 - num) - temp);
        } else if (num > 45 && num <= 90) {
            return (float) (centre * getCosWithAngle(num - 45) - temp);
        }
        return 0;
    }

    //减小对父控件滑动的影响
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private int currentPercentage=0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                break;   //为了让down执行move的操作
            case MotionEvent.ACTION_MOVE:
                if(event.getX()>=minX&&event.getX()<=maxX){
                    currentPercentage= (int) ((event.getX()-minX)*100/(Math.sqrt(2)*centre));
                    setPercentage(currentPercentage);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }

    /**
     * 设置角度
     * @param num
     */
    private void setAngle(int num) {
        if (num <=3) {
            angle = 3;
        } else if (num >= 87) {
            angle = 87;
        } else {
            angle = num;
        }
        invalidate();
    }

    /**
     * 设置指定进度
     * @param p
     */
    public void setPercentage(int p){
        setAngle(90*p/100);
    }

    /**
     * 获取当前进度
     * @return
     */
    public int getPercentage(){
        return currentPercentage;
    }
}
