package com.remybarbosa.fdjcleanarchi.article;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.app.di.annotation.ActivityScoped;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * CleanJavaAndroidArchi
 *
 * Created by remybarbosa on 09/11/2017.
 */

@ActivityScoped
public class ArticleFragment extends DaggerFragment implements ArticleContract.View {

    @Inject
    ArticleContract.Presenter mPresenter;

    private TextView mArticleDetailView;

    @Inject
    public ArticleFragment() {
        // Needed empty constructor for dependency injection
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }


    private void bindViews(View fragmentView) {
        mArticleDetailView = fragmentView.findViewById(R.id.article_detail);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        bindViews(view);
       // mPresenter.showArticle();
    }

    @Override
    public void showArticle(ArticleViewModel articleViewModel) {

    }
}
