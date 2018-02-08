package com.remybarbosa.fdjcleanarchi.use_case.article;


import com.remybarbosa.fdjcleanarchi.entity.Article;
import com.remybarbosa.fdjcleanarchi.use_case.article.source.ArticleDataSource;

import javax.inject.Inject;

import io.reactivex.Single;


/**
 * CleanJavaAndroidArchi
 *
 * Created by remybarbosa on 10/11/2017.
 */

public class GetArticleUseCase {

    private final ArticleDataSource mArticleDataSource;

    @Inject
    public GetArticleUseCase(ArticleDataSource articleDataSource) {
        mArticleDataSource = articleDataSource;
    }

    public Single<Article> execute(String link) {
        return mArticleDataSource.getArticle(link);
    }
}
