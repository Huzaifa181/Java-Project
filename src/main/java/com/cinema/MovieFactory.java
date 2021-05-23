package com.cinema;

public class MovieFactory {
	public Movies storeMovie(String movieType){
		 if(movieType == null){
		 return null; }
		 if(movieType.equalsIgnoreCase("Bollywood")){
		 return new BollywoodMovies();
		 } else if(movieType.equalsIgnoreCase("Hollywood")){
		 return new HollywoodMovies();
		 }
		 return null; }
}
