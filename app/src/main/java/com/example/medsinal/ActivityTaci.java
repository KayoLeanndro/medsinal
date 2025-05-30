package com.example.medsinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTaci extends AppCompatActivity  {


    private static final String WHATSAPP_URL = "https://wa.me/+558193923162";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taci);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        Button btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnWhatsapp.setOnClickListener(v -> openWhatsApp());

    }
    private void openWhatsApp() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(WHATSAPP_URL));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}