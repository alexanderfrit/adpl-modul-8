package model;

public class Transaksi {
    private String idTransaksi;
    private Barang barang;
    private int jumlahBeli;
    private int totalBelanja;
    private MetodePembayaran metodePembayaran;

    public Transaksi(String idTransaksi, Barang barang, int jumlahBeli, MetodePembayaran metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.barang = barang;
        this.jumlahBeli = jumlahBeli;
        this.totalBelanja = barang.getHargaJual() * jumlahBeli;
        this.metodePembayaran = metodePembayaran;
    }

    public void prosesPembayaran() {
        metodePembayaran.bayar(totalBelanja);
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public int getTotalBelanja() {
        return totalBelanja;
    }

    public MetodePembayaran getMetodePembayaran() {
        return metodePembayaran;
    }
}
