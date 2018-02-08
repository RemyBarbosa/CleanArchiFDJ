package com.remybarbosa.fdjcleanarchi.article;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.app.di.annotation.ActivityScoped;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlesContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * CleanJavaAndroidArchi
 *
 * Created by remybarbosa on 09/11/2017.
 */

@ActivityScoped
public class ArticlesFragment extends DaggerFragment implements ArticlesContract.View {

    @Inject
    ArticlesContract.Presenter mPresenter;

    private RecyclerView mArticlesRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    public ArticlesFragment() {
        // Needed empty constructor for dependency injection
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }


    private void bindViews(View fragmentView) {
        mArticlesRecyclerView = fragmentView.findViewById(R.id.articles);
        mSwipeRefreshLayout = fragmentView.findViewById(R.id.swipe_refresh_layout);
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
        mPresenter.initView();
    }

    @Override
    public void showArticles(List<ArticleViewModel> articleViewModels) {
        ArticleAdapter articleAdapter = new ArticleAdapter(articleViewModels);
        articleAdapter.setListener(link -> ArticleActivity.start(getContext(), link));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mArticlesRecyclerView.setLayoutManager(layoutManager);
        mArticlesRecyclerView.setAdapter(articleAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mSwipeRefreshLayout.getContext(),
                layoutManager.getOrientation());
        mArticlesRecyclerView.addItemDecoration(dividerItemDecoration);

        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.initView());
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
