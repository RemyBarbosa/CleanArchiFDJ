package com.remybarbosa.fdjcleanarchi.article;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.util.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static com.remybarbosa.fdjcleanarchi.article.ArticleActivity.EXTRA_ARTICLE_LINK;

public class WebArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_article);

        WebView webView = findViewById(R.id.article_webview);
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings set = webView.getSettings();
        set.setJavaScriptEnabled(true);
        webView.loadUrl(getIntent().getStringExtra(ArticleActivity.EXTRA_ARTICLE_LINK));
    }

    public static Intent intent(final Context context, String link) {
        final Intent intent = new Intent(context, WebArticleActivity.class);
        intent.putExtra(EXTRA_ARTICLE_LINK, link);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    public static void start(final Context context, String link) {
        context.startActivity(intent(context, link));
    }
}
