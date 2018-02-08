package com.remybarbosa.fdjcleanarchi.interface_adapter.article;

import com.remybarbosa.fdjcleanarchi.entity.Article;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.RemoteArticle;

public interface ArticleMapperContract {
    Article remoteToEntity(RemoteArticle remoteArticle);
    ArticleViewModel entityToViewModel(Article article);
}