package com.mymeek.fake.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.mymeek.fake.Utils;


public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        int w = Utils.getDisplayWidth(this.getContext());
        paint.setColor(Color.rgb(241, 41, 35));
        canvas.drawArc(w / 2 - 300 - 25, 50 - 25, w / 2 + 300 - 25, 650 - 25, -190, 150, true, paint);
        paint.setColor(Color.rgb(255, 183, 0));
        canvas.drawArc(w / 2 - 300 + 5, 50 - 5, w / 2 + 300, 650 - 5, -40, 55, true, paint);
        paint.setColor(Color.rgb(138, 0, 163));
        canvas.drawArc(w / 2 - 300, 50, w / 2 + 300, 650, 15, 9, true, paint);
        paint.setColor(Color.rgb(140, 140, 140));
        canvas.drawArc(w / 2 - 300, 50, w / 2 + 300, 650, 25, 7, true, paint);
        paint.setColor(Color.rgb(0, 134, 117));
        canvas.drawArc(w / 2 - 300, 50, w / 2 + 300, 650, 33, 46, true, paint);
        paint.setColor(Color.rgb(21, 126, 244));
        canvas.drawArc(w / 2 - 300, 50, w / 2 + 300, 650, 80, 88, true, paint);
    }
}
