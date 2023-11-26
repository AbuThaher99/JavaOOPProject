package com.example.javaoopproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import javafx.scene.shape.Path;

public class MediaRentalManger implements MediaRentalInt {
	protected ArrayList<Custmor> customer = new ArrayList<>();
	protected ArrayList<Media> media = new ArrayList<>();

	protected int limited;

	public MediaRentalManger() {
	}

	public MediaRentalManger(ArrayList<Custmor> customer, ArrayList<Media> media, int limited) {

		this.customer = customer;
		this.media = media;
		this.limited = 2;

	}

	public ArrayList<Custmor> getCustomer() {
		return customer;
	}

	public void setCustomer(ArrayList<Custmor> customer) {
		this.customer = customer;
	}
//
//	public ArrayList<Media> getMedia() {
//		return media;
//	}
//
//	public void setMedia(ArrayList<Media> media) {
//		this.media = media;
//	}

//	public int getLimited() {
//		return limited;
//	}
//
//	public void setLimited(int limited) {
//		this.limited = limited;
//	}

	@Override
	public void addCustomer(String name, String address, String plan, String ID, String mobileNumber) {
		customer.add(new Custmor(name, address, plan, ID, mobileNumber));
		System.out.println("Added Scsoflly");
		System.out.println("Name  : " + name);
		System.out.println("Address : " + address);
		System.out.println("Plan  : " + plan);
		System.out.println("ID : " + ID);
		System.out.println("Mobile Number : " + mobileNumber);

	}

