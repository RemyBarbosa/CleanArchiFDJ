package com.remybarbosa.fdjcleanarchi.entity;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by remybarbosa on 08/02/2018.
 */

public class Article {

    private final String title;
    private final String description;
    private final String link;
    private final DateTime pubDate;

    public Article(String title, String description, String link, DateTime pubDate) {
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

    public DateTime getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }
}