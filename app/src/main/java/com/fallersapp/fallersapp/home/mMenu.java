package com.fallersapp.fallersapp.home;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hamda on 26/07/2017.
 */

public class mMenu implements Parcelable {

    String menu;
    int icon;

    public mMenu(int icon, String menu){
        this.menu = menu;
        this.icon = icon;
    }

    public void setMana(String menu) {
        this.menu = menu;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getMenu() {
        return menu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public mMenu(String menu, int icon) {
        this.menu = menu;
        this.icon = icon;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.menu);
        parcel.writeInt(this.icon);
    }

    protected mMenu(Parcel in){
        this.menu = in.readString();
        this.icon = in.readInt();
    }

    public static final Parcelable.Creator<mMenu> CREATOR = new Parcelable.Creator<mMenu>() {
        @Override
        public mMenu createFromParcel(Parcel source) {
            return new mMenu(source);
        }

        @Override
        public mMenu[] newArray(int size) {
            return new mMenu[size];
        }
    };
}
