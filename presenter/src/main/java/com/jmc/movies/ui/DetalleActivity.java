package com.jmc.movies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jmc.movies.R;
import com.jmc.movies.modelview.MovieModelView;
import com.jmc.movies.utils.commons.BaseActivity;

import static com.jmc.movies.ui.adapter.MovieAdapter.URL_POSTER;

public class DetalleActivity extends BaseActivity {

    private MovieModelView movie;
    private String mTitle, mYear, mSinopsis;
    private double mVoteAverage;
    private TextView tvTitleMovie, tvYearMovie, tvVoteMovie, tvSinopsisMovie;


    ImageView ivPosterMovie;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detalle;
    }

    @Override
    protected void onPrepareActivity() {
        super.onPrepareActivity();

        Intent intent = getIntent();
        movie = intent.getExtras().getParcelable("itemSelected");

        ivPosterMovie = findViewById(R.id.iv_poster_movie);

        tvYearMovie = findViewById(R.id.tv_year_movie);

        tvVoteMovie = findViewById(R.id.tv_vote_movie);

        tvSinopsisMovie = findViewById(R.id.tv_sinopsis_movie);

        tvTitleMovie = findViewById(R.id.tv_title_movie);


        setupScreen();

    }


    public void setupScreen() {


        mTitle = movie.title;
        mYear = movie.releaseDate;
        mVoteAverage = movie.voteAverage;
        mSinopsis = movie.overview;


        tvTitleMovie.setText(mTitle);
        String[] justYear = mYear.split("-");
        tvYearMovie.setText("Año  " + justYear[0]);
        tvVoteMovie.setText(String.valueOf(mVoteAverage) + " / 10");
        tvSinopsisMovie.setText(mSinopsis);

        Glide.with(this)
                .load(URL_POSTER + movie.posterPath)
                .into(ivPosterMovie);

    }
}
