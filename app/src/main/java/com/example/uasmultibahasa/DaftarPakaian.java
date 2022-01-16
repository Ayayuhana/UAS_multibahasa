package com.example.uasmultibahasa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmultibahasa.model.Pakaian;

import java.util.List;

public class DaftarPakaian extends AppCompatActivity {
    public final static String PAKAIAN_TERPILIH ="pakaian_obj_key";
    List<Pakaian> pakaians;
    ListView listView;
    String jenisPakaian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftaractivity_pakaian);
        Intent intent = getIntent();
        jenisPakaian = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText("다른 유형의 목록 "+ jenisPakaian.toUpperCase());
        pakaians = DataProvider.getPakaiansByTipe(this,jenisPakaian);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_pakaian);
        DaftarAdapterActifity adapter = new DaftarAdapterActifity(this, pakaians);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Pakaian terpilih = pakaians.get(position);
            bukaProfilePakaian(terpilih);
        }
    };

    private void bukaProfilePakaian(Pakaian pakaianTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, PrifleActifity.class);
        intent.putExtra(PAKAIAN_TERPILIH, pakaianTerpilih);
        startActivity(intent);
    }
    }
