package com.remybarbosa.fdjcleanarchi.interface_adapter.article.model;

import org.joda.time.DateTime;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(name = "item", strict = false)
public class RemoteArticle {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "pubDate")
    private DateTime pubDate;

    @Element(name = "description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public DateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(DateTime pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}