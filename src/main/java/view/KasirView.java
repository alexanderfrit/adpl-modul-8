package view;

import model.Barang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class KasirView extends JFrame {
    private final JComboBox<Barang> comboBarang;
    private final JTextField textJumlah;
    private final JComboBox<String> comboMetode;
    private final JButton btnBayar;
    private final JTable table;
    private final DefaultTableModel tableModel;

    public KasirView() {
        setTitle("Kasir Warung Sembako Bu Wiwi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(4, 2));
        panelForm.add(new JLabel("Barang:"));
        comboBarang = new JComboBox<>();
        panelForm.add(comboBarang);

        panelForm.add(new JLabel("Jumlah Beli:"));
        textJumlah = new JTextField();
        panelForm.add(textJumlah);

        panelForm.add(new JLabel("Metode Bayar:"));
        comboMetode = new JComboBox<>(new String[]{"Tunai", "Transfer"});
        panelForm.add(comboMetode);

        panelForm.add(new JLabel(""));
        btnBayar = new JButton("Bayar");
        panelForm.add(btnBayar);

        tableModel = new DefaultTableModel(
                new String[]{"ID Transaksi", "Nama Barang", "Jumlah", "Total Belanja", "Metode Bayar"}, 0
        );
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelForm, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public JComboBox<Barang> getComboBarang() {
        return comboBarang;
    }

    public JTextField getTextJumlah() {
        return textJumlah;
    }

    public JComboBox<String> getComboMetode() {
        return comboMetode;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addBayarListener(ActionListener listener) {
        btnBayar.addActionListener(listener);
    }
}
