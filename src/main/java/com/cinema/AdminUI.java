package com.cinema;

public class AdminUI {
	private static AdminUI instance = new AdminUI();
	private String bttnAddNewFilm;
    private String bookingLink;
	 private AdminUI(){}
	 //Get the only object available
	 public static AdminUI getInstance(){
	 return instance;
	 }
	 public String getBttnAddNewFilm()
	    {
	        return bttnAddNewFilm;
	    }
	    public void setBttnAddNewFilm(String bttn)
	    {
	        this.bttnAddNewFilm = bttn;
	    }
	    public String getBookingLink()
	    {
	        return bookingLink;
	    }
	    public void setBookingLink(String bttn)
	    {
	        this.bookingLink = bttn;
	    }
}
