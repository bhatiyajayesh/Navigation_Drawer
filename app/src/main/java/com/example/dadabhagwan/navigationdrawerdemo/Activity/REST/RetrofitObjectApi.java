package com.example.dadabhagwan.navigationdrawerdemo.Activity.REST;

import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Preview.Examples;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.StudentObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dadabhagwan on 11/28/2016.
 */

public interface RetrofitObjectApi {

    @GET("/json_data.json")
    Call<Examples> getStudentDetails();
}
