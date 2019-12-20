package com.example.musicshop;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityCounter = findViewById(R.id.quantity_counter);
        quantityCounter.setText("" + quantity);
    }

    public void decreaseQuantity(View view) {
        if (quantity <= 0) quantity = 0;
        else quantity = quantity - 1;
        TextView quantityCounter = findViewById(R.id.quantity_counter);
        quantityCounter.setText("" + quantity);
    }
}
