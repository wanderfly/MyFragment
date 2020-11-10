package com.kevin.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FragmentContainerView mFragmentView;
    private FragmentManager mFragManger;

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
    }
}