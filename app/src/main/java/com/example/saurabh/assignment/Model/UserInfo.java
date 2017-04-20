package com.example.saurabh.assignment.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by saurabh on 20/4/17.
 */

public class UserInfo implements Parcelable{
    private String mName, mGender;
    
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

    /**
     * construcotor which is called when object is created
     * @param mName name of person
     */
    public UserInfo(final String mName,final String mGender) {
        this.mName = mName;
        this.mGender = mGender;
    }

    /**
     * function to get name of a person
     * @return name of person
     */
    public String getName() {
        return mName;
    }

    /**
     *
     * @return gender of type string
     */
    public String getGender(){
        return mGender;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mGender);
    }

    /**
     *
     * @param in parcel type copies value of name to read string
     */
    public UserInfo(final Parcel in){
        mName = in.readString();
        mGender = in.readString();
    }
}
