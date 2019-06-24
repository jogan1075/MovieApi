package com.jmc.movies.modelview;



import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MovieModelView implements Parcelable {


    public String overview;

    public String originalLanguage;


    public String originalTitle;


    public boolean video;


    public String title;


    public List<Integer> genreIds;


    public String posterPath;


    public String backdropPath;


    public String releaseDate;


    public double voteAverage;


    public double popularity;


    public int id;


    public boolean adult;


    public int voteCount;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalTitle);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeString(this.title);
        dest.writeList(this.genreIds);
        dest.writeString(this.posterPath);
        dest.writeString(this.backdropPath);
        dest.writeString(this.releaseDate);
        dest.writeDouble(this.voteAverage);
        dest.writeDouble(this.popularity);
        dest.writeInt(this.id);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeInt(this.voteCount);
    }

    public MovieModelView() {
    }

    protected MovieModelView(Parcel in) {
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.originalTitle = in.readString();
        this.video = in.readByte() != 0;
        this.title = in.readString();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
        this.releaseDate = in.readString();
        this.voteAverage = in.readDouble();
        this.popularity = in.readDouble();
        this.id = in.readInt();
        this.adult = in.readByte() != 0;
        this.voteCount = in.readInt();
    }

    public static final Parcelable.Creator<MovieModelView> CREATOR = new Parcelable.Creator<MovieModelView>() {
        @Override
        public MovieModelView createFromParcel(Parcel source) {
            return new MovieModelView(source);
        }

        @Override
        public MovieModelView[] newArray(int size) {
            return new MovieModelView[size];
        }
    };
}
