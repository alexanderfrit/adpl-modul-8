package model;

public class PembayaranTransfer implements MetodePembayaran {
    @Override
    public void bayar(int totalBelanja) {
        System.out.println("Membayar Rp" + totalBelanja + " menggunakan Transfer.");
    }

    @Override
    public String getNamaMetode() {
        return "Transfer";
    }
}
