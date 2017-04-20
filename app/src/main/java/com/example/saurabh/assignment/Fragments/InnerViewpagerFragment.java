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
 * Inner viewpager fragment
 */

public class InnerViewpagerFragment extends Fragment implements Constants {

    private Button btnPendingCompleted, btnAcceptedDenied;
    private ViewPager viewPager;

    /**
     * @param type is of int which is just used to check which button is pressed and it will return
     *             fragment corresponding to that
     * @return fragment
     */

    public static Fragment getObjectInstance(final int type) {
        InnerViewpagerFragment fragment = new InnerViewpagerFragment();
        Bundle bundle = new Bundle();
        if (type == PAST) {

            bundle.putInt("mode", PAST);
            fragment.setArguments(bundle);


        } else if (type == UPCOMING) {
            bundle.putInt("mode", UPCOMING);
            fragment.setArguments(bundle);
        }
        return fragment;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_inner_viewpager, container, false);
        init(view);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            changeButtonColor(PAST);
            int position = bundle.getInt("mode");
            if (position == PAST) {
                btnPendingCompleted.setText(getText(R.string.pending));
                btnAcceptedDenied.setText(getText(R.string.accepted));
            } else {
                btnPendingCompleted.setText(getText(R.string.completed));
                btnAcceptedDenied.setText(getText(R.string.cancelled));
            }

        }
        btnAcceptedDenied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(UPCOMING);
                changeButtonColor(UPCOMING);
            }
        });
        btnPendingCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(PAST);
                changeButtonColor(PAST);
            }
        });
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == PAST) {
                    return InnerFragmentContent.getObjectInstance(PAST);
                } else {
                    return InnerFragmentContent.getObjectInstance(UPCOMING);
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
     * finds all ids
     *
     * @param view to access items inside fragment because find view by id is method of activity
     */
    private void init(final View view) {
        viewPager = (ViewPager) view.findViewById(R.id.vp_innerswipe);
        btnAcceptedDenied = (Button) view.findViewById(R.id.btn_accepted_cancelled);
        btnPendingCompleted = (Button) view.findViewById(R.id.btn_pending_completed);
    }

    /**
     * used to change color of button
     */
    public void changeButtonColor(final int change) {
        if (change == 0) {
            btnPendingCompleted.setBackgroundResource(R.color.bgBlue);
            btnAcceptedDenied.setBackgroundResource(R.color.colorPrimaryDark);
        } else {
            btnPendingCompleted.setBackgroundResource(R.color.colorPrimaryDark);
            btnAcceptedDenied.setBackgroundResource(R.color.bgBlue);
        }
    }
}
