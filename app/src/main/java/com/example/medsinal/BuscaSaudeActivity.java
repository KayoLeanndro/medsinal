package com.example.medsinal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.medsinal.databinding.ActivityBuscaSaudeBinding;

public class BuscaSaudeActivity extends AppCompatActivity {

    private ActivityBuscaSaudeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Infla o layout usando view binding
        binding = ActivityBuscaSaudeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura o botão de voltar na action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Finaliza a activity quando o botão de voltar é pressionado
        return true;
    }
}