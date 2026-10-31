package model;

public class Barang {
    private String idBarang;
    private String namaBarang;
    private int hargaJual;
    private int stokBarang;

    public Barang(String idBarang, String namaBarang, int hargaJual, int stokBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.hargaJual = hargaJual;
        this.stokBarang = stokBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    @Override
    public String toString() {
        return idBarang + " - " + namaBarang + " (Rp" + hargaJual + " | Stok: " + stokBarang + ")";
    }
}
