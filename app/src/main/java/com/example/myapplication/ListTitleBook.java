package com.example.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("ser")
public class ListTitleBook implements Serializable {
    private ArrayList<String>Tittles;

    public ListTitleBook() {
        Tittles = new ArrayList<>();
    }

    public ArrayList<String> getTittles() {
        return Tittles;
    }

    public void setTittles(ArrayList<String> tittles) {
        Tittles = tittles;
    }
}
