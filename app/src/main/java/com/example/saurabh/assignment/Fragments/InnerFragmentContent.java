package com.example.saurabh.assignment.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.assignment.AppConstants.Constants;
import com.example.saurabh.assignment.R;

/**
 * inner fargment class to display contents.
 */
public class InnerFragmentContent extends Fragment implements Constants {
    private TextView tvName, tvGender, tvOnline;

    /**
     * @param type int to check which button clicked
     * @return fragment type
     */
    public static Fragment getObjectInstance(final int type) {
        InnerFragmentContent fragment = new InnerFragmentContent();
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
        View view = inflater.inflate(R.layout.fragment_innercontent, container, false);
        init(view);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt("mode");
            if (position == PAST) {
                tvName.setText(getText(R.string.raghavPending));
                tvGender.setText(getText(R.string.male));

            } else {
                tvName.setText(getText(R.string.raghavAccpted));

                tvGender.setText(getText(R.string.online));
            }

        }
        return view;
    }

    /**
     * find all ids
     *
     * @param view type of view
     */
    private void init(final View view) {
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvGender = (TextView) view.findViewById(R.id.tv_gender);
        tvOnline = (TextView) view.findViewById(R.id.tv_online);
    }

    /**
     * this method is for checkstyle used because interface should contain a abstract method
     */
    public void methodInterface() {

    }
}


