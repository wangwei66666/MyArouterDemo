package com.linkever.jni.study.app_two.libtwo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.linkever.jni.study.app_two.R;
import com.linkever.jni.study.base.baselib.RouterCommonUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/lib/twoactivity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLibtwo1;
    private Button btnLibtwo2;
    FragmentTransaction mFragmentTransaction;
    Lib2Fragment mLib2Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnLibtwo1 = (Button) findViewById(R.id.btn_libtwo1);
        btnLibtwo2 = (Button) findViewById(R.id.btn_libtwo2);
        btnLibtwo1.setOnClickListener(this);
        btnLibtwo2.setOnClickListener(this);
        mFragmentTransaction = getFragmentManager().beginTransaction();
        mLib2Fragment = (Lib2Fragment) ARouter.getInstance().build("/lib2F/lib2F").navigation();
        mFragmentTransaction.add(R.id.lib2_addF,mLib2Fragment);
        mFragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn_libtwo1){
            RouterCommonUtil.startMainActivity(this,"arg1");
        }else if(id == R.id.btn_libtwo2){
            RouterCommonUtil.startLibOneActivity(this);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
