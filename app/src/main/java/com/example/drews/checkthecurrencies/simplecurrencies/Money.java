package com.example.drews.checkthecurrencies.simplecurrencies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Money extends Rates {

    @SerializedName("rates")
    @Expose
    private Rates rates;

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

}