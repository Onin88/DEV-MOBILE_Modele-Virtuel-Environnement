package com.example.virtualmodel;

import android.widget.ImageView;

public class Mur{

    Orientation o;
    ImageView mur;
    Mur murProchain;

    public Mur(Orientation o, ImageView mur) {
        this.o = o;
        this.mur = mur;
    }

    public ImageView getMur() {
        return mur;
    }

    public Orientation getO() {
        return o;
    }

    public void setMur(ImageView mur) {
        this.mur = mur;
    }

    public void setO(Orientation o) {
        this.o = o;
    }

    public void setMurProchain(Mur murProchain) {
        this.murProchain = murProchain;
    }

    public Mur getMurProchain() {
        return murProchain;
    }
}
