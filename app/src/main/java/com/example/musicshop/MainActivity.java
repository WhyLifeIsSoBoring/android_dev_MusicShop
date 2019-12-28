package com.example.musicshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap itemPrice;
    String itemName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        itemPrice = new HashMap();
        itemPrice.put("guitar", 300.0);
        itemPrice.put("drums", 1000.0);
        itemPrice.put("keyboard", 900.0);

    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityCounter = findViewById(R.id.quantity_counter);
        quantityCounter.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price + " $");
    }

    public void decreaseQuantity(View view) {
        if (quantity <= 0) quantity = 0;
        else quantity = quantity - 1;
        TextView quantityCounter = findViewById(R.id.quantity_counter);
        quantityCounter.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price + " $");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemName = spinner.getSelectedItem().toString();
        price = (double)itemPrice.get(itemName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price + " $");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
