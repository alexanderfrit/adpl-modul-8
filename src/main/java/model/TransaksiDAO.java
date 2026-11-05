package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDAO {

    public List<Barang> getAllBarang() {
        List<Barang> daftarBarang = new ArrayList<>();
        Database db = new Database();
        db.connect();
        ResultSet rs = db.view("SELECT * FROM barang");
        try {
            while (rs != null && rs.next()) {
                daftarBarang.add(new Barang(
                        rs.getString("id_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga_jual"),
                        rs.getInt("stok_barang")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan saat membaca data barang: " + e.getMessage());
        }
        db.disconnect();
        return daftarBarang;
    }

    public void simpanTransaksi(Transaksi t) {
        Barang b = t.getBarang();
        int sisaStok = b.getStokBarang() - t.getJumlahBeli();
        b.setStokBarang(sisaStok);

        Database db = new Database();
        db.connect();
        db.query("INSERT INTO transaksi (id_transaksi, id_barang, jumlah_beli, total_belanja, metode_bayar) VALUES ('"
                + t.getIdTransaksi() + "', '" + b.getIdBarang() + "', " + t.getJumlahBeli() + ", "
                + t.getTotalBelanja() + ", '" + t.getMetodePembayaran().getNamaMetode() + "')");
        db.query("UPDATE barang SET stok_barang=" + sisaStok + " WHERE id_barang='" + b.getIdBarang() + "'");
        db.disconnect();
    }

    public List<Object[]> getAllTransaksi() {
        List<Object[]> daftarTransaksi = new ArrayList<>();
        Database db = new Database();
        db.connect();
        ResultSet rs = db.view("SELECT t.id_transaksi, b.nama_barang, t.jumlah_beli, t.total_belanja, t.metode_bayar "
                + "FROM transaksi t JOIN barang b ON t.id_barang = b.id_barang");
        try {
            while (rs != null && rs.next()) {
                daftarTransaksi.add(new Object[]{
                        rs.getString("id_transaksi"),
                        rs.getString("nama_barang"),
                        rs.getInt("jumlah_beli"),
                        rs.getInt("total_belanja"),
                        rs.getString("metode_bayar")
                });
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan saat membaca data transaksi: " + e.getMessage());
        }
        db.disconnect();
        return daftarTransaksi;
    }
}
