package com.example.drews.checkthecurrencies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drews.checkthecurrencies.simplecurrencies.Currencies;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCrypto = findViewById(R.id.crypto);
        buttonCrypto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), CryptoCurrencies.class);
                startActivity(intent);
            }
        });


        Button buttonCurrency = findViewById(R.id.currency);
        buttonCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Currencies.class);
                startActivity(intent);
            }
        });
    }
}


