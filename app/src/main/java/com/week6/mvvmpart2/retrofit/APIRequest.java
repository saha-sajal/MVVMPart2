package com.week6.mvvmpart2.retrofit;

import com.week6.mvvmpart2.model.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequest {

    @GET("v2/everything")
    Call<APIResponse> getMovieArticles(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );

}
