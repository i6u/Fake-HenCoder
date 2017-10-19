package com.mymeek.fake.hencoder.practice2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mymeek.fake.R;

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL, params 模糊范围，模糊类型
        //MaskFilter maskFilter = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
        //paint.setMaskFilter(maskFilter);

        float []direction = new float[]{50, 50, 50};
        float ambient = 0.5f;
        float specular = 1;
        float blurRadius = 20;
        EmbossMaskFilter filter = new EmbossMaskFilter(direction, ambient, specular, blurRadius);
        paint.setMaskFilter(filter);

        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        MaskFilter maskFilter1 = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(maskFilter1);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        MaskFilter maskFilter2 = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(maskFilter2);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        MaskFilter maskFilter3 = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(maskFilter3);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}
