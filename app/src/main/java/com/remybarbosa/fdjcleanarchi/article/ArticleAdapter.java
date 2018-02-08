package com.remybarbosa.fdjcleanarchi.article;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final ArrayList<ArticleViewModel> mArticleViewModels;

    private Listener mListener;

    public ArticleAdapter(List<ArticleViewModel> articleViewModels) {
        super();
        mArticleViewModels = new ArrayList<>();
        mArticleViewModels.addAll(articleViewModels);
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_item, viewGroup, false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        final ArticleViewModel articleViewModel = mArticleViewModels.get(position);
        holder.mTitle.setText(articleViewModel.getTitle());
        holder.mDate.setText(articleViewModel.getPubDate());
        holder.mView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onArticleClick(articleViewModel.getLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticleViewModels.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView mTitle;
        TextView mDate;

        public ArticleViewHolder(View view) {
            super(view);
            mView = view;
            mTitle = view.findViewById(R.id.title);
            mDate = view.findViewById(R.id.date);
        }
    }

    public interface Listener {
        void onArticleClick(String link);
    }

}

