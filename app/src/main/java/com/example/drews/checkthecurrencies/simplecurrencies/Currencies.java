package com.example.drews.checkthecurrencies.simplecurrencies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.drews.checkthecurrencies.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Currencies extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView1;
    Button updateButton1;
    com.example.drews.checkthecurrencies.simplecurrencies.MyRecyclerViewAdapterCur adapter1;
    List<Money> moneyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencies);

        recyclerView1 = findViewById(R.id.recycler_view);

        adapter1 = new com.example.drews.checkthecurrencies.simplecurrencies.MyRecyclerViewAdapterCur(moneyList);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        updateButton1 = findViewById(R.id.button);
        updateButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Call<List<Money>> call = APICur.get().getMoneys(0, 20);
        call.enqueue(new Callback<List<Money>>() {
            @Override
            public void onResponse(Call<List<Money>> call, Response<List<Money>> response) {
                if (response.isSuccessful()) {
                    List<Money> moneys = response.body();
                    moneyList.clear();
                    moneyList.addAll(moneys);
                    adapter1.notifyItemRangeInserted(0, moneys.size());
                }
            }

            @Override
            public void onFailure(Call<List<Money>> call, Throwable t) {
                Toast.makeText(Currencies.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}