package com.example.ppdbsmanegerijakarta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private TextView tvWelcome, tvDate, tvLocation;
    private Button btnPilihSekolah;
    private LocationManager locationManager;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        tvDate = findViewById(R.id.tvDate);
        tvLocation = findViewById(R.id.tvLocation);
        btnPilihSekolah = findViewById(R.id.btnPilihSekolah);

        tvWelcome.setText("Selamat Datang di PPDB SMA Negeri Jakarta");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        tvDate.setText(currentDate);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        btnPilihSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PilihSekolahActivity.class);
                startActivity(intent);
            }
        });

        checkLocationPermission();
    }

    private void checkLocationPermission() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            getLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(this, "Izin akses lokasi ditolak.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getLocation() {
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    // Tampilkan koordinat di TextView
                    tvLocation.setText("Latitude: " + latitude + "\nLongitude: " + longitude);
                    // Panggil Fetchloc untuk mendapatkan alamat dari koordinat lokasi
                    new Fetchloc(latitude, longitude, tvLocation).execute();
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {}

                @Override
                public void onProviderEnabled(String provider) {}

                @Override
                public void onProviderDisabled(String provider) {
                    Toast.makeText(MainActivity.this, "Aktifkan GPS untuk mendapatkan lokasi.", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private static class Fetchloc extends AsyncTask<Void, Void, String> {
        private double latitude;
        private double longitude;
        private TextView tvLocation;

        private static final String API_KEY = "6651c8709191d375874807hkl2c0fe2";

        Fetchloc(double latitude, double longitude, TextView tvLocation) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.tvLocation = tvLocation;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                String reverseGeocodeUrl = "https://geocode.maps.co/reverse?lat=" + latitude + "&lon=" + longitude + "&api_key=" + API_KEY;
                URL url = new URL(reverseGeocodeUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                return stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject addressObj = jsonObject.getJSONObject("address");

                    String village = addressObj.optString("village");
                    String suburb = addressObj.optString("suburb");
                    String cityDistrict = addressObj.optString("city_district");

                    // Membuat alamat yang terstruktur
                    StringBuilder addressBuilder = new StringBuilder();
                    if (!village.isEmpty()) {
                        addressBuilder.append("Kelurahan: ").append(village).append("\n");
                    }
                    if (!suburb.isEmpty()) {
                        addressBuilder.append("Kecamatan: ").append(suburb).append("\n");
                    }
                    if (!cityDistrict.isEmpty()) {
                        addressBuilder.append("Kota: ").append(cityDistrict);
                    }

                    // Tambahkan alamat di bawah koordinat di TextView
                    String existingText = tvLocation.getText().toString();
                    tvLocation.setText(existingText + "\n" + addressBuilder.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                // Tangani kesalahan jika tidak ada hasil yang diterima dari permintaan geokode
                Toast.makeText(tvLocation.getContext(), "Gagal mendapatkan alamat.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
