package com.fallersapp.fallersapp.plan;

import android.os.Parcel;
import android.os.Parcelable;

import com.fallersapp.fallersapp.home.mMenu;

/**
 * Created by hamda on 28/07/2017.
 */

public class mListBarang implements Parcelable {

    String barang;

    public String getBarang() {
        return barang;
    }

    public mListBarang(String barang) {
        this.barang = barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    @Override
    public int describeContents() {
        return 0;

    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.barang);
    }

    protected mListBarang(Parcel in){
        this.barang = in.readString();
    }

    public static final Parcelable.Creator<mListBarang> CREATOR = new Parcelable.Creator<mListBarang>() {
        @Override
        public mListBarang createFromParcel(Parcel source) {
            return new mListBarang(source);
        }

        @Override
        public mListBarang[] newArray(int size) {
            return new mListBarang[size];
        }
    };
}
