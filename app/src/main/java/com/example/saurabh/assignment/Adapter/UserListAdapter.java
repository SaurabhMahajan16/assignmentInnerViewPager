package com.example.saurabh.assignment.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.assignment.ItemTypeActivity;
import com.example.saurabh.assignment.Model.UserInfo;
import com.example.saurabh.assignment.R;

import java.util.List;

/**
 * Recycler View adapter holds and binds views
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<UserInfo> userInfoList;
    private Context mContext;

    public UserListAdapter(final Context context, final List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
        mContext = context;
    }

    @Override

    public UserListAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent,
                                                         final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recycler,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserListAdapter.ViewHolder holder, final int position) {
        UserInfo userList = userInfoList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvName.setText(userList.getName());
        viewHolder.tvGender.setText(userList.getGender());

    }

    @Override
    public int getItemCount() {
        return userInfoList.size();
    }

    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName, tvGender;

        /**
         * It is a constructor of viewHolder class
         *
         * @param itemView is there to access items of activity
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            itemView.setOnClickListener(this
            );
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                final UserInfo user = userInfoList.get(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(itemView.getContext());
                alertDialogBuilder.setTitle("Options");
                alertDialogBuilder
                        .setMessage("You selected ")
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(mContext, ItemTypeActivity.class);
                                // add data to intent extras
                                intent.putExtra("key", user);
                                mContext.startActivity(intent);

                            }
                        }).setCancelable(true);

            alertDialogBuilder.create();

            alertDialogBuilder.show();

        }
    }
}
}
