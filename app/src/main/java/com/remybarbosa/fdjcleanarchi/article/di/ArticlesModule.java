package com.remybarbosa.fdjcleanarchi.article.di;


import com.remybarbosa.fdjcleanarchi.app.di.annotation.ActivityScoped;
import com.remybarbosa.fdjcleanarchi.app.di.annotation.FragmentScoped;
import com.remybarbosa.fdjcleanarchi.article.ArticleActivity;
import com.remybarbosa.fdjcleanarchi.article.ArticleFragment;
import com.remybarbosa.fdjcleanarchi.article.ArticlesFragment;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlePresenter;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlesContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticlesPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ArticlesModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ArticlesFragment articlesFragment();

    @ActivityScoped
    @Binds
    abstract ArticlesContract.Presenter articlesPresenter(ArticlesPresenter presenter);
}
