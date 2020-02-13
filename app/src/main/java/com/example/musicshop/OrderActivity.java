package com.example.musicshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Your offer");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userName");
        String goodsName = receivedOrderIntent.getStringExtra("goodsName");
        int quantity = receivedOrderIntent.getIntExtra("quantity",0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice",0);
        double price = receivedOrderIntent.getDoubleExtra("price",0);


        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText("Customer name: " + userName + "\n" + "Goods name: " + goodsName
                + "\n" + "Quantity: " + quantity + "\n" + "Price: " + price +"\n" + "Order price: " + orderPrice);
    }
}
