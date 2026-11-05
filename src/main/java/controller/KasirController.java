package controller;

import model.*;
import view.KasirView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KasirController {
    private final KasirView view;
    private final TransaksiDAO dao;
    private int nomorNota = 1;

    public KasirController(KasirView view, TransaksiDAO dao) {
        this.view = view;
        this.dao = dao;

        loadBarang();
        loadTable();

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

                String pilihanMetode = (String) view.getComboMetode().getSelectedItem();
                MetodePembayaran metode = "Tunai".equals(pilihanMetode)
                        ? new PembayaranTunai()
                        : new PembayaranTransfer();

                String idTransaksi = "TRX" + System.currentTimeMillis() % 10000 + nomorNota++;
                Transaksi transaksi = new Transaksi(idTransaksi, barang, jumlah, metode);
                transaksi.prosesPembayaran();
                dao.simpanTransaksi(transaksi);

                view.getComboBarang().repaint();
                view.getTextJumlah().setText("");
                loadTable();
                JOptionPane.showMessageDialog(view, "Transaksi Berhasil! Total: Rp" + transaksi.getTotalBelanja());
            }
        });
    }

    private void loadBarang() {
        view.getComboBarang().removeAllItems();
        for (Barang b : dao.getAllBarang()) {
            view.getComboBarang().addItem(b);
        }
    }

    private void loadTable() {
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);
        for (Object[] row : dao.getAllTransaksi()) {
            tableModel.addRow(row);
        }
    }
}