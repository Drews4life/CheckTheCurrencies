package com.example.drews.checkthecurrencies.simplecurrencies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Drews on 30.11.2017.
 */

public interface ServiceApiCur {
    //https://api.fixer.io/latest?symbols=USD,RUB,CAD,AUD,GBR
    @GET("latest")
    Call<List<Money>> getMoneys(@Query("USD") int start, @Query("GBR") int limit);
}
