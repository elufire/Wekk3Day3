
package com.example.wekk3day3.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registered implements Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private String age;
    public final static Creator<Registered> CREATOR = new Creator<Registered>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Registered createFromParcel(Parcel in) {
            return new Registered(in);
        }

        public Registered[] newArray(int size) {
            return (new Registered[size]);
        }

    }
    ;

    protected Registered(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((String) in.readValue((Integer.class.getClassLoader())));
    }

    public Registered() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(age);
    }

    public int describeContents() {
        return  0;
    }

}
