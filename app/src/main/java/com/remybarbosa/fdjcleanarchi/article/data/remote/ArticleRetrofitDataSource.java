package com.remybarbosa.fdjcleanarchi.article.data.remote;


import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.RemoteRSSFeed;


import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

import static com.remybarbosa.fdjcleanarchi.article.data.remote.WSConstants.BASE_URL;

public interface ArticleRetrofitDataSource {

    @GET("article.rss")
    Single<RemoteRSSFeed> loadRSSFeed();

    class Creator {
        public static ArticleRetrofitDataSource newArticleRetrofitDataSource() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();;

            return retrofit.create(ArticleRetrofitDataSource.class);
        }
    }
}