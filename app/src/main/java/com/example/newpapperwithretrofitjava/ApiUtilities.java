package com.example.newpapperwithretrofitjava;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static Retrofit retrofit = null;
    public static ApiInterface getApiInterface(){

        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(ApiInterface.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(ApiInterface.class);
    }
}
