package com.fallersapp.fallersapp.plan;

import android.widget.ImageView;

/**
 * Created by hamda on 28/07/2017.
 */

public class ListItem {
    String barang;
    ImageView hapus;

    public ListItem() {
    }

    public ListItem(String barang) {
        this.barang = barang;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }
}
