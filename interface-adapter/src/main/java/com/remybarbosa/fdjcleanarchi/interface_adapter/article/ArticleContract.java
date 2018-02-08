package com.remybarbosa.fdjcleanarchi.interface_adapter.article;

import com.remybarbosa.fdjcleanarchi.entity.Article;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;
import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.RemoteArticle;
import com.remybarbosa.fdjcleanarchi.interface_adapter.base.BasePresenter;

public interface ArticleContract {

    interface View {
        void showArticle(ArticleViewModel articleViewModel);
    }

    interface Presenter extends BasePresenter<View> {

        void initView(String link);

        void takeView(View view);

        void destroy();

    }
}
