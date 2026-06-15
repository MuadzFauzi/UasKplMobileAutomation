# UAS Kualitas Perangkat Lunak - Mobile Test Automation

Repository ini dibuat untuk memenuhi tugas Ujian Akhir Semester (UAS) mata kuliah **Kualitas Perangkat Lunak (KPL)**. Projek ini mendemonstrasikan implementasi *Mobile Test Automation* pada aplikasi Android menggunakan framework **Appium** dan bahasa pemrograman **Java**.

---

## 👥 Detail Mahasiswa
* **Nama:** Muadz Fauzi
* **NIM:** 2308107010042
* **Kelas:** B
* **Program Studi:** Informatika

---

## 📝 Deskripsi Projek
Projek ini terdiri dari dua komponen utama yang digabungkan dalam satu pengelolaan struktur proyek:
1. **`app` (Application under Test):** Aplikasi Android "E-Learning Portal" sederhana yang memiliki fitur autentikasi (Login & Dashboard Verification).
2. **`automation` (Test Suite Module):** Modul Java murni yang berisi skrip pengujian otomatis berbasis Appium dan TestNG untuk menguji fungsionalitas dan ketahanan aplikasi Android tersebut.

---

## 🛠️ Teknologi & Library
* **Bahasa Pemrograman:** Java (JDK 11/21)
* **Mobile Test Framework:** Appium (Java Client 8.6.0)
* **Testing Framework:** TestNG (7.8.0)
* **Automation Driver:** UIAutomator2 Driver
* **Build System:** Gradle (Groovy DSL)
* **Runtime Environment:** Node.js (v24.x)

---

## ⚙️ Prasyarat & Konfigurasi Sistem
Sebelum menjalankan skrip pengujian, pastikan *environment variables* berikut telah dikonfigurasi pada sistem operasi Anda:

* **`JAVA_HOME`**: Mengarah ke direktori instalasi Java JDK.
* **`ANDROID_HOME`**: Mengarah ke direktori SDK Android (Contoh: `C:\Android\Sdk`).
* **Path tambahan**: Direktori `platform-tools` dan `build-tools` dari Android SDK harus dimasukkan ke dalam sistem `Path`.

### Instalasi Appium Server via Terminal:
```bash
npm install -g appium
appium driver install uiautomator2

```

---

## 🧪 Skenario Pengujian (Test Cases)

Pengujian otomatis ini menggunakan pendekatan *Functional Testing* dengan mencakup **3 skenario utama** (diatur berdasarkan prioritas eksekusi):

| No | Nama Test Case | Tipe Pengujian | Deskripsi Skenario | Ekspektasi Hasil (Assertion) |
| --- | --- | --- | --- | --- |
| 1 | `testLoginKosong` | *Negative Test* | Mengklik tombol login tanpa mengisi field username dan password. | Muncul pesan error: *"Username dan Password wajib diisi!"* |
| 2 | `testLoginGagal` | *Negative Test* | Memasukkan kredensial acak/salah ke dalam form login. | Muncul pesan error: *"Username atau Password salah!"* |
| 3 | `testLoginSukses` | *Positive Test* | Memasukkan kredensial valid (User: `admin`, Pass: `admin123`). | Aplikasi berhasil pindah halaman ke Dashboard dan menampilkan teks *"Halo, admin!"* |

---

## 🚀 Cara Menjalankan Pengujian

1. **Jalankan Emulator Android** melalui Android Studio Device Manager.
2. **Aktifkan Server Appium** melalui Command Prompt atau Terminal dengan perintah:
```bash
appium

```


3. Pastikan file `app-debug.apk` telah berada di jalur yang benar sesuai konfigurasi *Capabilities* di kode Java (`options.setApp("D:/UAS_KPL/app-debug.apk");`).
4. Buka proyek di Android Studio, masuk ke modul `automation`, lalu navigasikan ke file `src/main/java/com/example/automation/KplAutomationTest.java`.
5. Klik kanan pada kelas atau metode pengujian, lalu pilih **Run 'KplAutomationTest'**.
6. Pantau pergerakan otomatis pada emulator dan hasil laporan akhir dari panel TestNG (*Passed 3/3*).

---

## 📂 Struktur Berkas Utama

```text
UasKplApp/
│
├── app/                              # Source code aplikasi Android (AUT)
│   └── build/outputs/apk/debug/      # Letak file app-debug.apk asli
│
├── automation/                       # Modul Java Test Automation Suite
│   └── src/main/java/com/example/
│       └── automation/
│           └── KplAutomationTest.java # File Skrip Utama Pengujian Appium
│
└── build.gradle                      # Konfigurasi Gradle utama proyek

```
