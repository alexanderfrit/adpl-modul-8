package model;

public class PembayaranTunai implements MetodePembayaran {
    @Override
    public void bayar(int totalBelanja) {
        System.out.println("Membayar Rp" + totalBelanja + " menggunakan Tunai.");
    }

    @Override
    public String getNamaMetode() {
        return "Tunai";
    }
}
