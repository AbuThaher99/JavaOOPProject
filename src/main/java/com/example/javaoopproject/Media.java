package com.example.javaoopproject;

public abstract class Media implements Comparable<Media> {
	protected String title;
	protected int numCopy;
	protected String Code;

	public Media(String title, int numCopy, String Code) {
		super();
		this.title = title;
		this.numCopy = numCopy;
		this.Code = Code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumCopy() {
		return numCopy;
	}

	public void setNumCopy(int numCopy) {
		this.numCopy = numCopy;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	@Override
	public String toString() {
		return "" + title + "," + numCopy + "," + Code + ",";
	}

//	@Override
//	public int compareTo(Media o) {
//
//		return getTitle().compareTo(o.getTitle());
//	}

	public void copies(boolean add) {

		if (add == true) {
			numCopy--;
		} else {
			numCopy++;
		}

	}

	protected abstract void setRating(String rating);

	protected abstract void setWeight(double weight);

	protected abstract void setArtist(String artist);

	protected abstract void setSongs(String songs);

	protected abstract String getRating();

	protected abstract double getWeight();

	protected abstract String getArtist();

	protected abstract String getSongs();

}
