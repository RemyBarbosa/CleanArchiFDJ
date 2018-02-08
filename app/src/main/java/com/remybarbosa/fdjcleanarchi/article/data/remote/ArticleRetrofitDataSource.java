package com.remybarbosa.fdjcleanarchi.article.data.remote;


import com.remybarbosa.fdjcleanarchi.interface_adapter.article.model.RemoteRSSFeed;


import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

import static com.remybarbosa.fdjcleanarchi.article.data.remote.WSConstants.BASE_URL;

public interface ArticleRetrofitDataSource {

    @GET("rss/une.xml")
    Single<RemoteRSSFeed> loadRSSFeed();

    class Creator {
        public static ArticleRetrofitDataSource newArticleRetrofitDataSource() {
            Strategy strategy = new AnnotationStrategy();
            Serializer serializer = new Persister(strategy);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit.create(ArticleRetrofitDataSource.class);
        }
    }
}