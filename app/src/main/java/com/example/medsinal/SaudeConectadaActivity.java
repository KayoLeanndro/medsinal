package com.example.medsinal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsinal.databinding.ActivitySaudeConectaBinding;

public class SaudeConectadaActivity extends AppCompatActivity {
    private ActivitySaudeConectaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaudeConectaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // habilita botão de voltar
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(SaudeConectadaActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.btn1.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityHivAids.class);
            startActivity(intent);
        });

        binding.btn2.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivitySifilis.class);
            startActivity(intent);
        });

        binding.btn3.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityHerpes.class);
            startActivity(intent);
        });

        binding.btn4.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGonorreia.class);
            startActivity(intent);
        });

        binding.btn5.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityHpv.class);
            startActivity(intent);
        });

        binding.btn6.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityHepatite.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
