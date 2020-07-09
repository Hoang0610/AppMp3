package com.example.hoangmp3.Service;

public class ApiService {

    private  static  String base_url="https://hoangpro131.000webhostapp.com/Server/";

    public  static  DataService getService (){
        return ApiRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
