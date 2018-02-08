package com.remybarbosa.fdjcleanarchi.article.di;

import com.remybarbosa.fdjcleanarchi.article.data.remote.ArticleRemoteDataSource;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleMapper;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleMapperContract;
import com.remybarbosa.fdjcleanarchi.use_case.article.source.ArticleDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class ArticleModulePresenter {

    @Provides
    ArticleDataSource provideArticleRemoteDataSource(ArticleRemoteDataSource articleRemoteDataSource) {
        return articleRemoteDataSource;
    }

    @Provides
    ArticleMapperContract provideArticleMapper(ArticleMapper articleMapper) {
        return articleMapper;
    }
}
