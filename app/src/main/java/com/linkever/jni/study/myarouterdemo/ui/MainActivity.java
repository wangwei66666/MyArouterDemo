package com.linkever.jni.study.myarouterdemo.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linkever.jni.study.app_two.libtwo.Lib2Fragment;
import com.linkever.jni.study.app_two.libtwo.MyEvent;
import com.linkever.jni.study.base.baselib.RouterCommonUtil;
import com.linkever.jni.study.myarouterdemo.R;
import com.linkever.jni.study.myarouterdemo.ui.frag.TestFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/ui/主页")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TestFragment mFragment;
    Lib2Fragment lib2Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EventBus.getDefault().register(this);
        initView();
        fragmentManager=getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        mFragment = (TestFragment) RouterCommonUtil.loadTestFragment("fragment传值成功");
        lib2Fragment = (Lib2Fragment) RouterCommonUtil.loadLib2Fragment();
        fragmentTransaction.add(R.id.testfragment,mFragment);
        fragmentTransaction.add(R.id.mainlib_addF_top,lib2Fragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        findViewById(R.id.main_btn_txt).setOnClickListener(this);
        findViewById(R.id.main_btn_img).setOnClickListener(this);
        findViewById(R.id.main_btn_app1).setOnClickListener(this);
        findViewById(R.id.main_btn_app2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.main_btn_txt:
                RouterCommonUtil.startMainTextActivity(this,"哈哈哈，测试文本");
                break;
            case R.id.main_btn_img:
                RouterCommonUtil.startMainImageActivity(this,"https://www.baidu.com/img/bd_logo1.png");
                break;
            case R.id.main_btn_app1:
                RouterCommonUtil.startLibOneActivity(this);
                break;
            case R.id.main_btn_app2:
                RouterCommonUtil.startLibTwoActivity(this);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1001){
            Toast.makeText(this, "Main____onActivityResult", Toast.LENGTH_SHORT).show();
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onGetEvent(MyEvent myEvent){
//        ((TextView)lib2Fragment.getActivity().findViewById(R.id.lib2_text)).setText(myEvent.getStr());
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
