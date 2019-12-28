package com.example.musicshop;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
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
