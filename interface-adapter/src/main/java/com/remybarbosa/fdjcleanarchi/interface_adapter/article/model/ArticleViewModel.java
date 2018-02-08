package com.remybarbosa.fdjcleanarchi.interface_adapter.article.model;

import org.joda.time.DateTime;

/**
 * Created by remybarbosa on 08/02/2018.
 */

public class ArticleViewModel {

    private final String title;
    private final String description;
    private final String link;
    private final String pubDate;

    public ArticleViewModel(String title, String description, String link, String pubDate) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }
}