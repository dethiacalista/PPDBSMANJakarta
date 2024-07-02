package com.example.ppdbsmanegerijakarta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.DatePickerDialog;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.Toolbar;

public class DaftarActivity extends AppCompatActivity {

    private EditText etNama, etNISN, etTanggalLahir, etNoTelp, etEmail, etRataNilai, etSekolah;
    private RadioGroup rgJurusan;
    private Button btnDaftar;
    private SharedPreferences sharedPreferences;
    private String selectedSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        etNama = findViewById(R.id.etNama);
        etNISN = findViewById(R.id.etNISN);
        etTanggalLahir = findViewById(R.id.etTanggalLahir);
        etNoTelp = findViewById(R.id.etNoTelp);
        etEmail = findViewById(R.id.etEmail);
        etRataNilai = findViewById(R.id.etRataNilai);
        rgJurusan = findViewById(R.id.rgJurusan);
        btnDaftar = findViewById(R.id.btnDaftar);
        etSekolah = findViewById(R.id.etSekolah);

        sharedPreferences = getSharedPreferences("PPDB_PREFS", MODE_PRIVATE);

        // Ambil nama sekolah yang dipilih dari intent
        selectedSchool = getIntent().getStringExtra("selectedSchool");
        if (selectedSchool != null) {
            etSekolah.setText(selectedSchool);
            // Simpan selectedSchool ke SharedPreferences agar tidak hilang saat activity dibuka kembali
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("selectedSchool", selectedSchool);
            editor.apply();
        } else {
            // Jika tidak ada selectedSchool dari intent, coba ambil dari SharedPreferences
            selectedSchool = sharedPreferences.getString("selectedSchool", "");
            etSekolah.setText(selectedSchool);
        }

        // Load data dari SharedPreferences jika ada
        loadSavedData();

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                String nama = etNama.getText().toString();
                String nisn = etNISN.getText().toString();
                String tanggalLahir = etTanggalLahir.getText().toString();
                String noTelp = etNoTelp.getText().toString();
                String email = etEmail.getText().toString();
                String rataNilai = etRataNilai.getText().toString();
                int selectedJurusanId = rgJurusan.getCheckedRadioButtonId();
                RadioButton selectedJurusan = findViewById(selectedJurusanId);
                String jurusan = selectedJurusan.getText().toString();

                new AlertDialog.Builder(DaftarActivity.this)
                        .setTitle("Pendaftaran Berhasil")
                        .setMessage("Siswa " + nama + " Berhasil Daftar di " + selectedSchool)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        etTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DaftarActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar selectedDate = Calendar.getInstance();
                                selectedDate.set(year, monthOfYear, dayOfMonth);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                                etTanggalLahir.setText(dateFormat.format(selectedDate.getTime()));
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nama", etNama.getText().toString());
        editor.putString("nisn", etNISN.getText().toString());
        editor.putString("tanggalLahir", etTanggalLahir.getText().toString());
        editor.putString("noTelp", etNoTelp.getText().toString());
        editor.putString("email", etEmail.getText().toString());
        editor.putString("rataNilai", etRataNilai.getText().toString());
        editor.putString("selectedSchool", etSekolah.getText().toString());
        editor.apply();
    }

    private void loadSavedData() {
        String nama = sharedPreferences.getString("nama", "");
        String nisn = sharedPreferences.getString("nisn", "");
        String tanggalLahir = sharedPreferences.getString("tanggalLahir", "");
        String noTelp = sharedPreferences.getString("noTelp", "");
        String email = sharedPreferences.getString("email", "");
        String rataNilai = sharedPreferences.getString("rataNilai", "");
        String school = sharedPreferences.getString("selectedSchool", "");

        etNama.setText(nama);
        etNISN.setText(nisn);
        etTanggalLahir.setText(tanggalLahir);
        etNoTelp.setText(noTelp);
        etEmail.setText(email);
        etRataNilai.setText(rataNilai);
        etSekolah.setText(school);
    }


}