	public void DeleteCustomer(String ID) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				customer.remove(i);
				System.out.println("reomve Scsoflly");
			}
		}
	}

	@Override
	public void UpdateCustomer(String name, String address, String plan, String ID, String mobileNumber) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				customer.get(i).setName(name);
				customer.get(i).setAddress(address);
				customer.get(i).setMobileNimber(mobileNumber);
				customer.get(i).setPlan(plan);
			}
		}

	}

	@Override
	public void SearchCustomer(String ID) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				customer.get(i).getName();
				customer.get(i).getAddress();
				customer.get(i).getMobileNimber();
				customer.get(i).getPlan();
			}
		}

	}

	@Override
	public void addMovie(String title, int numCopy, String Code, String rating) {

		media.add(new Movie(title, numCopy, Code, rating));
		System.out.println("aDDED");
		System.out.println("Tital : " + title);
		System.out.println("num copy : " + numCopy);
		System.out.println("Code : " + Code);
		System.out.println("rating : " + rating);
	}

	@Override
	public void addGame(String title, int numCopy, String Code, double weight) {

		media.add(new Game(title, numCopy, Code, weight));
		System.out.println("aDDED");
		System.out.println("Tital : " + title);
		System.out.println("num copy : " + numCopy);
		System.out.println("Code : " + Code);
		System.out.println("Weiht : " + weight);
	}

	@Override
	public void addAlbum(String title, int numCopy, String Code, String artist, String songs) {

		media.add(new Album(title, numCopy, Code, artist, songs));
		System.out.println("aDDED");
		System.out.println("Tital : " + title);
		System.out.println("num copy : " + numCopy);
		System.out.println("Code : " + Code);
		System.out.println("art : " + artist);
		System.out.println("songs :" + songs);

	}

	public void DeleteMovie(String Code) {

		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				media.remove(i);
			}
		}
	}

	@Override
	public void DeleteGame(String Code) {

		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				media.remove(i);
			}
		}
	}

	@Override
	public void DeleteAlbum(String Code) {

		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				media.remove(i);
			}
		}
	}

	@Override
	public void UpdateteMovie(String title, int numCopy, String Code, String rating) {
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				media.get(i).setNumCopy(numCopy);
				media.get(i).setTitle(title);
				media.get(i).setCode(Code);
				media.get(i).setRating(rating);
			}
		}

	}

	@Override
	public void UpdateGame(String title, int numCopy, String Code, double weight) {
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				media.get(i).setNumCopy(numCopy);
				media.get(i).setTitle(title);
				media.get(i).setCode(Code);
				media.get(i).setWeight(weight);
			}
		}

	}

	@Override
	public void UpdateAlbum(String title, int numCopy, String Code, String artist, String songs) {
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				media.get(i).setNumCopy(numCopy);
				media.get(i).setTitle(title);
				media.get(i).setCode(Code);
				media.get(i).setArtist(artist);
				media.get(i).setSongs(songs);
			}
		}

	}

	@Override
	public String SearchMedia(String Code) {
		String med = "";
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				med = media.get(i).toString();
				return med;

			}
		}

		return null;
	}

	@Override
	public String getAllMediaInfo() {
		Collections.sort(media);
		String all = "";
		for (int i = 0; i < media.size(); i++) {
			all += media.get(i).toString();
		}
		return all;
	}

	@Override
	public void setLimitedPlanLimit(int value) {

		this.limited = value;

	}

	@Override
	public String getAllCustomersInfo() {
		Collections.sort(customer);
		String customerInfo = "";
		for (int i = 0; i < customer.size(); i++) {
			customerInfo += customer.get(i).toString();
		}

		return customerInfo;
	}

	@Override
	public boolean addToCart(String ID, String Code) {

		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				for (int j = 0; j < customer.get(i).interested.size(); j++) {
					
					if (customer.get(i).interested.get(j).equals(Code)) {

						return false;
					}
	
				}
				customer.get(i).interested.add(Code);
				return true;
			}
		}
		
		
		return false;
	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getName().equals(customerName)) {
				customer.get(i).interested.remove(mediaTitle);
				return true;
			}
		}
		return false;
	}

	@Override
	public String processRequests() {

		String process = "";
		Collections.sort(customer);
		for (int i = 0; i < customer.size(); i++) {
			for (int k = 0; k < customer.get(i).getInterested().size(); k++) {
				if (customer.get(i).getPlan().equals("UNLIMITED") || customer.get(i).getRented().size() < 2) {
					for (int j = 0; j < media.size(); j++) {
						if (media.get(j).getCode().equals(customer.get(i).getInterested().get(k))) {
							if (media.get(j).getNumCopy() > 0 || customer.get(i).getRented().size() <= 2) {
								customer.get(i).getRented().add(customer.get(i).getInterested().get(k));
								media.get(j).copies(true);
								process = "Sending" + customer.get(i).getInterested().get(k) + "to"
										+ customer.get(i).getName();
								customer.get(i).getInterested().remove(k);
								k--;
								break;
							} else
								continue;
						}
					}
				} else
					break;
			}
		}

		return process;

	}

	public void print() {
		for (int i = 0; i < customer.size(); i++) {

			System.out.println(customer.get(i).interested);
			System.out.println(customer.get(i).rented);

		}
	}

	@Override
	public ArrayList<String> searchMedia(String Code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean returnMedia(String ID, String Code) {
		for (int i = 0; i < customer.size(); i++) {
			for (int j = 0; j < media.size(); j++) {
				for (int k = 0; k < customer.get(i).rented.size(); k++) {
					if (customer.get(i).getRented().get(k).equals(Code)) {
						customer.get(i).rented.remove(customer.get(i).rented.get(k));
						media.get(j).copies(false);
						return true;

					}
				}
			}
		}

		return false;
	}

	@Override
	public Custmor findcustomer(String ID) {

		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				return customer.get(i);
			}

		}
		return null;
	}

	@Override
	public Media findMedia(String Code) {
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				return media.get(i);
			}
		}
		return null;
	}

	@Override
	public String MediaInfo(String Code) {
		String m = "";
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				m = media.get(i).toString();
				return m;
			}
		}
		return null;
	}

	@Override
	public boolean CheckId(String ID) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean CheackMedia(String Code) {
		for (int i = 0; i < media.size(); i++) {
			if (media.get(i).getCode().equals(Code)) {
				return true;
			}
		}
		return false;
	}

