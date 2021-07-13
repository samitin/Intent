package ru.samitin.intent;

import android.os.Parcel;
import android.os.Parcelable;

public class Acount implements Parcelable {
    private String name;
    private String surName;
    private int age;
    private String email;

    public Acount(){}
    public Acount(String name,String surName,int age,String email){
        this.name=name;
        this.surName=surName;
        this.age=age;
        this.email=email;
    }
    protected Acount(Parcel in) {
        name = in.readString();
        surName = in.readString();
        age = in.readInt();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surName);
        dest.writeInt(age);
        dest.writeString(email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Acount> CREATOR = new Creator<Acount>() {
        @Override
        public Acount createFromParcel(Parcel in) {
            return new Acount(in);
        }

        @Override
        public Acount[] newArray(int size) {
            return new Acount[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
