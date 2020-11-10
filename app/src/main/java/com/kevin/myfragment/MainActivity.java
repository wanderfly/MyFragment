package com.kevin.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        mFragmentView=findViewById(R.id.fragment_container_view);
        mFragManger=getSupportFragmentManager();

        List<Fragment> list=mFragManger.getFragments();
        mFragManger.beginTransaction();
        Log.d(TAG, "onCreate: lists.length:"+list.size());
        for (Fragment f : list) {
            Log.d(TAG, "\n ---onCreate: "+f.getTag());
        }

       //mFragOne=FragmentFactory.loadFragmentClass(getClassLoader(),getPackageName()+MyFragmentOne.class.getName());
       //FragmentFactory.loadFragmentClass(getClassLoader(),getPackageName()+ MyFragmentTwo.class.getName());
        mFragOne=new MyFragmentOne();
        mFragTwo=new MyFragmentTwo();
        findViewById(R.id.btn_one).setOnClickListener(v -> {
            mFragManger.beginTransaction().replace(R.id.fragment_container_view,mFragOne).commit();
        });
        findViewById(R.id.btn_two).setOnClickListener(v -> {
            mFragManger.beginTransaction().replace(R.id.fragment_container_view,mFragTwo).commit();
        });



    }
}