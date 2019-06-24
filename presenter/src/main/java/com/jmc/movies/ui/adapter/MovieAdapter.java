package com.jmc.movies.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jmc.movies.R;
import com.jmc.movies.modelview.MovieModelView;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    public static final String URL_POSTER = "http://image.tmdb.org/t/p/w500";
    private List<MovieModelView> movieModelViews;

    final private ListItemClickListener mOnClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView mTextView;
        public AppCompatImageView mPosterView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.titleView);
            mPosterView = v.findViewById(R.id.posterView);
        }
    }

    public MovieAdapter(List<MovieModelView> movieModelViews, ListItemClickListener listener) {
        this.movieModelViews = movieModelViews;
        this.mOnClickListener = listener;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextView.setText(movieModelViews.get(position).title);
        Glide.with(holder.mPosterView.getContext())
                .load(URL_POSTER + movieModelViews.get(position).posterPath)
                .into(holder.mPosterView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mOnClickListener.onListItemClick(movieModelViews.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return movieModelViews.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(MovieModelView clickedItem);
    }
}
