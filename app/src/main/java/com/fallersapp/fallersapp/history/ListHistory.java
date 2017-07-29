package com.fallersapp.fallersapp.history;

/**
 * Created by ziterz on 7/29/2017.
 */

public class ListHistory {
    String judul;
    String tujuan;
    String waktu;

    public ListHistory() {
    }

    public ListHistory(String judul, String tujuan, String waktu) {
        this.judul = judul;
        this.waktu = waktu;
        this.tujuan = tujuan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
