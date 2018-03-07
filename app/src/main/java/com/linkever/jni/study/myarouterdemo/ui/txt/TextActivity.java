package com.linkever.jni.study.myarouterdemo.ui.txt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linkever.jni.study.base.baselib.RouterCommonUtil;
import com.linkever.jni.study.myarouterdemo.R;

import java.util.Date;

@Route(path = "/ui/text",group = "文本")
public class TextActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        textView = (TextView) findViewById(R.id.textView);
        String str = getIntent().getStringExtra("arg1");
        if (!TextUtils.isEmpty(str)){
            textView.setText(str);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        setResult(1002,getIntent().putExtra("arg2",new Date().toString()));
    }
}
