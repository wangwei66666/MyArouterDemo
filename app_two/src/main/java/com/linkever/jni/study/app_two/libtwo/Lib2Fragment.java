package com.linkever.jni.study.app_two.libtwo;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linkever.jni.study.app_two.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = "/lib2F/lib2F")
public class Lib2Fragment extends Fragment{


    public Lib2Fragment() {
    }
    private TextView lib2Text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        lib2Text = (TextView) view.findViewById(R.id.lib2_text);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lib2, container, false);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetEvent(MyEvent myEvent){
        lib2Text.setText(String.format("Oh:%s",myEvent.getStr()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
