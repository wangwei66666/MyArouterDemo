package com.linkever.jni.study.base.baselib.interceptor;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/**
 * Author:      WW
 * Date:        2018/3/6 16:03
 * Description: This is InterceptCallback
 */

public abstract class InterceptCallback implements NavigationCallback {
    /**
     * 找到
     *
     * @param postcard
     */
    @Override
    public void onFound(Postcard postcard) {

    }

    /**
     * 找不到了
     *
     * @param postcard
     */
    @Override
    public void onLost(Postcard postcard) {

    }

    /**
     * 跳转完了
     *
     * @param postcard
     */
    @Override
    public void onArrival(Postcard postcard) {

    }

    /**
     * 被拦截了
     *
     * @param postcard
     */
    @Override
    public void onInterrupt(Postcard postcard) {

    }

}
