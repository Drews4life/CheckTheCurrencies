package com.example.drews.checkthecurrencies.simplecurrencies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Price")
    @Expose
    private float priceUsd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(float priceUsd) {
        this.priceUsd = priceUsd;
    }

}
