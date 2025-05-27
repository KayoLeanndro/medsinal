package com.example.medsinal;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private View cardQuemSomos;
    private Button btnQuemSomos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Vincula os componentes da tela
        cardQuemSomos = findViewById(R.id.card_quem_somos);
        btnQuemSomos = findViewById(R.id.btn_quem_somos);

        // Inicialmente oculta o card
        cardQuemSomos.setVisibility(View.GONE);

        // Quando clicar no botão, exibe o card com animação e esconde o botão
        btnQuemSomos.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition((ViewGroup) cardQuemSomos.getParent(), new AutoTransition());
            cardQuemSomos.setVisibility(View.VISIBLE);
            btnQuemSomos.setVisibility(View.GONE);
        });

        // Quando clicar no card, esconde o card com animação e mostra o botão
        cardQuemSomos.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition((ViewGroup) cardQuemSomos.getParent(), new AutoTransition());
            cardQuemSomos.setVisibility(View.GONE);
            btnQuemSomos.setVisibility(View.VISIBLE);
        });
    }

    public void abrirTelaBuscarSaude(View view) {
        Intent intent = new Intent(this, BuscaSaudeActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void abrirTelaSaudeConectada(View view) {
        Intent intent = new Intent(this, SaudeConectadaActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void abrirTelaSTaci(View view) {
        Intent intent = new Intent(this, ActivityTaci.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    // Para navegação reversa com suporte ao botão "voltar"
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
