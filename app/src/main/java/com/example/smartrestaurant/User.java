package com.example.smartrestaurant;

public class User {
    private String mAccount;
    private String mPassword;
    private String mRank;

    public User(String mAccount, String mPassword, String mRank) {
        this.mAccount = mAccount;
        this.mPassword = mPassword;
        this.mRank = mRank;
    }

    public String getmAccount() {
        return mAccount;
    }

    public void setmAccount(String mAccount) {
        this.mAccount = mAccount;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmRank() {
        return mRank;
    }

    public void setmRank(String mRank) {
        this.mRank = mRank;
    }
}
