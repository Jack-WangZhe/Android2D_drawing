## 安卓2D绘图
### Canvas画布负责进行绘制各种各样的图形，它有如下的一些绘制图形方法：
* drawArc 绘制弧
* drawBitmap 绘制位图
* drawCircle 绘制圆形
* drawLine 绘制线
* drawOval 绘制椭圆
* drawPath 绘制路径
* drawPoint 绘制一个点
* drawPoints 绘制多个点
* drawRect 绘制矩形
* drawRoundRect 绘制圆角矩形
* drawText 绘制字符串
* drawTextOnPath 沿着路径绘制字符串
### Paint主要负责设置绘图的风格，包括画笔的颜色，粗细，填充风格等，它有如下的一些设置方法：
* setARGB/setColor 设置颜色
* setAlpha 设置透明度
* setAntiAlias 设置是否抗锯齿
* setShader 设置画笔的填充效果
* setShadowLayer 设置阴影
* setStyle 设置画笔风格
* setStrokeWidth 设置空心边框的宽度
* setTextSize 设置绘制文本时文字的大小

### 绘制圆形：drawCircle(float cx, float cy, float radius, Paint paint)
* cx>圆心的x坐标 
* cy>圆心的y坐标 
* radius>圆的半径 
* paint>绘制风格
#### 核心代码
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
	
	        @Override
	        protected void onDraw(Canvas canvas) {
	            super.onDraw(canvas);
	            Paint paint=new Paint();
	            //去锯齿
	            paint.setAntiAlias(true);
	            //设置颜色
	            paint.setColor(getResources().getColor(android.R.color.holo_blue_light));
	            //绘制普通圆
	            canvas.drawCircle(200,200,100,paint);
	            //设置空心Style
	            paint.setStyle(Paint.Style.STROKE);
	            //设置空心边框的宽度
	            paint.setStrokeWidth(20);
	            //绘制空心圆
	            canvas.drawCircle(200,500,90,paint);
	        }
	    }
	}
### 绘制矩形:drawRect(float left, float top, float right, float bottom, Paint paint) / drawRect(RectF rect, Paint paint)
* left>矩形left的x坐标 
* top>矩形top的y坐标 
* right>矩形right的x坐标 
* bottom>矩形bottom的y坐标 
* paint>绘制风格
* [即设置左上角和右下角坐标]
#### 核心代码:
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
	        @Override
	        protected void onDraw(Canvas canvas) {
	            super.onDraw(canvas);
	            Paint paint = new Paint();
	            //去锯齿
	            paint.setAntiAlias(true);
	            //设置颜色
	            paint.setColor(Color.BLUE);
	            //绘制正方形
	            canvas.drawRect(100, 100, 300, 300, paint);
	            //上面代码等同于
	            //RectF rel=new RectF(100,100,300,300);
	            //canvas.drawRect(rel, paint);
	
	            //设置空心Style
	            paint.setStyle(Paint.Style.STROKE);
	            //设置空心边框的宽度
	            paint.setStrokeWidth(20);
	            //绘制空心矩形
	            canvas.drawRect(100, 400, 600, 800, paint);
	        }
	    }
	}
### 绘制圆角矩形：drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint) / drawRoundRect(RectF rect, float rx, float ry, Paint paint)
* left>图形left的x坐标 
* top>图形top的y坐标 
* right>图形right的x坐标 
* bottom>图形bottom的y坐标 
* rx>x方向的圆角半径 
* ry>y方向的圆角半径 
* paint>绘制风格

### 绘制椭圆：drawOval(float left, float top, float right, float bottom, Paint paint)
* left>图形left的x坐标 
* top>图形top的y坐标 
* right>图形right的x坐标 
* bottom>图形bottom的y坐标 
* paint>绘制风格

### 绘制弧：drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
* oval>指定圆弧的外轮廓矩形区域 
* startAngle>圆弧起始角度，单位为度 
* sweepAngle>圆弧扫过的角度，顺时针方向，单位为度 
* useCenter>如果为True时，在绘制圆弧时将圆心包括在内，通常用来绘制扇形 
* paint>绘制风格
#### 核心代码:
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
	        @Override
	        protected void onDraw(Canvas canvas) {
	            super.onDraw(canvas);
	            Paint paint = new Paint();
	            //去锯齿
	            paint.setAntiAlias(true);
	            //设置颜色
	            paint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
	            RectF rel = new RectF(100, 100, 300, 300);
	            //实心圆弧
	            canvas.drawArc(rel, 0, 270, false, paint);
	            //实心圆弧 将圆心包含在内
	            RectF rel2 = new RectF(100, 400, 300, 600);
	            canvas.drawArc(rel2, 0, 270, true, paint);
	            //设置空心Style
	            paint.setStyle(Paint.Style.STROKE);
	            paint.setStrokeWidth(20);
	
	            RectF rel3 = new RectF(100, 700, 300, 900);
	            canvas.drawArc(rel3, 0, 320, false, paint);
	
	            RectF rel4 = new RectF(100, 1000, 300, 1200);
	            canvas.drawArc(rel4, 0, 270, true, paint);
	
	        }
	    }
	}
### 绘制文字：drawText(String text, float x, float y, Paint paint)
* text>文本 
* x>文本origin的x坐标 
* y>文本baseline的y坐标 
* paint>绘制风格
#### 核心代码:
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
	        @Override
	        protected void onDraw(Canvas canvas) {
	            super.onDraw(canvas);
	            Paint paint = new Paint();
	            //去锯齿
	            paint.setAntiAlias(true);
	            //设置颜色
	            paint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
	            paint.setTextSize(100);
	            //绘制文本
	            canvas.drawText("JRE", 100, 150, paint);
	        }
	    }
	}
### 绘制像素点:使用drawPoint()或drawPoints()方法
* public void drawPoint(float x, float y, Paint paint);  绘制一个像素点
* public void drawPoints(float[] pts, Paint paint);  绘制多个像素点
* x：像素点的横坐标；y：像素点的纵坐标。
* paint:描述像素点属性的Paint对象，即设置点的大小、颜色等属性。
* pts：多个像素点的坐标数组；必须为偶数，两个为一个像素点坐标。
* count：要获得的数组元素个数；必须为偶数。
#### 核心代码:
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
	            //设置多个点
	            float strock[]={100,100,200,200,300,300,100,400};
	            canvas.drawPoints(strock,paint);
	            //设置一个点
	            canvas.drawPoint(100,600,paint);
	        }
	    }
	}
### 绘制直线:使用drawLine()或drawLines()方法
* public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint)； 绘制一条直线
* public void drawLines(float[] pts, Paint paint)； 绘制多条直线
* startX：直线开始端点的横坐标；startY：直线开始端点的纵坐标。
* stopX：直线结束端点的横坐标；stopY：直线结束端点的纵坐标。
* pts：绘制多条直线时的端点坐标集合，4个元素为一组，表示一条直线。
* count：获取pts数组中元素的个数；参数值为4的整数倍。
#### 核心代码:
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
