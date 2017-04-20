package com.example.saurabh.assignment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.saurabh.assignment.Adapter.UserListAdapter;
import com.example.saurabh.assignment.Model.UserInfo;
import com.example.saurabh.assignment.R;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    private RecyclerView rvItem;
    private TextView tvTitle;
    private UserInfo infoUser;
    ArrayList<UserInfo>user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new ArrayList<>();
        setContentView(R.layout.activity_item_list);
        rvItem = (RecyclerView) findViewById(R.id.rv_itemList);
        tvTitle =(TextView) findViewById(R.id.tv_title);
        tvTitle.setText(getText(R.string.ItemsList));
        UserListAdapter adapter = new UserListAdapter(this, user);
        rvItem.setAdapter(adapter);
        rvItem.setLayoutManager(new GridLayoutManager(this,2));
        setItemsValue();
    }

    /**
     * add objects to recycler view
     */
    public void setItemsValue(){
       infoUser = new UserInfo(getText(R.string.raghav).toString(),
               getText(R.string.male).toString());
        user.add(infoUser);
        infoUser = new UserInfo(getText(R.string.sameer).toString(),
                getText(R.string.male).toString());
        user.add(infoUser);
        infoUser = new UserInfo(getText(R.string.rohan).toString(),
                getText(R.string.male).toString());
        user.add(infoUser);
        infoUser = new UserInfo(getText(R.string.sonali).toString(),
                getText(R.string.female).toString());
        user.add(infoUser);
        infoUser = new UserInfo(getText(R.string.pallavi).toString(),
                getText(R.string.female).toString());
        user.add(infoUser);

    }
}
