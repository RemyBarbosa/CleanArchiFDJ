package com.remybarbosa.fdjcleanarchi.interface_adapter.article.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="rss", strict=false)
public class RemoteRSSFeed {

    @Element(name="title")
    @Path("channel")
    private String channelTitle;

    @ElementList(name="item", inline=true)
    @Path("channel")
    private List<RemoteArticle> articleList;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public List<RemoteArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<RemoteArticle> articleList) {
        this.articleList = articleList;
    }

}