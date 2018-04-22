package com.mydemo.picasso;


import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RenderScript;

import com.squareup.picasso.Transformation;

/**
 * Created by Administrator on 2018/4/22.
 */

public class BlurTransformation implements Transformation {

    RenderScript rs;

    public BlurTransformation(Context context) {
        super();
        rs=RenderScript.create(context);
    }


    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap blurBitmap=source.copy(Bitmap.Config.ARGB_8888,true);




        return null;
    }

    @Override
    public String key() {
        return null;
    }
}
