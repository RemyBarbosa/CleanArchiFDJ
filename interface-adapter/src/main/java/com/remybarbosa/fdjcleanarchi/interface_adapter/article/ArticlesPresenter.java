package com.remybarbosa.fdjcleanarchi.interface_adapter.article;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ArticlesPresenter implements ArticlesContract.Presenter {

    private static final String TAG = ArticlesPresenter.class.getSimpleName();

    private CompositeDisposable disposables;

    private ArticlesContract.View mView;

    private final ArticleManager mArticleManager;

    @Inject
    public ArticlesPresenter(ArticleManager articleManager) {
        mArticleManager = articleManager;
        disposables = new CompositeDisposable();
    }

    @Override
    public void initView() {
        disposables.add(mArticleManager.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        articlesViewModel -> mView.showArticles(articlesViewModel),
                        e -> Log.e(TAG, "showArticle: ", e)
                ));
    }

    @Override
    public void takeView(ArticlesContract.View view) {
        mView = view;
    }

    @Override
    public void destroy() {
        disposables.clear();
        mView = null;
    }

}
