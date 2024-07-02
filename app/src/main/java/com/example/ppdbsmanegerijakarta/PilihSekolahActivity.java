package com.example.ppdbsmanegerijakarta;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class PilihSekolahActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listSekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_sekolah);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listView = findViewById(R.id.listView);
        listSekolah = new ArrayList<>();

        listSekolah.add("SMA Negeri 1 Jakarta");
        listSekolah.add("SMA Negeri 2 Jakarta");
        listSekolah.add("SMA Negeri 3 Jakarta");
        listSekolah.add("SMA Negeri 4 Jakarta");
        listSekolah.add("SMA Negeri 5 Jakarta");
        listSekolah.add("SMA Negeri 6 Jakarta");
        listSekolah.add("SMA Negeri 7 Jakarta");
        listSekolah.add("SMA Negeri 8 Jakarta");
        listSekolah.add("SMA Negeri 9 Jakarta");
        listSekolah.add("SMA Negeri 10 Jakarta");
        listSekolah.add("SMA Negeri 11 Jakarta");
        listSekolah.add("SMA Negeri 12 Jakarta");
        listSekolah.add("SMA Negeri 13 Jakarta");
        listSekolah.add("SMA Negeri 14 Jakarta");
        listSekolah.add("SMA Negeri 15 Jakarta");
        listSekolah.add("SMA Negeri 16 Jakarta");
        listSekolah.add("SMA Negeri 17 Jakarta");
        listSekolah.add("SMA Negeri 18 Jakarta");
        listSekolah.add("SMA Negeri 19 Jakarta");
        listSekolah.add("SMA Negeri 20 Jakarta");
        listSekolah.add("SMA Negeri 21 Jakarta");
        listSekolah.add("SMA Negeri 22 Jakarta");
        listSekolah.add("SMA Negeri 23 Jakarta");
        listSekolah.add("SMA Negeri 24 Jakarta");
        listSekolah.add("SMA Negeri 25 Jakarta");
        listSekolah.add("SMA Negeri 26 Jakarta");
        listSekolah.add("SMA Negeri 27 Jakarta");
        listSekolah.add("SMA Negeri 28 Jakarta");
        listSekolah.add("SMA Negeri 29 Jakarta");
        listSekolah.add("SMA Negeri 30 Jakarta");
        listSekolah.add("SMA Negeri 31 Jakarta");
        listSekolah.add("SMA Negeri 32 Jakarta");
        listSekolah.add("SMA Negeri 33 Jakarta");
        listSekolah.add("SMA Negeri 34 Jakarta");
        listSekolah.add("SMA Negeri 35 Jakarta");
        listSekolah.add("SMA Negeri 36 Jakarta");
        listSekolah.add("SMA Negeri 37 Jakarta");
        listSekolah.add("SMA Negeri 38 Jakarta");
        listSekolah.add("SMA Negeri 39 Jakarta");
        listSekolah.add("SMA Negeri 40 Jakarta");
        listSekolah.add("SMA Negeri 41 Jakarta");
        listSekolah.add("SMA Negeri 42 Jakarta");
        listSekolah.add("SMA Negeri 43 Jakarta");
        listSekolah.add("SMA Negeri 44 Jakarta");
        listSekolah.add("SMA Negeri 45 Jakarta");
        listSekolah.add("SMA Negeri 46 Jakarta");
        listSekolah.add("SMA Negeri 47 Jakarta");
        listSekolah.add("SMA Negeri 48 Jakarta");
        listSekolah.add("SMA Negeri 49 Jakarta");
        listSekolah.add("SMA Negeri 50 Jakarta");
        listSekolah.add("SMA Negeri 51 Jakarta");
        listSekolah.add("SMA Negeri 52 Jakarta");
        listSekolah.add("SMA Negeri 53 Jakarta");
        listSekolah.add("SMA Negeri 54 Jakarta");
        listSekolah.add("SMA Negeri 55 Jakarta");
        listSekolah.add("SMA Negeri 56 Jakarta");
        listSekolah.add("SMA Negeri 57 Jakarta");
        listSekolah.add("SMA Negeri 58 Jakarta");
        listSekolah.add("SMA Negeri 59 Jakarta");
        listSekolah.add("SMA Negeri 60 Jakarta");
        listSekolah.add("SMA Negeri 61 Jakarta");
        listSekolah.add("SMA Negeri 62 Jakarta");
        listSekolah.add("SMA Negeri 63 Jakarta");
        listSekolah.add("SMA Negeri 64 Jakarta");
        listSekolah.add("SMA Negeri 65 Jakarta");
        listSekolah.add("SMA Negeri 66 Jakarta");
        listSekolah.add("SMA Negeri 67 Jakarta");
        listSekolah.add("SMA Negeri 68 Jakarta");
        listSekolah.add("SMA Negeri 69 Jakarta");
        listSekolah.add("SMA Negeri 70 Jakarta");
        listSekolah.add("SMA Negeri 71 Jakarta");
        listSekolah.add("SMA Negeri 72 Jakarta");
        listSekolah.add("SMA Negeri 73 Jakarta");
        listSekolah.add("SMA Negeri 74 Jakarta");
        listSekolah.add("SMA Negeri 75 Jakarta");
        listSekolah.add("SMA Negeri 76 Jakarta");
        listSekolah.add("SMA Negeri 77 Jakarta");
        listSekolah.add("SMA Negeri 78 Jakarta");
        listSekolah.add("SMA Negeri 79 Jakarta");
        listSekolah.add("SMA Negeri 80 Jakarta");
        listSekolah.add("SMA Negeri 81 Jakarta");
        listSekolah.add("SMA Negeri 82 Jakarta");
        listSekolah.add("SMA Negeri 83 Jakarta");
        listSekolah.add("SMA Negeri 84 Jakarta");
        listSekolah.add("SMA Negeri 85 Jakarta");
        listSekolah.add("SMA Negeri 86 Jakarta");
        listSekolah.add("SMA Negeri 87 Jakarta");
        listSekolah.add("SMA Negeri 88 Jakarta");
        listSekolah.add("SMA Negeri 89 Jakarta");
        listSekolah.add("SMA Negeri 90 Jakarta");
        listSekolah.add("SMA Negeri 91 Jakarta");
        listSekolah.add("SMA Negeri 92 Jakarta");
        listSekolah.add("SMA Negeri 93 Jakarta");
        listSekolah.add("SMA Negeri 94 Jakarta");
        listSekolah.add("SMA Negeri 95 Jakarta");
        listSekolah.add("SMA Negeri 96 Jakarta");
        listSekolah.add("SMA Negeri 97 Jakarta");
        listSekolah.add("SMA Negeri 98 Jakarta");
        listSekolah.add("SMA Negeri 99 Jakarta");
        listSekolah.add("SMA Negeri 100 Jakarta");
        listSekolah.add("SMA Negeri 101 Jakarta");
        listSekolah.add("SMA Negeri 102 Jakarta");
        listSekolah.add("SMA Negeri 103 Jakarta");
        listSekolah.add("SMA Negeri 104 Jakarta");
        listSekolah.add("SMA Negeri 105 Jakarta");
        listSekolah.add("SMA Negeri 106 Jakarta");
        listSekolah.add("SMA Negeri 107 Jakarta");
        listSekolah.add("SMA Negeri 108 Jakarta");
        listSekolah.add("SMA Negeri 109 Jakarta");
        listSekolah.add("SMA Negeri 110 Jakarta");
        listSekolah.add("SMA Negeri 111 Jakarta");
        listSekolah.add("SMA Negeri 112 Jakarta");
        listSekolah.add("SMA Negeri 113 Jakarta");
        listSekolah.add("SMA Negeri 114 Jakarta");
        listSekolah.add("SMA Negeri 115 Jakarta");
        listSekolah.add("SMA Negeri Unggulan Mohammad Husni Thamrin");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSekolah);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSchool = listSekolah.get(position);
                Intent intent = new Intent(PilihSekolahActivity.this, DaftarActivity.class);
                intent.putExtra("selectedSchool", selectedSchool);
                startActivity(intent);
            }
        });
    }
}