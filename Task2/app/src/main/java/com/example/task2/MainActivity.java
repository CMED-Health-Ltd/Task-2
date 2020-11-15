package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;


public class MainActivity extends AppCompatActivity  {
        private FragmentManager fm;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ListFragment ListFragment = new ListFragment();
            ft.add(R.id.fragmentContainer, ListFragment);
            ft.commit();
        }


}





