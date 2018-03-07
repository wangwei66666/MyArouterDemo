package com.linkever.jni.study.base.baselib;

import android.app.Activity;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.linkever.jni.study.base.baselib.interceptor.InterceptCallback;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


/**
 * Author:      WW
 * Date:        2018/3/6 15:42
 * Description: This is RouterCommonUtil
 */

public class RouterCommonUtil {

    /**
     * Toast 主线程Toast
     * @param activity
     * @param postcard
     */
    private static void toastInterruptInfo(final Activity activity,final Postcard postcard){
        if(postcard.getTag()!=null&&postcard.getTag() instanceof String){
            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    if(!e.isDisposed()){
                        e.onNext(postcard.getTag().toString());
                    }
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    if (!TextUtils.isEmpty(s) && activity != null) {
                        Toast.makeText(activity, s, Toast.LENGTH_LONG).show();
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    Toast.makeText(activity, "失败~~~", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 跳转TextActivity
     * @param acticity
     * @param value
     */
    public static void startMainTextActivity(final Activity acticity,  String value){
        ARouter.getInstance().build("/ui/text", "文本").withString("arg1",value).withTransition(R.anim.rotate_in,R.anim.rotate_out).navigation(acticity, 1001, new InterceptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                 toastInterruptInfo(acticity,postcard);
            }
        });
    }

    /**
     * 跳转ImageActivity
     * @param activity
     * @param value
     */
    public static void startMainImageActivity(final Activity activity,String value){
        ARouter.getInstance().build("/ui/image","图片").withString("arg1",value).navigation(activity,1001, new InterceptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                toastInterruptInfo(activity,postcard);
            }

            @Override
            public void onArrival(Postcard postcard) {
                super.onArrival(postcard);
                String group = postcard.getGroup();
                Log.e("TAG", "分组是: " + group);
            }
        });
    }

    /**
     * 跳转至
     * @param activity
     * @param value
     */
    public static void startMainActivity(final Activity activity,String value){
        ARouter.getInstance().build("/ui/主页").withString("arg1",value).navigation(activity, new InterceptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                toastInterruptInfo(activity,postcard);
            }
        });
    }

    /**
     * 跳转至 libone 的 MainActivity
     * @param activity
     */
    public static void startLibOneActivity(final Activity activity){
        ARouter.getInstance().build("/libone/oneactivity").navigation(activity, new InterceptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                toastInterruptInfo(activity,postcard);
            }
        });
    }

    /**
     * 跳转至 libtwo 的 MainActivity
     * @param activity
     */
    public static void startLibTwoActivity(final Activity activity){
        ARouter.getInstance().build("/lib/twoactivity").navigation(activity, new InterceptCallback() {
            @Override
            public void onInterrupt(Postcard postcard) {
                super.onInterrupt(postcard);
                toastInterruptInfo(activity,postcard);
            }
        });
    }

    public static Fragment loadTestFragment(String value){
       return (Fragment) ARouter.getInstance().build("/flag/textF").withString("arg1","fragment传值成功").navigation();
    }

    public static Fragment loadLib2Fragment(){
        return (Fragment)ARouter.getInstance().build("/lib2F/lib2F").navigation();
    }
}
