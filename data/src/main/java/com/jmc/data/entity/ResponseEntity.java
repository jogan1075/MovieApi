package com.jmc.data.entity;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;


public class ResponseEntity{

//	@SerializedName("page")
//	private int page;
//
//	@SerializedName("total_pages")
//	private int totalPages;

	@SerializedName("results")
	public List<ResultsItem> results;

//	@SerializedName("total_results")
//	private int totalResults;

//	public void setPage(int page){
//		this.page = page;
//	}
//
//	public int getPage(){
//		return page;
//	}
//
//	public void setTotalPages(int totalPages){
//		this.totalPages = totalPages;
//	}
//
//	public int getTotalPages(){
//		return totalPages;
//	}
//
//	public void setResults(List<ResultsItem> results){
//		this.results = results;
//	}
//
//	public List<ResultsItem> getResults(){
//		return results;
//	}
//
//	public void setTotalResults(int totalResults){
//		this.totalResults = totalResults;
//	}
//
//	public int getTotalResults(){
//		return totalResults;
//	}
//
//	@Override
// 	public String toString(){
//		return
//			"ResponseEntity{" +
//			"page = '" + page + '\'' +
//			",total_pages = '" + totalPages + '\'' +
//			",results = '" + results + '\'' +
//			",total_results = '" + totalResults + '\'' +
//			"}";
//		}
}