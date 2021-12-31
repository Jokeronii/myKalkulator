package com.example.mykalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvHasil,tvRiwayat;
    EditText et1,et2;
    Button btPlus,btMin,btKali,btBagi;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHasil = (TextView) findViewById(R.id.tv_hasil);
        tvRiwayat = (TextView) findViewById(R.id.tv_riwayat);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btPlus = (Button) findViewById(R.id.bt_plus);
        btMin = (Button) findViewById(R.id.bt_minus);
        btKali = (Button) findViewById(R.id.bt_kali);
        btBagi = (Button) findViewById(R.id.bt_bagi);

        btPlus.setOnClickListener(this);
        btMin.setOnClickListener(this);
        btKali.setOnClickListener(this);
        btBagi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,tvRiwayat.getText().toString());
        editor.apply();

        switch (v.getId()){
            case R.id.bt_plus:
                tambah();
                simpan();
                load();
                tampil();
                break;
            case R.id.bt_minus:
                kurang();
                simpan();
                load();
                tampil();
                break;
            case R.id.bt_kali:
                kali();
                simpan();
                load();
                tampil();
                break;
            case R.id.bt_bagi:
                bagi();
                simpan();
                load();
                tampil();
                break;
        }

    }

    private void bagi() {
        if (et1.getText().toString().trim().isEmpty()) {
            Toast.makeText(this,"Angka Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float n1 = Float.parseFloat(String.valueOf(et1.getText()));
            float n2 = Float.parseFloat(String.valueOf(et2.getText()));
            float hasil = (n1 / n2);
            tvHasil.setText("" + hasil);

        }
    }

    private void kali() {
        if (et1.getText().toString().trim().isEmpty()) {
            Toast.makeText(this,"Angka Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float n1 = Float.parseFloat(String.valueOf(et1.getText()));
            float n2 = Float.parseFloat(String.valueOf(et2.getText()));
            float hasil = (n1 * n2);
            tvHasil.setText("" + hasil);

        }
    }

    private void kurang() {
        if (et1.getText().toString().trim().isEmpty()) {
            Toast.makeText(this,"Angka Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float n1 = Float.parseFloat(String.valueOf(et1.getText()));
            float n2 = Float.parseFloat(String.valueOf(et2.getText()));
            float hasil = (n1 - n2);
            tvHasil.setText("" + hasil);

        }
    }

    private void tambah() {
        if (et1.getText().toString().trim().isEmpty()) {
            Toast.makeText(this,"Angka Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float n1 = Float.parseFloat(String.valueOf(et1.getText()));
            float n2 = Float.parseFloat(String.valueOf(et2.getText()));
            float hasil = (n1 + n2);
            tvHasil.setText("" + hasil);

        }
    }

    private void simpan(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,tvHasil.getText().toString());
        editor.apply();
    }

    private void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
    }

    private void tampil(){
        tvRiwayat.setText(text);
    }
}