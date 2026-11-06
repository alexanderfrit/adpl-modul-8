# Sistem Kasir Warung Sembako Bu Wiwi (Tugas Modul 8 ADPL)

Aplikasi GUI Kasir berbasis **Java Swing**, **MVC**, **JDBC MySQL**, dan prinsip **SOLID** sesuai dokumen **SRS Warung Sembako Bu Wiwi**.

## Fitur Utama (MVP)
- **Memproses Transaksi Kasir**: Memilih barang sembako, memasukkan jumlah beli, memvalidasi ketersediaan stok (`"Gagal: Stok barang tidak mencukupi"`), menghitung total belanja otomatis, memilih metode pembayaran (`Tunai` / `Transfer`), memotong stok barang di database MySQL, dan menampilkan riwayat transaksi pada tabel.

## Penerapan Konsep Modul 1–7
- **MVC (Modul 3 & 4)**:
  - `model`: `Database`, `Barang`, `Transaksi`, `TransaksiDAO`, `MetodePembayaran`, `PembayaranTunai`, `PembayaranTransfer`.
  - `view`: `KasirView` (komponen GUI Java Swing).
  - `controller`: `KasirController` (menghubungkan `KasirView` dan `model`).
- **SOLID (Modul 5, 6, 7)**:
  - **SRP**: `Barang` dan `Transaksi` menyimpan data entitas, `TransaksiDAO` menangani query SQL CRUD, `Database` menangani koneksi JDBC, dan `KasirView` menampilkan GUI.
  - **OCP**: Metode pembayaran baru dapat ditambahkan dengan mengimplementasikan `MetodePembayaran` tanpa mengubah kode `Transaksi` atau `KasirController`.
  - **LSP**: `PembayaranTunai` dan `PembayaranTransfer` dapat menggantikan tipe `MetodePembayaran` tanpa mengubah perilaku program.
  - **ISP**: Interface `MetodePembayaran` hanya memiliki metode yang relevan dengan pembayaran.
  - **DIP**: `Transaksi` dan `KasirController` bergantung pada abstraksi interface `MetodePembayaran`, bukan kelas konkret.

## Cara Menjalankan di NetBeans / Eclipse
1. Aktifkan MySQL (XAMPP) dan jalankan script `database.sql`.
2. **Di NetBeans**:
   - Buka proyek melalui `File -> Open Project` lalu pilih folder ini.
   - Klik kanan proyek `warung-bu-wiwi` -> **Clean and Build** untuk mengunduh dependensi MySQL JDBC.
   - Tekan tombol **Run Project** (`F6`) atau klik kanan `Main.java` -> **Run File** (`Shift + F6`).
3. **Di Eclipse**:
   - Import melalui `File -> Import -> Maven -> Existing Maven Projects`, lalu jalankan `Main.java`.
