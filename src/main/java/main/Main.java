package main;

import controller.KasirController;
import model.TransaksiDAO;
import view.KasirView;

public class Main {
    public static void main(String[] args) {
        KasirView view = new KasirView();
        TransaksiDAO dao = new TransaksiDAO();
        new KasirController(view, dao);
    }
}