package com.example.jonathanmaldonado.w2d1_ex01;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonathan Maldonado on 7/21/2017.
 */

public class User implements Parcelable {
    private String name;
    private String lastName;
    private String email;
    private String username;

    public User(String name, String lastName, String email, String username) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }

    public User() {
    }

    public User(Parcelable parcelableExtra) {

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    protected User(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        email = in.readString();
        username = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(username);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}