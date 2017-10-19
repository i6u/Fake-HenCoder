package com.mymeek.fake.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mymeek.fake.Utils;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        Paint mPaint = new Paint();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(Utils.getDisplayWidth(this.getContext()) / 2 - 200, 100, Utils.getDisplayWidth(this.getContext()) / 2 + 200, 400, 15, 150, false, mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(Utils.getDisplayWidth(this.getContext()) / 2 - 200, 100, Utils.getDisplayWidth(this.getContext()) / 2 + 200, 400, 180, 45, false, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(Utils.getDisplayWidth(this.getContext()) / 2 - 200, 100, Utils.getDisplayWidth(this.getContext()) / 2 + 200, 400, 240, 105, true, mPaint);
        }
    }
}
