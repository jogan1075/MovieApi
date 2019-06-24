package com.jmc.data.entity;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;


public class ResultsItem{

	@SerializedName("overview")
	public String overview;

	@SerializedName("original_language")
	public String originalLanguage;

	@SerializedName("original_title")
	public String originalTitle;

	@SerializedName("video")
	public boolean video;

	@SerializedName("title")
	public String title;

	@SerializedName("genre_ids")
	public List<Integer> genreIds;

	@SerializedName("poster_path")
	public String posterPath;

	@SerializedName("backdrop_path")
	public String backdropPath;

	@SerializedName("release_date")
	public String releaseDate;

	@SerializedName("vote_average")
	public double voteAverage;

	@SerializedName("popularity")
	public double popularity;

	@SerializedName("id")
	public int id;

	@SerializedName("adult")
	public boolean adult;

	@SerializedName("vote_count")
	public int voteCount;
//
//	public void setOverview(String overview){
//		this.overview = overview;
//	}
//
//	public String getOverview(){
//		return overview;
//	}
//
//	public void setOriginalLanguage(String originalLanguage){
//		this.originalLanguage = originalLanguage;
//	}
//
//	public String getOriginalLanguage(){
//		return originalLanguage;
//	}
//
//	public void setOriginalTitle(String originalTitle){
//		this.originalTitle = originalTitle;
//	}
//
//	public String getOriginalTitle(){
//		return originalTitle;
//	}
//
//	public void setVideo(boolean video){
//		this.video = video;
//	}
//
//	public boolean isVideo(){
//		return video;
//	}
//
//	public void setTitle(String title){
//		this.title = title;
//	}
//
//	public String getTitle(){
//		return title;
//	}
//
//	public void setGenreIds(List<Integer> genreIds){
//		this.genreIds = genreIds;
//	}
//
//	public List<Integer> getGenreIds(){
//		return genreIds;
//	}
//
//	public void setPosterPath(String posterPath){
//		this.posterPath = posterPath;
//	}
//
//	public String getPosterPath(){
//		return posterPath;
//	}
//
//	public void setBackdropPath(String backdropPath){
//		this.backdropPath = backdropPath;
//	}
//
//	public String getBackdropPath(){
//		return backdropPath;
//	}
//
//	public void setReleaseDate(String releaseDate){
//		this.releaseDate = releaseDate;
//	}
//
//	public String getReleaseDate(){
//		return releaseDate;
//	}
//
//	public void setVoteAverage(double voteAverage){
//		this.voteAverage = voteAverage;
//	}
//
//	public double getVoteAverage(){
//		return voteAverage;
//	}
//
//	public void setPopularity(double popularity){
//		this.popularity = popularity;
//	}
//
//	public double getPopularity(){
//		return popularity;
//	}
//
//	public void setId(int id){
//		this.id = id;
//	}
//
//	public int getId(){
//		return id;
//	}
//
//	public void setAdult(boolean adult){
//		this.adult = adult;
//	}
//
//	public boolean isAdult(){
//		return adult;
//	}
//
//	public void setVoteCount(int voteCount){
//		this.voteCount = voteCount;
//	}
//
//	public int getVoteCount(){
//		return voteCount;
//	}
//
//	@Override
// 	public String toString(){
//		return 
//			"ResultsItem{" + 
//			"overview = '" + overview + '\'' + 
//			",original_language = '" + originalLanguage + '\'' + 
//			",original_title = '" + originalTitle + '\'' + 
//			",video = '" + video + '\'' + 
//			",title = '" + title + '\'' + 
//			",genre_ids = '" + genreIds + '\'' + 
//			",poster_path = '" + posterPath + '\'' + 
//			",backdrop_path = '" + backdropPath + '\'' + 
//			",release_date = '" + releaseDate + '\'' + 
//			",vote_average = '" + voteAverage + '\'' + 
//			",popularity = '" + popularity + '\'' + 
//			",id = '" + id + '\'' + 
//			",adult = '" + adult + '\'' + 
//			",vote_count = '" + voteCount + '\'' + 
//			"}";
//		}
}