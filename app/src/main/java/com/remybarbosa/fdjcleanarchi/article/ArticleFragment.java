package com.remybarbosa.fdjcleanarchi.article;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.app.di.annotation.ActivityScoped;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * CleanJavaAndroidArchi
 * <p>
 * Created by remybarbosa on 09/11/2017.
 */

@ActivityScoped
public class ArticleFragment extends DaggerFragment implements ArticleContract.View {

    @Inject
    ArticleContract.Presenter mPresenter;

    @Inject
    String articleLink;

    private TextView mArticleTitleView;
    private TextView mArticleDescriptionView;
    private TextView mArticleDateView;
    private Button mArticleLinkButton;

    @Inject
    public ArticleFragment() {
        // Needed empty constructor for dependency injection
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }


    private void bindViews(View fragmentView) {
        mArticleTitleView = fragmentView.findViewById(R.id.article_title);
        mArticleDescriptionView = fragmentView.findViewById(R.id.article_description);
        mArticleDateView = fragmentView.findViewById(R.id.article_date);
        mArticleLinkButton = fragmentView.findViewById(R.id.article_link);
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
        mPresenter.initView(articleLink);
    }

    @Override
    public void showArticle(ArticleViewModel articleViewModel) {
        mArticleTitleView.setText(articleViewModel.getTitle());
        mArticleDescriptionView.setText(articleViewModel.getDescription());
        mArticleDateView.setText(articleViewModel.getPubDate());
        mArticleLinkButton.setText(articleViewModel.getLink());

        mArticleLinkButton.setOnClickListener(v -> WebArticleActivity.start(getContext(), articleViewModel.getLink()));
    }
}
