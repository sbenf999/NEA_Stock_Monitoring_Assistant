package com.example.nea_stockmonitoringassistant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homescreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homeScreen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Logout(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        startActivity(intent);
    }

    public void recordDelivery(View view) {
    }

    public void stockCounting(View view) {
    }

    public void dataView(View view) {
    }

    public void openSettings(View view) {
        Intent intent = new Intent(HomeScreen.this, Settings.class);
        startActivity(intent);
    }
}