package com.example.javaoopproject;

import java.util.*;

public interface MediaRentalInt {

	// Customer
	public void addCustomer(String name, String address, String plan, String ID, String mobileNumber);// done

	public void DeleteCustomer(String ID);// done

	public void UpdateCustomer(String name, String address, String plan, String ID, String mobileNumber); // done

	public void SearchCustomer(String ID); // done

	public Custmor findcustomer(String ID);

	public boolean CheckId(String ID);

	public boolean check(ArrayList<Custmor> customer, String ID);

	public void readCustomerdata(ArrayList<Custmor> customer);

	public void saveCustomerdate();

	// Media
	public void DeleteMovie(String Code); // done

	public void DeleteGame(String Code); // done

	public void DeleteAlbum(String Code); // done

	public void UpdateteMovie(String title, int numCopy, String Code, String rating);// done

	public void UpdateGame(String title, int numCopy, String Code, double weight);// done

	public void UpdateAlbum(String title, int numCopy, String Code, String artist, String songs);// done

	public void addMovie(String title, int numCopy, String Code, String rating); // done

	public void addGame(String title, int numCopy, String Code, double weight); // done

	public void addAlbum(String title, int numCopy, String Code, String artist, String songs); // done

	public String SearchMedia(String ID); // done

	public String getAllMediaInfo(); // done

	public Media findMedia(String Code); // done

	public String MediaInfo(String Code);

	public boolean CheackMedia(String Code);

	// Rent
	public boolean addToCart(String ID, String Code);

	public String processRequests();

	public boolean returnMedia(String ID, String Code);

	public ArrayList<String> searchMedia(String Code);

	public String Rented(String ID);

	public String getIntrsted(String ID);

	public void setLimitedPlanLimit(int value);

	public String getAllCustomersInfo();

	public boolean removeFromCart(String customerName, String mediaTitle);

	public void print();
}
