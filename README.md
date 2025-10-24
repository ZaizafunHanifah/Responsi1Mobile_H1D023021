# 📱 Responsi 1 - Zaizafun Hanifah Zainnur Hanun

**Nama:** Zaizafun Hanifah Zainnur Hanun  
**NIM:** H1D023021 
**Shift Baru:** C  
**Shift Asal:** A  

---

## 🖼️ Demo Aplikasi
![Demo Aplikasi](responsi1.gif)

---

## Alur Data dari API hingga Penyajian di Layar

1. **Pemanggilan API**  
   - ApiService mendefinisikan endpoint yang digunakan untuk mengambil data dari server.  
   - ApiClient membuat instance Retrofit dengan base URL dan converter (GsonConverterFactory) untuk memproses data JSON dari API.

2. **Request Data**  
   - Activity atau Fragment memanggil metode dari ApiService (misalnya getTeams() atau getTeamDetail()) untuk meminta data.  
   - Hasil response diterima dalam bentuk TeamResponse.

3. **Response Handling**  
   - Data yang diterima dari API diparsing ke model data seperti Player dan Coach agar mudah digunakan di layer tampilan.

4. **Penyajian UI**  
   - Data daftar pemain ditampilkan menggunakan **RecyclerView** melalui **Adapter**.  
   - Detail tim seperti nama, logo, dan pelatih ditampilkan langsung di **TextView** atau **ImageView**.

