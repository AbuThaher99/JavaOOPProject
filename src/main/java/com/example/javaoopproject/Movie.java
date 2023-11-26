package com.example.javaoopproject;

public class Movie extends Media implements Comparable<Media> {
	public String rating;

	public Movie(String title, int numCopy, String Code, String rating) {
		super(title, numCopy, Code);
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return super.toString() + "" + rating + "\n";
	}

	@Override
	public int compareTo(Media o) {

		return getTitle().compareTo(o.getTitle());
	}

	@Override
	protected void setWeight(double weight) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setArtist(String artist) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setSongs(String songs) {
		// TODO Auto-generated method stub

	}

	@Override
	protected double getWeight() {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	protected String getArtist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSongs() {
		// TODO Auto-generated method stub
		return null;
	}

}
