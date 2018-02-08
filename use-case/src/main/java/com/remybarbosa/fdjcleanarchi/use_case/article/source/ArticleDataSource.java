package com.remybarbosa.fdjcleanarchi.use_case.article.source;

import com.remybarbosa.fdjcleanarchi.entity.Article;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * CleanJavaAndroidArchi
 *
 * Created by remybarbosa on 10/11/2017.
 */

public interface ArticleDataSource {
    Single<Article> getArticle(String link);
    Single<List<Article>> getArticles();
}
