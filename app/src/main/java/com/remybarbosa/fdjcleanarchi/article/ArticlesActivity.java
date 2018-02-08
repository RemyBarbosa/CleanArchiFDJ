package com.remybarbosa.fdjcleanarchi.article;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.remybarbosa.fdjcleanarchi.R;
import com.remybarbosa.fdjcleanarchi.util.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ArticlesActivity extends DaggerAppCompatActivity {

    @Inject
    ArticlesFragment injectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_articles);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArticlesFragment articlesFragment = (ArticlesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (articlesFragment == null) {
            articlesFragment = injectedFragment;
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    articlesFragment, R.id.contentFrame);
        }

    }
}
