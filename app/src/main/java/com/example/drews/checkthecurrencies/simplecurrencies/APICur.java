package com.example.drews.checkthecurrencies.simplecurrencies;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Drews on 30.11.2017.
 */

public class APICur {
    private static ServiceApiCur api1;
    public static ServiceApiCur get() {
        if (api1 == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.fixer.io/")
                    .build();

            api1 = retrofit.create(ServiceApiCur.class);
        }
        return api1;
    }
}
