package com.example.uasmultibahasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button biodata, mediasosial;
    ImageButton btnBaju,btnCelana, btnRok;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

        biodata = (Button) findViewById(R.id.biodata_btn);
        mediasosial = (Button) findViewById(R.id.koleksi_btn);


        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, BiodataActivity.class);
                startActivity(intent);
            }
        });

        mediasosial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SosmedActivity.class);
                startActivity(intent);

            }
        });


    }

    private void inisialisasiView() {
        btnBaju = findViewById(R.id.btn_buka_model_baju);
        btnCelana = findViewById(R.id.btn_buka_model_celana);
        btnRok = findViewById(R.id.btn_buka_model_rok);
        btnBaju.setOnClickListener(view -> bukaGaleri("드레스"));
        btnCelana.setOnClickListener(view -> bukaGaleri("바지"));
        btnRok.setOnClickListener(view -> bukaGaleri("치마"));

    }

    private void bukaGaleri(String jenisPakaian) {
        Log.d("MAIN","Buka activity celana");
        Intent intent = new Intent(this, DaftarPakaian.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisPakaian);
        startActivity(intent);
    }

}