package com.mymeek.fake.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint paint;

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        canvas.drawCircle(350, 150, 150, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(700, 150, 150, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(56, 120, 222));
        canvas.drawCircle(350, 500, 150, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20f);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(700, 500, 150, paint);
    }
}
