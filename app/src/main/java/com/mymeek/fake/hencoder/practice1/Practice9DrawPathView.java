package com.mymeek.fake.hencoder.practice1;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mymeek.fake.Utils;


public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path mPath = new Path();

        mPath.addArc(Utils.getDisplayWidth(this.getContext()) / 2 - 200, 200, Utils.getDisplayWidth(this.getContext()) / 2, 400, -225, 225);
        mPath.arcTo(Utils.getDisplayWidth(this.getContext()) / 2, 200, Utils.getDisplayWidth(this.getContext()) / 2 + 200, 400, -180, 225, false);
        mPath.lineTo(Utils.getDisplayWidth(this.getContext()) / 2 , 550);
        canvas.drawPath(mPath, mPaint);
    }
}
