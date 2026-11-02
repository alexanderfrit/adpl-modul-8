package main;

import controller.KasirController;
import view.KasirView;

public class Main {
    public static void main(String[] args) {
        KasirView view = new KasirView();
        new KasirController(view);
    }
}