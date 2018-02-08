package com.remybarbosa.fdjcleanarchi.use_case.article;


import com.remybarbosa.fdjcleanarchi.entity.Article;
import com.remybarbosa.fdjcleanarchi.use_case.article.source.ArticleDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


/**
 * CleanJavaAndroidArchi
 *
 * Created by remybarbosa on 10/11/2017.
 */

public class GetArticlesUseCase {

    private final ArticleDataSource mArticleDataSource;

    @Inject
    public GetArticlesUseCase(ArticleDataSource articleDataSource) {
        mArticleDataSource = articleDataSource;
    }

    public Single<List<Article>> execute() {
        return mArticleDataSource.getArticles();
    }
}
