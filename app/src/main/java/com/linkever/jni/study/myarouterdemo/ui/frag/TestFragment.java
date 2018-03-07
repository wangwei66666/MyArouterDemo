package com.linkever.jni.study.myarouterdemo.ui.frag;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.linkever.jni.study.app_two.libtwo.MyEvent;
import com.linkever.jni.study.myarouterdemo.R;

import org.greenrobot.eventbus.EventBus;

@Route(path = "/flag/textF")
public class TestFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private Button fragTxt;

    public TestFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        mParam1 = getArguments().getString("arg1");
        fragTxt = (Button) view.findViewById(R.id.frag_txt);
        fragTxt.setText(mParam1);
        fragTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击了~~~", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().post(new MyEvent("这是从TestFragment传来的数据"));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
