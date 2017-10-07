package selftest.draw2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this,null));
    }
    public class CustomView extends View {

        public CustomView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            Paint paint=new Paint();
//            //去锯齿
//            paint.setAntiAlias(true);
//            //设置颜色
//            paint.setColor(getResources().getColor(android.R.color.holo_blue_light));
//            //绘制普通圆
//            canvas.drawCircle(200,200,100,paint);
//            //设置空心Style
//            paint.setStyle(Paint.Style.STROKE);
//            //设置空心边框的宽度
//            paint.setStrokeWidth(20);
//            //绘制空心圆
//            canvas.drawCircle(200,500,90,paint);
//        }

//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            Paint paint = new Paint();
//            //去锯齿
//            paint.setAntiAlias(true);
//            //设置颜色
//            paint.setColor(Color.BLUE);
//            //绘制正方形
//            canvas.drawRect(100, 100, 300, 300, paint);
//            //上面代码等同于
//            //RectF rel=new RectF(100,100,300,300);
//            //canvas.drawRect(rel, paint);
//
//            //设置空心Style
//            paint.setStyle(Paint.Style.STROKE);
//            //设置空心边框的宽度
//            paint.setStrokeWidth(20);
//            //绘制空心矩形
//            canvas.drawRect(100, 400, 600, 800, paint);
//        }

//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            Paint paint = new Paint();
//            //去锯齿
//            paint.setAntiAlias(true);
//            //设置颜色
//            paint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
//            RectF rel = new RectF(100, 100, 300, 300);
//            //实心圆弧
//            canvas.drawArc(rel, 0, 270, false, paint);
//            //实心圆弧 将圆心包含在内
//            RectF rel2 = new RectF(100, 400, 300, 600);
//            canvas.drawArc(rel2, 0, 270, true, paint);
//            //设置空心Style
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setStrokeWidth(20);
//
//            RectF rel3 = new RectF(100, 700, 300, 900);
//            canvas.drawArc(rel3, 0, 320, false, paint);
//
//            RectF rel4 = new RectF(100, 1000, 300, 1200);
//            canvas.drawArc(rel4, 0, 270, true, paint);
//
//        }
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            Paint paint = new Paint();
//            //去锯齿
//            paint.setAntiAlias(true);
//            //设置颜色
//            paint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
//            paint.setTextSize(100);
//            //绘制文本
//            canvas.drawText("JRE", 100, 150, paint);
//        }
//        @Override
//        protected void onDraw(Canvas canvas)
//        {
//            super.onDraw(canvas);
//            Paint paint =new Paint();
//            //去锯齿
//            paint.setAntiAlias(true);
//            //设置颜色
//            paint.setColor(Color.BLACK);
//            //设置点的大小
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setStrokeWidth(20);
//            //设置多个点
//            float strock[]={100,100,200,200,300,300,100,400};
//            canvas.drawPoints(strock,paint);
//            //设置一个点
//            canvas.drawPoint(100,600,paint);
//        }
        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            Paint paint =new Paint();
            //去锯齿
            paint.setAntiAlias(true);
            //设置颜色
            paint.setColor(Color.BLACK);
            //设置点的大小
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(20);
            //绘制一条线
            canvas.drawLine(100,100,100,300,paint);
            //绘制多条线
            float []point={100,400,400,400,100,500,600,600};
            canvas.drawLines(point,paint);
        }
    }
}
