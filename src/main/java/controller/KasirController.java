package controller;

import model.*;
import view.KasirView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KasirController {
    private final KasirView view;

    public KasirController(KasirView view) {
        this.view = view;

        view.addBayarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Barang barang = (Barang) view.getComboBarang().getSelectedItem();
                if (barang == null) {
                    return;
                }
                int jumlah = Integer.parseInt(view.getTextJumlah().getText());
                if (jumlah > barang.getStokBarang()) {
                    JOptionPane.showMessageDialog(view, "Gagal: Stok barang tidak mencukupi");
                    return;
                }
                int total = barang.getHargaJual() * jumlah;
                JOptionPane.showMessageDialog(view, "Transaksi Berhasil! Total: Rp" + total);
            }
        });
    }
}