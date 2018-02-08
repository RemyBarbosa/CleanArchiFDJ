package com.remybarbosa.fdjcleanarchi.app.di;

import com.remybarbosa.fdjcleanarchi.app.di.annotation.ActivityScoped;
import com.remybarbosa.fdjcleanarchi.article.ArticleActivity;
import com.remybarbosa.fdjcleanarchi.article.ArticlesActivity;
import com.remybarbosa.fdjcleanarchi.article.di.ArticleModule;
import com.remybarbosa.fdjcleanarchi.article.di.ArticlesModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = ArticleModule.class)
    abstract ArticleActivity articleActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ArticlesModule.class)
    abstract ArticlesActivity articlesActivity();
}
