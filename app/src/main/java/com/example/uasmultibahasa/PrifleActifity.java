package com.example.uasmultibahasa;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmultibahasa.model.Pakaian;

public class PrifleActifity extends AppCompatActivity {
    Pakaian pakaian;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView pakaianivFotoPakaian;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_jenis);
        Intent intent = getIntent();
        pakaian = (Pakaian) intent.getSerializableExtra(DaftarPakaian.PAKAIAN_TERPILIH);
        inisialisasiView();
        tampilkanProfil(pakaian);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        pakaianivFotoPakaian = findViewById(R.id.gambarPakaian);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void tampilkanProfil(Pakaian pakaian) {
        Log.d("Profil","Menampilkan "+ pakaian.getJenis());
        txJudul.setText(pakaian.getJenis());
        txJenis.setText(pakaian.getRas());
        txAsal.setText(pakaian.getAsal());
        txDeskripsi.setText(pakaian.getDeskripsi());
        pakaianivFotoPakaian.setImageDrawable(this.getDrawable(pakaian.getDrawableRes()));
    }

}
