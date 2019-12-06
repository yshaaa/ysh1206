package com.bawei.week1.glide;

import android.widget.ImageView;

import com.bawei.week1.R;
import com.bawei.week1.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

public class GlideUtil {
    public static void Loadimage(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
