package com.example.saurabh.assignment.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saurabh.assignment.AppConstants.Constants;
import com.example.saurabh.assignment.R;

/**
 * fragment class in which outer view pager is there
 */

public class ItemTypeFragment extends Fragment implements Constants {
    private ViewPager viewPager;
    private Button mbtnPast, mbtnUpcoming;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemtype, container, false);
        init(view);
        changeButtonColor(Constants.PAST);
        mbtnPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(Constants.PAST);
                changeButtonColor(Constants.PAST);
            }
        });
        mbtnUpcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(Constants.UPCOMING);
                changeButtonColor(Constants.UPCOMING);
            }
        });
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position == Constants.PAST){
                    return InnerViewpagerFragment.getObjectInstance(Constants.PAST);
                }
                else{
                    return InnerViewpagerFragment.getObjectInstance(Constants.UPCOMING);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });


        return view;

    }

    /**
     * find all ids
     *
     * @param v of view type
     */
    public void init(View v) {
        viewPager = (ViewPager) v.findViewById(R.id.vp_swipe);
        mbtnPast = (Button) v.findViewById(R.id.btn_past);
        mbtnUpcoming = (Button) v.findViewById(R.id.btn_upcoming);
    }

    /**
     * use change color of button
     */
    public void changeButtonColor(int change) {
        if (change == 0) {
            mbtnPast.setBackgroundResource(R.color.bgBlue);
            mbtnUpcoming.setBackgroundResource(R.color.colorPrimaryDark);
        } else {
            mbtnPast.setBackgroundResource(R.color.colorPrimaryDark);
            mbtnUpcoming.setBackgroundResource(R.color.bgBlue);
        }
    }

}
