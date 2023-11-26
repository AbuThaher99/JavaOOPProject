package com.example.javaoopproject;
//import java.util.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//
//public class Drive {
//
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		MediaRentalManger m = new MediaRentalManger();
//
//		int choose;
//		while (true) {
//			menuo();
//			choose = input.nextInt();
//			switch (choose) {
//			case 1:
//				System.out.println("Enter the number of Customer :");
//				int num = input.nextInt();
//				testAddingCustomers(m, num);
//				break;
//			case 2:
//				System.out.println("Enter the number of movies :");
//				int nmovie = input.nextInt();
//				System.out.println("Enter the number of games : ");
//				int ngame = input.nextInt();
//				System.out.println("Enter the number of Albums : ");
//				int nAlbum = input.nextInt();
//				testAddingMedia(m, nmovie, ngame, nAlbum);
//				break;
//			case 3:
//				System.out.println("Enter the number of adding cart :");
//				int ncart = input.nextInt();
//				testingAddingToCart(m, ncart);
//				break;
//			case 4:
//				System.out.println("Enter the number of remeoving cart :");
//				int ren = input.nextInt();
//				testingRemovingFromCart(m, ren);
//				break;
//			case 5:
//				testProcessingRequestsOne(m);
//				break;
//			case 6:
//				testProcessingRequeststwo(m);
//				break;
//			case 7:
//				System.out.println("Enter the number of Returing Media : ");
//				int n = input.nextInt();
//				testReturnMedia(m, n);
//				break;
//			case 8:
//				System.out.println("Enter the number of Sarching Media :");
//				int nm = input.nextInt();
//			//	testSearchMedia(m, nm);
//			case 9:
//				File output = new File("output.txt");
//				try {
//					PrintWriter out = new PrintWriter(output);
//					out.write(m.getAllCustomersInfo());
//					out.write(m.getAllMediaInfo());
//					out.close();
//				} catch (FileNotFoundException e) {
//					System.out.println(e);
//				}
//				break;
//			case 10:
//				return;
//
//			}
//
//		}
//
//	}
//
//	public static void testAddingCustomers(MediaRentalManger m, int n) {
//		Scanner input = new Scanner(System.in);
//		for (int i = 0; i < n; i++) {
//			System.out.println("Enter The name of Customer :" +(i+1));
//
//			String name = input.next();
//			System.out.println("Enter the Addrees of Customer :" +(i+1));
//			String add = input.next();
//			System.out.println("Enter the plan of the Customer :" +(i+1));
//			String plan = input.next();
//			m.addCustomer(name, add, plan);
//
//		}
//	}
//
//	public static void menuo() {
//		System.out.println("1- Add Customer.");
//		System.out.println("2- Add Media.");
//		System.out.println("3-Add to Cart. ");
//		System.out.println("4-Remove from Cart.");
//		System.out.println("5-Pross.");
//		System.out.println("6-pross two.");
//		System.out.println("7-test return Media.");
//		System.out.println("8-test Sarch Media.");
//		System.out.println("9-save the database.");
//		System.out.println("10-Exit.");
//	}
//
//	public static void testAddingMedia(MediaRentalManger m, int n1, int n2, int n3) {
//		Scanner input = new Scanner(System.in);
//		for (int i = 0; i < n1; i++) {
//			System.out.println("Enter the tital movie :" +(i+1));
//			String tital = input.next();
//			System.out.println("Enter the number of copy :" +(i+1));
//			int cnum = input.nextInt();
//			System.out.println("Enter the fowlling :- DR or HR or AC :"+(i+1));
//			String rat = input.next();
//			m.addMovie(tital, cnum, rat);
//		}
//		for (int i = 0; i < n2; i++) {
//			System.out.println("Enter the tital game :" +(i+1));
//			String tital = input.next();
//			System.out.println("Enter the number of copy :" +(i+1));
//			int cnum = input.nextInt();
//			System.out.println("Enter the wight :" +(i+1));
//			double wi = input.nextDouble();
//			m.addGame(tital, cnum, wi);
//		}
//		for (int i = 0; i < n1; i++) {
//			System.out.println("Enter the tital Album :" +(i+1));
//			String tital = input.next();
//			System.out.println("Enter the number of copy :" +(i+1));
//			int cnum = input.nextInt();
//			System.out.println("Enter the Aritct name :" +(i+1));
//			String ar = input.next();
//			System.out.println("Enter the name of the songs :" +(i+1));
//			String son = input.next();
//			m.addAlbum(tital, cnum, ar, son);
//
//		}
//
//	}
//
//	public static void testingAddingToCart(MediaRentalManger m, int num) {
//		Scanner input = new Scanner(System.in);
//		for (int i = 0; i < num; i++) {
//			System.out.println("Enter the Customer names :" +(i+1));
//			String name = input.next();
//			System.out.println("Enter the Media Titial :" +(i+1));
//			String Tit = input.next();
//			m.addToCart(name, Tit);
//		}
//
//	}
//
//	public static void testingRemovingFromCart(MediaRentalManger m, int n) {
//		Scanner input = new Scanner(System.in);
//		for (int i = 0; i < n; i++) {
//			System.out.println("Enter the Customer name to remove :" +(i+1));
//			String na = input.next();
//			System.out.println("Enter the Media Tital :" +(i+1));
//			String tit = input.next();
//			m.removeFromCart(na, tit);
//		}
//
//	}
//
//	public static void testProcessingRequestsOne(MediaRentalManger m) {
//		m.print();
//	}
//
//	public static void testProcessingRequeststwo(MediaRentalManger m) {
//		m.processRequests();
//
//	}
//
//	public static void testReturnMedia(MediaRentalManger m, int n) {
//		Scanner input = new Scanner(System.in);
//		for (int i = 0; i < n; i++) {
//			System.out.println("Enter the Customer name :" +(i+1));
//			String name = input.next();
//			System.out.println("Enter the Media Titall :"+(i+1));
//			String tit = input.next();
//			m.returnMedia(name, tit);
//		}
//	}
//
////	public static void testSearchMedia(MediaRentalManger m, int n) {
////		Scanner input = new Scanner(System.in);
////		for (int i = 0; i < n; i++) {
////			System.out.println("Enter the Tital :");
////			String tit = input.next();
////			System.out.println("Enter the Rating :");
////			String rat = input.next();
////			System.out.println("Enter the Articit Name :");
////			String art = input.next();
////			System.out.println("Enter the songs name :");
////			String son = input.next();
////			m.searchMedia(tit, rat, art, son);
////
////		}
////	}
//
//}