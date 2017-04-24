package com.example.saurabh.assignment.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model class for user which contains user real life properties
 */
public class UserInfo implements Parcelable {
    /**
     * this is a constructor of parcelable class and creater object
     */
    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        public UserInfo createFromParcel(final Parcel in) {
            return new UserInfo(in);
        }

        public UserInfo[] newArray(final int size) {
            return new UserInfo[size];
        }
    };
    private String mName, mGender;

    /**
     * constructor which is called when object is created
     *
     * @param mName   contains name
     * @param mGender contains gender
     */

    public UserInfo(final String mName, final String mGender) {
        this.mName = mName;
        this.mGender = mGender;
    }

    /**
     * @param in parcel type copies value of name to read string
     */
    public UserInfo(final Parcel in) {
        mName = in.readString();
        mGender = in.readString();
    }

    /**
     * function to get name of a person
     *
     * @return name of person
     */
    public String getName() {
        return mName;
    }

    /**
     * @return gender of type string
     */
    public String getGender() {
        return mGender;
    }

    /**
     * @return contents
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * @param dest  destination object
     * @param flags flag
     */
    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mName);
        dest.writeString(mGender);
    }
}
