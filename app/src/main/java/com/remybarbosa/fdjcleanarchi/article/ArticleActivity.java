package com.remybarbosa.fdjcleanarchi.article;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.util.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ArticleActivity extends DaggerAppCompatActivity {

    public static final String EXTRA_ARTICLE_LINK = "EXTRA_ARTICLE_LINK";

    @Inject
    ArticleFragment injectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_article);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (articleFragment == null) {
            articleFragment = injectedFragment;
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    articleFragment, R.id.contentFrame);
        }

    }

    public static Intent intent(final Context context, String link) {
        final Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra(EXTRA_ARTICLE_LINK, link);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    public static void start(final Context context, String link) {
       context.startActivity(intent(context, link));
    }
}
