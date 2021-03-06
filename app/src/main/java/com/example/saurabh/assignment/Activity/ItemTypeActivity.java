package com.example.saurabh.assignment.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.saurabh.assignment.Fragments.ItemTypeFragment;
import com.example.saurabh.assignment.R;

/**
 * class in which fragment is there
 */
public class ItemTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_type);
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        ItemTypeFragment itemTypeFragment = new ItemTypeFragment();
        fragmentTransaction.replace(R.id.container, itemTypeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
