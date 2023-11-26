package com.example.javaoopproject;

public class Album extends Media implements Comparable<Media> {
	protected String artist;
	protected String songs;

	public Album(String title, int numCopy, String Code, String artist, String songs) {
		super(title, numCopy, Code);
		this.artist = artist;
		this.songs = songs;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return super.toString() + "" + artist + "," + songs + "\n";
	}

	@Override
	public int compareTo(Media o) {

		return getTitle().compareTo(o.getTitle());

	}

	@Override
	protected void setRating(String rating) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setWeight(double weight) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
