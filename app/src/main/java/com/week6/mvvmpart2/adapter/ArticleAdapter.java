package com.week6.mvvmpart2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.week6.mvvmpart2.R;
import com.week6.mvvmpart2.model.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private Context context;
    List<Article> articles;

    public ArticleAdapter(Context context, List<Article> articles)
    {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_article,parent, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {

        Article article = articles.get(position);

        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        holder.tvAuthorAndPublishedDate.setText(article.getAuthor()+"| Published At: "+article.getPublishedAt());

        Glide.with(context).load(article.getUrlToImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvAuthorAndPublishedDate;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgViewCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthorAndPublishedDate = itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
