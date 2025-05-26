package com.example.medsinal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsinal.databinding.ActivitySifilisBinding;

public class ActivitySifilis extends AppCompatActivity {

    private ActivitySifilisBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySifilisBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Habilita botão de voltar na ActionBar
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Configura ação do botão voltar
        binding.btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySifilis.this, SaudeConectadaActivity.class);
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
