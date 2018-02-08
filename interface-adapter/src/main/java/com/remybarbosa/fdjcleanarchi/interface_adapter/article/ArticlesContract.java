package com.remybarbosa.fdjcleanarchi.interface_adapter.article;

import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.ArticleViewModel;
import com.remybarbosa.fdjcleanarchi.interface_adapter.base.BasePresenter;

import java.util.List;

public interface ArticlesContract {

    interface View {
        void showArticles(List<ArticleViewModel> articleViewModels);
    }

    interface Presenter extends BasePresenter<View> {

        void initView();

        void takeView(View view);

        void destroy();

    }
}
