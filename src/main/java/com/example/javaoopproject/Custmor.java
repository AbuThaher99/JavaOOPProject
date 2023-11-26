package com.example.javaoopproject;

import java.util.*;

public class Custmor implements Comparable<Custmor> {
	protected String name;
	protected String address;
	protected String plan;
	protected String ID;
	protected String mobileNimber;
	protected int limited = 2;

	protected ArrayList<String> interested = new ArrayList<String>();
	protected ArrayList<String> rented = new ArrayList<String>();

	public Custmor(String name, String address, String plan, String ID, String mobileNumber) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.ID = ID;
		this.mobileNimber = mobileNumber;

	}

	public int getLimited() {
		return limited;
	}

	public void setLimited(int limited) {
		this.limited = limited;
	}

	public ArrayList<String> getInterested() {
		return interested;
	}

	public void setInterested(ArrayList<String> interested) {
		this.interested = interested;
	}

	public ArrayList<String> getRented() {
		return rented;
	}

	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMobileNimber() {
		return mobileNimber;
	}

	public void setMobileNimber(String mobileNimber) {
		this.mobileNimber = mobileNimber;
	}

	@Override
	public int compareTo(Custmor o) {

		return getName().compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "" + name + "," + address + "," + plan + "," + ID + "," + mobileNimber + "\n";
	}
}
