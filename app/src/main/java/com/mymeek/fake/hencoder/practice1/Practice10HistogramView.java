package com.mymeek.fake.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // 画坐标轴
        mPaint.setColor(0xffffffff);
        mPaint.setStrokeWidth(2f);
        canvas.drawLine(100, 50, 100, 650, mPaint);
        canvas.drawLine(100, 650, 1000, 650, mPaint);

        Random random = new Random();

        ArrayList<Integer> arrayList = new ArrayList();

        for (int i = 0; i < 7; i++) {
            int n = random.nextInt(7) + 1;
            if (!arrayList.contains(n)) {
                arrayList.add(n);
            } else {
                i--;
            }
        }

        List<Integer> coord = new ArrayList<>();
        mPaint.setColor(Color.rgb(96, 177, 00));

        for (int i = 1; i <= 7; i++) {
            canvas.drawRect(125 * i, arrayList.get(i - 1) * 90, 125 * i + 90, 650, mPaint);
            coord.add(i - 1, 125 * i + 45);
        }


        mPaint.setColor(0xffffffff);
        mPaint.setTextSize(25f);
        String[] strs = {"Froyo", "GB", "IC S", "JB", "KitKat", "L", "M"};

        for (int i = 0; i < strs.length; i++) {
            canvas.drawText(strs[i], coord.get(i) - (mPaint.measureText(strs[i]) / 2), 680, mPaint);
        }

    }
}
