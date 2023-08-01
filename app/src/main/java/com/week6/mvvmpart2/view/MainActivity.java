package com.week6.mvvmpart2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.week6.mvvmpart2.R;
import com.week6.mvvmpart2.adapter.ArticleAdapter;
import com.week6.mvvmpart2.model.Article;
import com.week6.mvvmpart2.viewmodel.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArticleViewModel articleViewModel;
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        recyclerView = findViewById(R.id.article_recycle_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        articleAdapter = new ArticleAdapter(MainActivity.this, articleList);
        recyclerView.setAdapter(articleAdapter);


        articleViewModel.getApiResponseLiveData().observe(this, apiResponse -> {
            if(apiResponse != null)
            {
                List<Article> articles = apiResponse.getArticles();
                articleList.addAll(articles);
                articleAdapter.notifyDataSetChanged();
            }
        });


    }
}