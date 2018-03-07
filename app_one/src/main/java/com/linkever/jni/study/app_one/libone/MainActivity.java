package com.linkever.jni.study.app_one.libone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linkever.jni.study.app_one.R;
import com.linkever.jni.study.base.baselib.RouterCommonUtil;

@Route(path = "/libone/oneactivity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLibone;
    private Button btnLibtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
//        btnLibone = (Button) findViewById(R.id.btn_libone1);
//        btnLibtwo = (Button) findViewById(R.id.btn_libone2);
        findViewById(R.id.btn_libone1).setOnClickListener(this);
        findViewById(R.id.btn_libone2).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = (view.getId());
        if(id == R.id.btn_libone1){
            RouterCommonUtil.startMainActivity(this,"arg1");
        }else if(id == R.id.btn_libone2){
            RouterCommonUtil.startLibTwoActivity(this);
        }
    }
}
