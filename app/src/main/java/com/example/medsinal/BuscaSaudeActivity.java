package com.example.medsinal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.medsinal.databinding.ActivityBuscaSaudeBinding;
import com.example.medsinal.model.HealthUnit;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import org.json.*;
import java.io.*;
import java.util.*;

public class BuscaSaudeActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ActivityBuscaSaudeBinding binding;
    private GoogleMap mMap;
    private final List<HealthUnit> healthUnits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuscaSaudeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // habilita botão de voltar
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnBack.setOnClickListener(v -> {
            // Encerra esta Activity e retorna para a MainActivity
            finish();
        });

        // inicia o mapa
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setupMapUi();
        loadHealthUnitsFromJson();
        addMarkers();
        centerCamera();

        View mapView = ((SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map)).getView();
        if (mapView != null) {
            final ScrollView scrollView = binding.scrollView;
            mapView.setOnTouchListener((v, event) -> {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        scrollView.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        scrollView.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false; // deixa o mapa continuar recebendo os eventos
            });
        }
    }

    private void setupMapUi() {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        UiSettings ui = mMap.getUiSettings();
        ui.setZoomControlsEnabled(true);
        ui.setAllGesturesEnabled(true);
        ui.setCompassEnabled(true);
        ui.setMyLocationButtonEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
    }

    private void loadHealthUnitsFromJson() {
        try (InputStream is = getAssets().open("health_units.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            JSONArray arr = new JSONArray(sb.toString());
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                healthUnits.add(new HealthUnit(
                        o.getString("Nome"),
                        o.getString("Endereço"),
                        o.getString("Bairro"),
                        o.getString("Cidade"),
                        o.getString("Estado"),
                        o.getDouble("Latitude"),
                        o.getDouble("Longitude"),
                        o.optString("Horário", "Não informado"),
                        o.optString("Telefone", "Não informado")
                ));
            }
        } catch (IOException | JSONException e) {
            Toast.makeText(this, "Erro ao carregar unidades de saúde", Toast.LENGTH_LONG).show();
        }
    }

    private void addMarkers() {
        for (HealthUnit u : healthUnits) {
            LatLng pos = new LatLng(u.getLatitude(), u.getLongitude());
            mMap.addMarker(new MarkerOptions()
                    .position(pos)
                    .title(u.getNome())
                    .snippet(u.getEndereco() + "\n" + u.getTelefone()));
        }
    }

    private void centerCamera() {
        LatLng recife = new LatLng(-8.061895, -34.871684);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recife, 14f));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
