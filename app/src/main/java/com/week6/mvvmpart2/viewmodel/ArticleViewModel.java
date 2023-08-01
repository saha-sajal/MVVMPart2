package com.week6.mvvmpart2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.week6.mvvmpart2.model.APIResponse;
import com.week6.mvvmpart2.repository.ArticleRespository;

public class ArticleViewModel extends AndroidViewModel{

    private ArticleRespository articleRespository;
    private LiveData<APIResponse> apiResponseLiveData;
    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRespository = new ArticleRespository();
        this.apiResponseLiveData = articleRespository.getMovieArticles("movie", "d34241d258e9493bb7aeac945ce3ea04");
    }

    public LiveData<APIResponse> getApiResponseLiveData()
    {
        return apiResponseLiveData;
    }
}
