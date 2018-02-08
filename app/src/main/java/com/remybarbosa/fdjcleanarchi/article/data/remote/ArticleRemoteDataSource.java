package com.remybarbosa.fdjcleanarchi.article.data.remote;

import com.remybarbosa.fdjcleanarchi.entity.Article;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.ArticleMapperContract;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.RemoteRSSFeed;
import com.remybarbosa.fdjcleanarchi.use_case.article.source.ArticleDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * CleanJavaAndroidArchi
 *
 * Created by remybarbosa on 11/11/2017.
 */
public class ArticleRemoteDataSource implements ArticleDataSource {

    private final ArticleRetrofitDataSource mArticleRetrofitDataSource;
    private final ArticleMapperContract mMapper;

    @Inject
    public ArticleRemoteDataSource(ArticleMapperContract mapper) {
        mArticleRetrofitDataSource = ArticleRetrofitDataSource.Creator.newArticleRetrofitDataSource();
        mMapper = mapper;
    }

    @Override
    public Single<Article> getArticle(String link) {
        return mArticleRetrofitDataSource.loadRSSFeed()
                .map(RemoteRSSFeed::getArticleList)
                .flattenAsObservable(remoteArticles -> remoteArticles)
                .filter(remoteArticle -> remoteArticle.getLink().equals(link))
                .map(mMapper::remoteToEntity)
                .firstOrError();
    }

    @Override
    public Single<List<Article>> getArticles() {
        return mArticleRetrofitDataSource.loadRSSFeed()
                .map(RemoteRSSFeed::getArticleList)
                .flattenAsObservable(remoteArticles -> remoteArticles)
                .map(mMapper::remoteToEntity)
                .toList();
    }
}
