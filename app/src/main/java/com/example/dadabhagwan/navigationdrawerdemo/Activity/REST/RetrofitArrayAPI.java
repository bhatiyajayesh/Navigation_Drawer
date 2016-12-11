package com.example.dadabhagwan.navigationdrawerdemo.Activity.REST;

import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.Example;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.StudentObject;
import com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO.user.Example1;
//import com.example.dadabhagwan.retrofit.POJO.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dadabhagwan on 11/23/2016.
 */

public interface RetrofitArrayAPI {
    @GET("/posts")
    Call<ArrayList<Example>> getUserDetails();

    @GET("/users")
    Call<ArrayList<Example1>> getUserDetails2();


}
