package com.cinema;

public class BollywoodMovies implements Movies{
	private static final long serialVersionUID = -1280037900360314186L;
	private String title,description,startingDate,endingDate,time;
	String type="Bollywood";
	public void addMovie(String title, String description, String startingDate, String endingDate, String time) {
	this.title=title;
	this.description=description;
	this.startingDate=startingDate;
	this.endingDate=endingDate;
	this.time=time;
	}
	 public String getTitle()
	    {
	        return title;
	    }
	    public void setTitle(String title)
	    {
	        this.title = title;
	    }
	    public String getDescription()
	    {
	        return description;
	    }
	    public void setDescription(String description)
	    {
	        this.description = description;
	    }
	    public void setStartingDate(String startingDate)
	    {
	        this.startingDate = startingDate;
	    }
	    public String getStartingDate()
	    {
	        return startingDate;
	    }
	    public void setEndingDate(String endingDate)
	    {
	        this.endingDate = endingDate;
	    }
	    public String getEndingDate()
	    {
	        return endingDate;
	    }
	    public void setTime(String time)
	    {
	        this.time = time;
	    }
	    public String getTime()
	    {
	        return time;
	    }
}
