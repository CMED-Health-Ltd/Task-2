package com.example.task2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {




        @GET("api/characters")
        Call<List<Detail>> getDetail();




    }


