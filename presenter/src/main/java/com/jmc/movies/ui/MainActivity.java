package com.jmc.movies.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jmc.movies.MovieApplication;
import com.jmc.movies.R;
import com.jmc.movies.contract.MovieContract;
import com.jmc.movies.di.DaggerMovieComponent;
import com.jmc.movies.di.MovieModule;
import com.jmc.movies.modelview.MovieModelView;
import com.jmc.movies.presenter.MoviePresenter;
import com.jmc.movies.ui.adapter.MovieAdapter;
import com.jmc.movies.utils.commons.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MovieContract.View, MovieAdapter.ListItemClickListener {
    private LottieAnimationView mProgressBar;

    @Inject
    MoviePresenter presenter;

    RecyclerView recyclerView;
    MovieAdapter adapter;
    ProgressDialog progressDialog;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onPrepareActivity() {
        super.onPrepareActivity();

        mProgressBar = findViewById(R.id.loading);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        progressDialog = new ProgressDialog(this);
        recyclerView = findViewById(R.id.recicler);
        setupRecyclerView();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.populated:
                    loadPopulate();
                    return true;
                case R.id.moreRated:
                    loadMoreRated();
                    return true;

            }

            return false;
        }
    };

    private void loadMoreRated() {
        showdialog();
        presenter.loadMoviesMoreRated();
    }

    private void loadPopulate() {
        showdialog();

        presenter.loadMoviesPopulated();
    }

    @Override
    protected void onPreparePresenter() {
        presenter.attachView(this);
        presenter.loadMoviesPopulated();
    }


    @Override
    protected void onInject() {
        DaggerMovieComponent.builder()
                .applicationComponent(MovieApplication.getApplicationComponent())
                .movieModule(new MovieModule())
                .build()
                .inject(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void setMoviePopulatedItems(List<MovieModelView> movieItems) {
        adapter = new MovieAdapter(movieItems, this);

        recyclerView.setAdapter(adapter);

        hidedialog();
    }

    @Override
    public void setMovieMoreRatedItems(List<MovieModelView> movieItems) {
        adapter = new MovieAdapter(movieItems, this);

        recyclerView.setAdapter(adapter);

        hidedialog();
    }

    private void setupRecyclerView() {

        mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this,"No hay conexion a internet",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListItemClick(MovieModelView clickedItem) {
        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("itemSelected", clickedItem);
        startActivity(intent);
    }


    public void showdialog() {
        progressDialog.setMessage(getString(R.string.Msg_Loading_Dialog));
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }


    public void hidedialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

}
