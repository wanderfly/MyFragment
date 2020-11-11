package com.kevin.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kevin.myfragment.frag.MyFragmentOne;
import com.kevin.myfragment.frag.MyFragmentTwo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FragmentContainerView mFragmentView;
    private FragmentManager mFragManger;
    private MyFragmentOne mFragOne;
    private MyFragmentTwo mFragTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentView = findViewById(R.id.fragment_container_view);
        mFragManger = getSupportFragmentManager();

        List<Fragment> list = mFragManger.getFragments();
        mFragManger.beginTransaction();
        Log.d(TAG, "onCreate: lists.length:" + list.size());
        for (Fragment f : list) {
            Log.d(TAG, "\n ---onCreate: " + f.getTag());
        }

        //mFragOne=FragmentFactory.loadFragmentClass(getClassLoader(),getPackageName()+MyFragmentOne.class.getName());
        //FragmentFactory.loadFragmentClass(getClassLoader(),getPackageName()+ MyFragmentTwo.class.getName());
        //mFragOne=new MyFragmentOne();
        //mFragTwo=new MyFragmentTwo();

        Log.d(TAG, "onCreate: one:" + MyFragmentOne.class.getName());
        Log.d(TAG, "onCreate: two:" + MyFragmentTwo.class.getName());
        mFragOne = (MyFragmentOne) getSupportFragmentManager().getFragmentFactory().instantiate(getClassLoader(), MyFragmentOne.class.getName());
        mFragTwo = (MyFragmentTwo) getSupportFragmentManager().getFragmentFactory().instantiate(getClassLoader(), MyFragmentTwo.class.getName());


        findViewById(R.id.btn_one).setOnClickListener(v -> {

           //mFragManger.beginTransaction()
           //        .addToBackStack(MyFragmentOne.class.getName())
           //        .add(R.id.fragment_container_view, mFragOne).commit();

            MyDialog dialog=new MyDialog(MainActivity.this);
            dialog.setTitle("测试专用");
            dialog.show();
        });
        findViewById(R.id.btn_two).setOnClickListener(v -> {
            //mFragManger.findFragmentByTag(MyFragmentOne.class.getName());
            //mFragManger.beginTransaction()
            //        .addToBackStack(MyFragmentOne.class.getName())
            //        .add(R.id.fragment_container_view, mFragTwo).commit();
        });

    }

    private class MyDialog extends BottomSheetDialog{
        public MyDialog(@NonNull Context context) {
            super(context);
        }

        public MyDialog(@NonNull Context context, int theme) {
            super(context, theme);
        }

        protected MyDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
        }
    }
}