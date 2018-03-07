package com.linkever.jni.study.myarouterdemo.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.linkever.jni.study.myarouterdemo.BuildConfig;

/**
 * Author:      WW
 * Date:        2018/3/6 14:18
 * Description: This is MyApplication
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openLog();//打印日志
            ARouter.openDebug();//开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }
}
