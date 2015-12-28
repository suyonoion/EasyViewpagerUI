package com.suyonoion.easyviewpagerui;

/**
 * Created by Suyono on 5/22/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

public class CubeOutTransformer implements ViewPager.PageTransformer
{
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void transformPage(View view, float position) {
        final float rotation = (position < 0 ? 90f : -90f) * Math.abs(position);
        view.setAlpha(rotation > 90f || rotation < -90f ? 0f : 1f);
        view.setPivotX(position < 0f ? view.getWidth() : 0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(90f * position);
    }
}

