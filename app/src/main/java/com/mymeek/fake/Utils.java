package com.mymeek.fake;

import android.content.Context;

/**
 * Created by witt on 2017/9/20.
 */

public class Utils {
    public static int getDisplayWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
