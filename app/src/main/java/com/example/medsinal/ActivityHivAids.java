package com.example.medsinal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.medsinal.databinding.ActivityHivAidsBinding;

public class ActivityHivAids extends AppCompatActivity {

    private ActivityHivAidsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHivAidsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Habilita botão de voltar na ActionBar
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Configura ação do botão voltar
        binding.btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityHivAids.this, SaudeConectadaActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
