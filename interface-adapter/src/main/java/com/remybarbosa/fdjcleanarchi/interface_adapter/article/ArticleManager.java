package com.remybarbosa.fdjcleanarchi.interface_adapter.article;

import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;
import com.remybarbosa.fdjcleanarchi.use_case.article.GetArticleUseCase;
import com.remybarbosa.fdjcleanarchi.use_case.article.GetArticlesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


public class ArticleManager {

    private final GetArticleUseCase mGetArticleUseCase;
    private final GetArticlesUseCase mGetArticlesUseCase;

    private final ArticleMapperContract mMapper;

    @Inject
    ArticleManager(GetArticleUseCase getArticleUseCase, GetArticlesUseCase getArticlesUseCase, ArticleMapperContract mapper) {
        mGetArticleUseCase = getArticleUseCase;
        mGetArticlesUseCase = getArticlesUseCase;
        mMapper = mapper;
    }

    public Single<ArticleViewModel> getArticle(String link) {
        return mGetArticleUseCase.execute(link)
                .map(mMapper::entityToViewModel);
    }

    public Single<List<ArticleViewModel>> getArticles() {
        return mGetArticlesUseCase.execute()
                .flattenAsObservable(articles -> articles)
                .map(mMapper::entityToViewModel)
                .toList();
    }
}
