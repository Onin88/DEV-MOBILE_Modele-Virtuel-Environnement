package com.example.virtualmodel;

import android.widget.ImageView;

public class Piece {

    Mur N;
    Mur S;
    Mur E;
    Mur O;
    int numero;

    public Piece(Mur N, Mur S, Mur E, Mur O, int numero) {
        this.N = N;
        this.S = S;
        this.E = E;
        this.O = O;
        this.numero = numero;
    }

    public Mur getE() {
        return E;
    }

    public Mur getN() {
        return N;
    }

    public Mur getO() {
        return O;
    }

    public Mur getS() {
        return S;
    }
}
