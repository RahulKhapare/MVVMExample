package com.rak_developer.mvvm_example.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroCallInstance {

    //    http://api.hicare.in/mobile/api/ComplaintProtocol/GetComplaintProtocolList?taskId=a232x0000036zFyAAI


    public static String BASE_URL = "http://api.hicare.in/mobile/api/";

    private static Retrofit retrofit;

    public static Retrofit getRetroClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