//	private boolean getrented(String Code) {
//		for (int i = 0; i < customer.get(i).rented.size(); i++) {
//			if (customer.get(i).getRented().get(i).getCode().equals(Code)) {
//				return true;
//			}
//		}
//
//		return false;
//	}

	@Override
	public String Rented(String ID) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				return customer.get(i).rented.toString();
			}
		}
		return null;
	}

	@Override
	public String getIntrsted(String ID) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				return customer.get(i).interested.toString();
			}
		}
		return null;
	}

	public boolean check(ArrayList<Custmor> customer, String ID) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getID().equals(ID)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void saveCustomerdate() {
		File output = new File("Customer.txt");
		try {
			PrintWriter out = new PrintWriter(output);
			
			out.write(getAllCustomersInfo());

			out.close();
		} catch (FileNotFoundException mo) {
			System.out.println(mo);
		}

	}

	@Override
	public void readCustomerdata(ArrayList<Custmor> customer) {
		File file = new File("C:\\Users\\moham\\Desktop\\AbuThaherjava\\Example\\Customer.txt");
		Scanner sc;
		String[] output = new String[5];
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				output = sc.nextLine().split(",");
				customer.add(new Custmor(output[0], output[1], output[2], output[3], output[4]));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveGameData() {
		File output = new File("Game.txt");
		try {
			PrintWriter out = new PrintWriter(output);
//			for (int i = 0; i < media.size(); i++) {
//				if (media.get(i) instanceof Game) {
//					out.write(media.get(i).getTitle() + "," + media.get(i).getNumCopy() + "," + media.get(i).getCode()
//							+ "," + media.get(i).getWeight() + "\n");
//				}
//			}
			// out.write(getAllMediaInfo());
			out.close();
		} catch (FileNotFoundException mo) {
			System.out.println(mo);
		}
	}

	public void readGameData(ArrayList<Media> media) {
		File file = new File("C:\\Users\\moham\\Desktop\\AbuThaherjava\\Example\\Game.txt");
		Scanner sc;
		String[] output = new String[4];

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {

				output = sc.nextLine().split(",");
				String tital = output[0];
				int num = Integer.parseInt(output[1]);
				String code = output[2];
				double wight = Double.parseDouble(output[3]);

				media.add(new Game(tital, num, code, wight));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveMovieData() {
		File output = new File("Movie.txt");
		try {
			PrintWriter out = new PrintWriter(output);
			for (int i = 0; i < media.size(); i++) {
				if (media.get(i) instanceof Movie) {
					out.write(media.get(i).getTitle() + "," + media.get(i).getNumCopy() + "," + media.get(i).getCode()
							+ "," + media.get(i).getRating() + "\n");
				}
			}

			out.close();
		} catch (FileNotFoundException mo) {
			System.out.println(mo);
		}
	}

	public void readMovieData(ArrayList<Media> media) {
		File file = new File("C:\\Users\\moham\\Desktop\\AbuThaherjava\\Example\\Movie.txt");
		Scanner sc;
		String[] output = new String[5];

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {

				output = sc.nextLine().split(",");
				String tital = output[0];
				int num = Integer.parseInt(output[1]);
				String code = output[2];
				String Rating = output[3];

				media.add(new Movie(tital, num, code, Rating));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	public void saveAlbumData() {
		File output = new File("Album.txt");
		try {
			PrintWriter out = new PrintWriter(output);
			for (int i = 0; i < media.size(); i++) {
				if (media.get(i) instanceof Album) {
					out.write(media.get(i).getTitle() + "," + media.get(i).getNumCopy() + "," + media.get(i).getCode()
							+ "," + media.get(i).getArtist() + "," + media.get(i).getSongs() + "\n");
				}
			}

			out.close();
		} catch (FileNotFoundException mo) {
			System.out.println(mo);
		}
	}

	public void readAlbumData(ArrayList<Media> media) {
		File file = new File("C:\\Users\\moham\\Desktop\\AbuThaherjava\\Example\\Album.txt");
		Scanner sc;
		String[] output = new String[5];

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {

				output = sc.nextLine().split(",");
				String tital = output[0];
				int num = Integer.parseInt(output[1]);
				String code = output[2];
				String artict = output[3];
				String songs = output[4];

				media.add(new Album(tital, num, code, artict, songs));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}
	
	public void saveIntersted_RentedData() {
		File output = new File("Intersted.txt");
		try {
			PrintWriter out = new PrintWriter(output);
			for(int i =0 ; i<customer.size() ; i++) {
				out.write("\n"+customer.get(i).toString()+"\n"+customer.get(i).getInterested()+","+customer.get(i).getRented());
			
				}
			

			out.close();
		} catch (FileNotFoundException mo) {
			System.out.println(mo);
		}
	}
	
	

}
