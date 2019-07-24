package com.example.assetfinance.services;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class DjangoService {

    public static void post(String first, String last,String email,String phone,String address,String description,Callback callback){
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("first_name", first)
                .add("last_name", last)
                .add("email", email)
                .add("phone", phone)
                .add("address", address)
                .add("description", description)
                .build();
        Request request = new Request.Builder()
                .url("http://3d25fd1c.ngrok.io/api/customers/")
                .post(formBody)
                .build();


        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
