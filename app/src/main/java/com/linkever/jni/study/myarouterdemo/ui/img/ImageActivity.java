package com.linkever.jni.study.myarouterdemo.ui.img;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.linkever.jni.study.myarouterdemo.R;

@Route(path = "/ui/image",group = "图片")
public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        String url = getIntent().getStringExtra("arg1");
        if(!TextUtils.isEmpty(url)){
            Log.d("TAG",url);
            Glide.with(this).load(url).into((ImageView)findViewById(R.id.imageView));
        }
    }
}
