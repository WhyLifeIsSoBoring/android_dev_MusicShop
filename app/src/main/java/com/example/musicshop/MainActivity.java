package com.example.musicshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
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
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.name);
        createSpinner();

        createMap();

    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap() {
        itemPrice = new HashMap();
        itemPrice.put("guitar", 300.0);
        itemPrice.put("drums", 1000.0);
        itemPrice.put("keyboard", 900.0);
    }

    public void increaseQuantity(View view) {
        if ( quantity == 5) quantity = 5;
        else quantity = quantity + 1;
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

        quantity = 0;
        TextView quantityCounter = findViewById(R.id.quantity_counter);
        quantityCounter.setText("" + quantity);

        itemName = spinner.getSelectedItem().toString();
        price = (double)itemPrice.get(itemName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price + " $");

        ImageView itemImageView = findViewById(R.id.item);

        switch (itemName) {
            case "guitar":
                itemImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                itemImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                itemImageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                itemImageView.setImageResource(R.drawable.guitar);
                break;
        }

        if (itemName.equals("guitar")) {
            itemImageView.setImageResource(R.drawable.guitar);
        } else if (itemName.equals("drums")) {
            itemImageView.setImageResource(R.drawable.drums);
        } else if (itemName.equals("keyboard")) {
            itemImageView.setImageResource(R.drawable.keyboard);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {

        Order order = new Order();

        order.userName = userNameEditText.getText().toString();

        order.goodsName = itemName;

        order.quantity = quantity;

        order.orderPrice = quantity * price;

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userName",order.userName);
        orderIntent.putExtra("goodsName",order.goodsName);
        orderIntent.putExtra("quantity",order.quantity);
        orderIntent.putExtra("orderPrice",order.orderPrice);

        startActivity(orderIntent);
    }
}
