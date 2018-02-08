package com.remybarbosa.fdjcleanarchi.interface_adapter.article;

import com.remybarbosa.fdjcleanarchi.entity.Article;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.RemoteArticle;

import javax.inject.Inject;

public class ArticleMapper implements ArticleMapperContract {

    @Inject
    public ArticleMapper() {
    }

    @Override
    public ArticleViewModel entityToViewModel(Article article) {
        return new ArticleViewModel(article.getTitle(), article.getDescription(), article.getLink(), article.getPubDate().toString("EEEE, d MMM yyyy"));
    }

    @Override
    public Article remoteToEntity(RemoteArticle remoteArticle) {
        return new Article(remoteArticle.getTitle(), remoteArticle.getDescription(), remoteArticle.getLink(), remoteArticle.getPubDate());
    }
}
