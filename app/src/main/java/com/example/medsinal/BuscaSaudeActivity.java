package com.example.medsinal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsinal.databinding.ActivityBuscaSaudeBinding;
import com.example.medsinal.model.HealthUnit;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BuscaSaudeActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ActivityBuscaSaudeBinding binding;
    private GoogleMap mMap;

    private List<HealthUnit> healthUnits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBuscaSaudeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura o botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Inicializa o MapFragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Configurações do mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);

        // Carrega os dados do JSON
        loadHealthUnitsFromJson();

        // Adiciona marcadores de todas as unidades de saúde
        for (HealthUnit unit : healthUnits) {
            LatLng position = new LatLng(unit.getLatitude(), unit.getLongitude());
            mMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title(unit.getNome())
                    .snippet(unit.getEndereco() + "\n" + unit.getTelefone()));
        }

        LatLng centroRecife = new LatLng(-8.061895, -34.871684);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centroRecife, 14f));
    }

    private void loadHealthUnitsFromJson() {
        try {
            InputStream is = getAssets().open("health_units.json");
            Log.d("LoadHealthUnits", "Arquivo health_units.json aberto com sucesso");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONArray jsonArray = new JSONArray(sb.toString());
            Log.d("LoadHealthUnits", "JSON array criado com " + jsonArray.length() + " itens");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                HealthUnit unit = new HealthUnit(
                        obj.getString("Nome"),
                        obj.getString("Endereço"),
                        obj.getString("Bairro"),
                        obj.getString("Cidade"),
                        obj.getString("Estado"),
                        obj.getDouble("Latitude"),
                        obj.getDouble("Longitude"),
                        obj.optString("Horário", "Não informado"),
                        obj.optString("Telefone", "Não informado")
                );
                healthUnits.add(unit);
            }
            Log.d("LoadHealthUnits", "Unidades carregadas: " + healthUnits.size());

            reader.close();
            is.close();
        } catch (IOException e) {
            Log.e("LoadHealthUnits", "Erro ao abrir o arquivo: " + e.getMessage(), e);
            Toast.makeText(this, "Erro ao abrir o arquivo: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            Log.e("LoadHealthUnits", "Erro ao processar JSON: " + e.getMessage(), e);
            Toast.makeText(this, "Erro ao processar JSON: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}