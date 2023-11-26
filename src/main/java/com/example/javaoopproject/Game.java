package com.example.javaoopproject;

public class Game extends Media implements Comparable<Media> {

	protected double weight;

	public Game(String title, int numCopy, String Code, double weight) {
		super(title, numCopy, Code);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString() + weight + "\n";
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
	protected void setArtist(String artist) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setSongs(String songs) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getRating() {
		// TODO Auto-generated method stub
		return null;
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
