package com.week6.mvvmpart2.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.week6.mvvmpart2.retrofit.APIRequest;
import com.week6.mvvmpart2.model.APIResponse;
import com.week6.mvvmpart2.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRespository {
    private APIRequest apiRequest;

    public ArticleRespository()
    {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(APIRequest.class);
    }

    public LiveData<APIResponse> getMovieArticles(String query, String apiKey)
    {
        final MutableLiveData<APIResponse> data = new MutableLiveData<>();
        apiRequest.getMovieArticles(query, apiKey).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                if(response.body() != null)
                {
                    data.setValue(response.body());
                    Log.i("Data", response.body().getTotalResults()+"");
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {

                data.setValue(null);
            }
        });
        return data;
    }
}
