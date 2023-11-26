package com.example.javaoopproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HelloApplication extends Application {
	private void AddGmes(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane AddGame = new GridPane();
		Label lab = new Label();
		lab.setText("Code :");
		lab.setPrefHeight(113);
		lab.setPrefWidth(227);
		lab.setFont(Font.font("Oranienbaum", 24));
		lab.setTextFill(Color.WHITE);
		AddGame.setMargin(lab, new Insets(0, 0, 0, 130));

		Label lab2 = new Label();
		lab2.setText("Media Tital :");
		lab2.setPrefHeight(113);
		lab2.setPrefWidth(227);
		lab2.setFont(Font.font("Oranienbaum", 24));
		lab2.setTextFill(Color.WHITE);
		AddGame.setMargin(lab2, new Insets(0, 0, 0, 130));

		Label lab3 = new Label();
		lab3.setText("Number of Copies :");
		lab3.setPrefHeight(113);
		lab3.setPrefWidth(227);
		lab3.setFont(Font.font("Oranienbaum", 23));
		lab3.setTextFill(Color.WHITE);
		AddGame.setMargin(lab3, new Insets(0, 0, 0, 130));

		Label lab4 = new Label();
		lab4.setText("Wight :");
		lab4.setPrefHeight(113);
		lab4.setPrefWidth(227);
		lab4.setFont(Font.font("Oranienbaum", 24));
		lab4.setTextFill(Color.WHITE);
		AddGame.setMargin(lab4, new Insets(0, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("The Messege is :");
		lab5.setPrefHeight(113);
		lab5.setPrefWidth(227);
		lab5.setFont(Font.font("Oranienbaum", 24));
		lab5.setTextFill(Color.WHITE);
		AddGame.setMargin(lab5, new Insets(0, 0, 0, 130));

		TextField text = new TextField();
		text.setPrefHeight(25);
		text.setPrefWidth(195);

		TextField text1 = new TextField();
		text1.setPrefHeight(25);
		text1.setPrefWidth(195);

		TextField text2 = new TextField();
		text2.setPrefHeight(25);
		text2.setPrefWidth(195);
		text2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

		TextField text3 = new TextField();
		text3.setPrefHeight(25);
		text3.setPrefWidth(195);
		text3.setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));

		TextArea Area = new TextArea();
		Area.setPrefHeight(50);
		Area.setPrefWidth(204);
		Area.setEditable(false);
		Area.setPromptText("Erorr");

		Button Add = new Button("Add", new ImageView("/imgs/Add.png"));
		Add.setPrefHeight(61);
		Add.setPrefWidth(106);
		Add.setTextFill(Color.BLACK);
		Add.setStyle("-fx-background-color: #ffffff");
		Add.setFont(Font.font("Oranienbaum", 18));
		Add.setContentDisplay(ContentDisplay.TOP);
		AddGame.setMargin(Add, new Insets(30, 0, 0, 130));
		Add.setOnAction(e -> {
			try {
				if (obj.CheackMedia(text.getText()) == true) {
					Area.setText("The Code alredy exists");
					Area.setStyle("-fx-text-inner-color: #ff0000");

					return;
				} else {
					obj.addGame(text1.getText(), Integer.parseInt(text2.getText()), text.getText(),
							Double.parseDouble(text3.getText()));
					text.setText("");
					text1.setText("");
					text2.setText("");
					text3.setText("");
					Area.setText("Added successfully ");
				}
			} catch (Exception mo) {
				Area.setText("You must import a number");
				text2.setText("");
				Area.setStyle("-fx-text-inner-color: #ff0000");

			}

		});

		Button ba = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba.setPrefHeight(61);
		ba.setPrefWidth(106);
		ba.setTextFill(Color.BLACK);
		ba.setStyle("-fx-background-color: #ffffff");
		ba.setFont(Font.font("Oranienbaum", 18));
		ba.setContentDisplay(ContentDisplay.TOP);
		AddGame.setMargin(ba, new Insets(30, 0, 0, 20));
		ba.setOnAction(e -> {

			pri.setScene(AddMediaPage);
		});
		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		AddGame.setMargin(com, new Insets(0, 0, 0, 130));

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				AddMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				AddGmes(pri);
			} else if (combo_box.getValue().equals("Album")) {
				AddAlbum(pri);
			}
		});

		AddGame.add(com, 0, 0);
		AddGame.add(lab, 0, 1);
		AddGame.add(lab2, 0, 2);
		AddGame.add(lab3, 0, 3);
		AddGame.add(lab4, 0, 4);
		AddGame.add(lab5, 0, 5);

		AddGame.add(combo_box, 1, 0);
		AddGame.add(text, 1, 1);
		AddGame.add(text1, 1, 2);
		AddGame.add(text2, 1, 3);
		AddGame.add(text3, 1, 4);
		AddGame.add(Area, 1, 5);

		AddGame.add(ba, 2, 6);
		AddGame.add(Add, 0, 6);

		AddGame.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, AddGame);
		AddGameMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(AddGameMedia);
		pri.show();
	}

	private void AddMovie(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane AddGame = new GridPane();
		Label lab = new Label();
		lab.setText("Code :");
		lab.setPrefHeight(113);
		lab.setPrefWidth(227);
		lab.setFont(Font.font("Oranienbaum", 24));
		lab.setTextFill(Color.WHITE);
		AddGame.setMargin(lab, new Insets(0, 0, 0, 130));

		Label lab2 = new Label();
		lab2.setText("Media Tital :");
		lab2.setPrefHeight(113);
		lab2.setPrefWidth(227);
		lab2.setFont(Font.font("Oranienbaum", 24));
		lab2.setTextFill(Color.WHITE);
		AddGame.setMargin(lab2, new Insets(0, 0, 0, 130));

		Label lab3 = new Label();
		lab3.setText("Number of Copies :");
		lab3.setPrefHeight(113);
		lab3.setPrefWidth(227);
		lab3.setFont(Font.font("Oranienbaum", 23));
		lab3.setTextFill(Color.WHITE);
		AddGame.setMargin(lab3, new Insets(0, 0, 0, 130));

		Label lab4 = new Label();
		lab4.setText("Rate :");
		lab4.setPrefHeight(113);
		lab4.setPrefWidth(227);
		lab4.setFont(Font.font("Oranienbaum", 24));
		lab4.setTextFill(Color.WHITE);
		AddGame.setMargin(lab4, new Insets(0, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("The Messege is :");
		lab5.setPrefHeight(113);
		lab5.setPrefWidth(227);
		lab5.setFont(Font.font("Oranienbaum", 24));
		lab5.setTextFill(Color.WHITE);
		AddGame.setMargin(lab5, new Insets(0, 0, 0, 130));

		TextField text = new TextField();
		text.setPrefHeight(25);
		text.setPrefWidth(195);

		TextField text1 = new TextField();
		text1.setPrefHeight(25);
		text1.setPrefWidth(195);

		TextField text2 = new TextField();
		text2.setPrefHeight(25);
		text2.setPrefWidth(195);
		text2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

		TextField text3 = new TextField();
		text3.setPrefHeight(25);
		text3.setPrefWidth(195);

		TextArea Area = new TextArea();
		Area.setPrefHeight(50);
		Area.setPrefWidth(204);
		Area.setEditable(false);
		Area.setPromptText("Erorr");

		ToggleGroup TGg = new ToggleGroup();
		RadioButton R3 = new RadioButton("DR");
		R3.setFont(Font.font("Oranienbaum", 14));
		RadioButton R4 = new RadioButton("HR");
		R4.setFont(Font.font("Oranienbaum", 14));
		RadioButton R5 = new RadioButton("AC");
		R5.setFont(Font.font("Oranienbaum", 14));
		R3.setToggleGroup(TGg);
		R4.setToggleGroup(TGg);
		R5.setToggleGroup(TGg);

		Button Add = new Button("Add", new ImageView("/imgs/Add.png"));
		Add.setPrefHeight(61);
		Add.setPrefWidth(106);
		Add.setTextFill(Color.BLACK);
		Add.setStyle("-fx-background-color: #ffffff");
		Add.setFont(Font.font("Oranienbaum", 18));
		Add.setContentDisplay(ContentDisplay.TOP);
		AddGame.setMargin(Add, new Insets(30, 0, 0, 0));
		Add.setOnAction(e -> {
			try {
				RadioButton sel = (RadioButton) TGg.getSelectedToggle();
				String val = sel.getText();
				if (obj.CheackMedia(text.getText()) == true) {
					Area.setText("The Code alredy exists");
					Area.setStyle("-fx-text-inner-color: #ff0000");

					return;
				} else

					obj.addMovie(text1.getText(), Integer.parseInt(text2.getText()), text.getText(), val);

				text.setText("");
				text1.setText("");
				text2.setText("");
				R3.setSelected(false);
				R4.setSelected(false);
				R5.setSelected(false);
				Area.setText("Added successfully ");
			} catch (Exception mo) {
				Area.setText("You must import a number");
				Area.setStyle("-fx-text-inner-color: #ff0000");

				text2.setText("");
			}

		});

		Button ba = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba.setPrefHeight(61);
		ba.setPrefWidth(106);
		ba.setTextFill(Color.BLACK);
		ba.setStyle("-fx-background-color: #ffffff");
		ba.setFont(Font.font("Oranienbaum", 18));
		ba.setContentDisplay(ContentDisplay.TOP);
		AddGame.setMargin(ba, new Insets(30, 0, 0, 0));
		ba.setOnAction(e -> {

			pri.setScene(AddMediaPage);
		});
		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		AddGame.setMargin(com, new Insets(0, 0, 0, 130));

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				AddMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				AddGmes(pri);
			} else if (combo_box.getValue().equals("Album")) {
				AddAlbum(pri);
			}
		});

		AddGame.add(com, 0, 0);
		AddGame.add(lab, 0, 1);
		AddGame.add(lab2, 0, 2);
		AddGame.add(lab3, 0, 3);
		AddGame.add(lab4, 0, 4);
		AddGame.add(lab5, 0, 5);

		AddGame.add(combo_box, 1, 0);
		AddGame.add(text, 1, 1);
		AddGame.add(text1, 1, 2);
		AddGame.add(text2, 1, 3);
		AddGame.add(R3, 1, 4);
		AddGame.add(R4, 2, 4);
		AddGame.add(R5, 3, 4);
		AddGame.add(Area, 1, 5);

		AddGame.add(ba, 2, 6);
		AddGame.add(Add, 1, 6);
		AddGame.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, AddGame);
		AddMovieMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(AddMovieMedia);
		pri.show();
	}

	private void AddAlbum(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane AddAlbum = new GridPane();

		Label lab = new Label();
		lab.setText("Code :");
		lab.setPrefHeight(57);
		lab.setPrefWidth(177);
		lab.setFont(Font.font("Oranienbaum", 18));
		lab.setTextFill(Color.WHITE);
		AddAlbum.setMargin(lab, new Insets(30, 0, 0, 130));

		Label lab2 = new Label();
		lab2.setText("Media Tital :");
		lab2.setPrefHeight(57);
		lab2.setPrefWidth(177);
		lab2.setFont(Font.font("Oranienbaum", 18));
		lab2.setTextFill(Color.WHITE);
		AddAlbum.setMargin(lab2, new Insets(30, 0, 0, 130));

		Label lab3 = new Label();
		lab3.setText("Number of Copies :");
		lab3.setPrefHeight(57);
		lab3.setPrefWidth(177);
		lab3.setFont(Font.font("Oranienbaum", 18));
		lab3.setTextFill(Color.WHITE);
		AddAlbum.setMargin(lab3, new Insets(30, 0, 0, 130));

		Label lab4 = new Label();
		lab4.setText("Songs :");
		lab4.setPrefHeight(57);
		lab4.setPrefWidth(177);
		lab4.setFont(Font.font("Oranienbaum", 18));
		lab4.setTextFill(Color.WHITE);
		AddAlbum.setMargin(lab4, new Insets(30, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("Artict :");
		lab5.setPrefHeight(57);
		lab5.setPrefWidth(177);
		lab5.setFont(Font.font("Oranienbaum", 18));
		lab5.setTextFill(Color.WHITE);
		AddAlbum.setMargin(lab5, new Insets(30, 0, 0, 130));

		Label lab6 = new Label();
		lab6.setText("The Messege is :");
		lab6.setPrefHeight(37);
		lab6.setPrefWidth(125);
		lab6.setFont(Font.font("Oranienbaum", 16));
		lab6.setTextFill(Color.WHITE);
		AddAlbum.setMargin(lab6, new Insets(30, 0, 0, 130));

		TextField text = new TextField();
		text.setPrefHeight(25);
		text.setPrefWidth(195);
		AddAlbum.setMargin(text, new Insets(30, 0, 0, 0));

		TextField text1 = new TextField();
		text1.setPrefHeight(25);
		text1.setPrefWidth(195);
		AddAlbum.setMargin(text1, new Insets(30, 0, 0, 0));

		TextField text2 = new TextField();
		text2.setPrefHeight(25);
		text2.setPrefWidth(195);
		text2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
		AddAlbum.setMargin(text2, new Insets(30, 0, 0, 0));

		TextField text3 = new TextField();
		text3.setPrefHeight(25);
		text3.setPrefWidth(195);
		AddAlbum.setMargin(text3, new Insets(30, 0, 0, 0));

		TextField text4 = new TextField();
		text4.setPrefHeight(25);
		text4.setPrefWidth(195);
		AddAlbum.setMargin(text4, new Insets(30, 0, 0, 0));

		TextArea Area = new TextArea();
		Area.setPrefHeight(27);
		Area.setPrefWidth(200);
		Area.setEditable(false);

		Button Add = new Button("Add", new ImageView("/imgs/Add.png"));
		Add.setPrefHeight(61);
		Add.setPrefWidth(106);
		Add.setTextFill(Color.BLACK);
		Add.setStyle("-fx-background-color: #ffffff");
		Add.setFont(Font.font("Oranienbaum", 18));
		Add.setContentDisplay(ContentDisplay.TOP);
		AddAlbum.setMargin(Add, new Insets(30, 0, 0, 130));
		Add.setOnAction(e -> {
			try {
				if (obj.CheackMedia(text.getText()) == true) {
					Area.setText("The Code is already exists ");
					Area.setStyle("-fx-text-inner-color: #ff0000");

					return;
				} else

					obj.addAlbum(text1.getText(), Integer.parseInt(text2.getText()), text.getText(), text4.getText(),
							text3.getText());

				text.setText("");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				Area.setText("Added successfully ");
			} catch (Exception mo) {
				Area.setText("You must import a number");
				text2.setText("");
				Area.setStyle("-fx-text-inner-color: #ff0000");

			}

		});

		Button ba = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba.setPrefHeight(61);
		ba.setPrefWidth(106);
		ba.setTextFill(Color.BLACK);
		ba.setStyle("-fx-background-color: #ffffff");
		ba.setFont(Font.font("Oranienbaum", 18));
		ba.setContentDisplay(ContentDisplay.TOP);
		AddAlbum.setMargin(ba, new Insets(30, 0, 0, 130));
		ba.setOnAction(e -> {

			pri.setScene(AddMediaPage);
		});
		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");

		Label com = new Label();

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		AddAlbum.setMargin(com, new Insets(0, 0, 0, 130));

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				AddMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				AddGmes(pri);
			} else if (combo_box.getValue().equals("Album")) {
				AddAlbum(pri);
			}
		});

		AddAlbum.add(com, 0, 0);
		AddAlbum.add(lab, 0, 1);
		AddAlbum.add(lab2, 0, 2);
		AddAlbum.add(lab3, 0, 3);
		AddAlbum.add(lab4, 0, 4);
		AddAlbum.add(lab5, 0, 5);
		AddAlbum.add(lab6, 0, 6);

		AddAlbum.add(combo_box, 1, 0);
		AddAlbum.add(text, 1, 1);
		AddAlbum.add(text1, 1, 2);
		AddAlbum.add(text2, 1, 3);
		AddAlbum.add(text3, 1, 4);
		AddAlbum.add(text4, 1, 5);
		AddAlbum.add(Area, 1, 6);

		AddAlbum.add(Add, 0, 7);
		AddAlbum.add(ba, 1, 7);
		AddAlbum.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, AddAlbum);
		AddAlnumMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(AddAlnumMedia);
		pri.show();
	}

	private void DeleteGame(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane DeleteGame = new GridPane();

		Label l0 = new Label();
		l0.setText("Code :");
		l0.setPrefHeight(113);
		l0.setPrefWidth(227);
		l0.setFont(Font.font("Oranienbaum", 24));
		l0.setTextFill(Color.WHITE);
		DeleteGame.setMargin(l0, new Insets(30, 0, 0, 130));

		Label la0 = new Label();
		la0.setText("Media Tital :");
		la0.setPrefHeight(113);
		la0.setPrefWidth(227);
		la0.setFont(Font.font("Oranienbaum", 24));
		la0.setTextFill(Color.WHITE);
		DeleteGame.setMargin(la0, new Insets(30, 0, 0, 130));

		Label l2 = new Label();
		l2.setText("Number of Copies :");
		l2.setPrefHeight(113);
		l2.setPrefWidth(227);
		l2.setFont(Font.font("Oranienbaum", 23));
		l2.setTextFill(Color.WHITE);
		DeleteGame.setMargin(l2, new Insets(30, 0, 0, 130));

		Label l3 = new Label();
		l3.setText("Weight :");
		l3.setPrefHeight(113);
		l3.setPrefWidth(227);
		l3.setFont(Font.font("Oranienbaum", 24));
		l3.setTextFill(Color.WHITE);
		DeleteGame.setMargin(l3, new Insets(30, 0, 0, 130));

		Label l4 = new Label();
		l4.setText("the Messege is :");
		l4.setPrefHeight(113);
		l4.setPrefWidth(227);
		l4.setFont(Font.font("Oranienbaum", 24));
		l4.setTextFill(Color.WHITE);
		DeleteGame.setMargin(l4, new Insets(30, 0, 0, 130));

		TextField te1 = new TextField();
		te1.setPrefHeight(25);
		te1.setPrefWidth(195);
		DeleteGame.setMargin(te1, new Insets(30, 0, 0, 0));

		TextField te2 = new TextField();
		te2.setPrefHeight(25);
		te2.setPrefWidth(195);
		te2.setEditable(false);
		DeleteGame.setMargin(te2, new Insets(30, 0, 0, 0));

		TextField te3 = new TextField();
		te3.setPrefHeight(25);
		te3.setPrefWidth(195);
		te3.setEditable(false);
		DeleteGame.setMargin(te3, new Insets(30, 0, 0, 0));

		TextField te4 = new TextField();
		te4.setPrefHeight(25);
		te4.setPrefWidth(195);
		te4.setEditable(false);
		DeleteGame.setMargin(te4, new Insets(30, 0, 0, 0));

		TextArea Area = new TextArea();
		Area.setPrefHeight(50);
		Area.setPrefWidth(204);
		Area.setEditable(false);
		Area.setPromptText("Erorr");

		Button Add2 = new Button("Delete", new ImageView("/imgs/Remove.png"));
		Add2.setPrefHeight(61);
		Add2.setPrefWidth(106);
		Add2.setTextFill(Color.BLACK);
		Add2.setStyle("-fx-background-color: #ffffff");
		Add2.setFont(Font.font("Oranienbaum", 18));
		Add2.setContentDisplay(ContentDisplay.TOP);
		DeleteGame.setMargin(Add2, new Insets(30, 0, 0, 130));
		Add2.setOnAction(e -> {
			obj.DeleteGame(te1.getText());

			te1.setText("");
			te2.setText("");
			te3.setText("");
			te4.setText("");
			Area.setText("Remove successfully");
		});

		Button ba3 = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba3.setPrefHeight(61);
		ba3.setPrefWidth(106);
		ba3.setTextFill(Color.BLACK);
		ba3.setStyle("-fx-background-color: #ffffff");
		ba3.setFont(Font.font("Oranienbaum", 18));
		ba3.setContentDisplay(ContentDisplay.TOP);
		DeleteGame.setMargin(ba3, new Insets(30, 0, 0, 130));
		ba3.setOnAction(e -> {
			pri.setScene(DeleteMediaPage);
		});

		Button find2 = new Button("Find", new ImageView("/imgs/Search.png"));
		find2.setPrefHeight(61);
		find2.setPrefWidth(106);
		find2.setTextFill(Color.BLACK);
		find2.setStyle("-fx-background-color: #ffffff");
		find2.setFont(Font.font("Oranienbaum", 18));
		find2.setContentDisplay(ContentDisplay.TOP);
		DeleteGame.setMargin(find2, new Insets(30, 0, 0, 55));
		find2.setOnAction(e -> {
			boolean med = obj.CheackMedia(te1.getText());
			if (med == false) {
				Area.setText("The Media does not exixt");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				te2.setText("");
				te3.setText("");
				te4.setText("");
			} else {
				Area.setText("The Media has been found");
			}
			for (int i = 0; i < obj.media.size(); i++) {
				if (obj.media.get(i).getCode().equals(te1.getText())) {
					if (obj.media.get(i) instanceof Game) {
						te2.setText(obj.media.get(i).getTitle());
						te3.setText(String.valueOf(obj.media.get(i).getNumCopy()));
						te4.setText(String.valueOf(obj.media.get(i).getWeight()));
						Area.setText("The Media has been found");
					} else {
						Area.setText("The Media does not exixt");
						Area.setStyle("-fx-text-inner-color: #ff0000");
						te2.setText("");
						te3.setText("");
						te4.setText("");
					}
				}
			}

		});
		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();

		com.setText("Enter your Media :");
		DeleteGame.setMargin(com, new Insets(30, 0, 0, 130));
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		DeleteGame.setMargin(combo_box, new Insets(30, 0, 0, 0));
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				DeleteMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				DeleteGame(pri);
			} else if (combo_box.getValue().equals("Album")) {
				DeleteAlbum(pri);
			}
		});

		DeleteGame.add(com, 0, 0);
		DeleteGame.add(l0, 0, 1);
		DeleteGame.add(la0, 0, 2);
		DeleteGame.add(l2, 0, 3);
		DeleteGame.add(l3, 0, 4);
		DeleteGame.add(l4, 0, 5);

		DeleteGame.add(combo_box, 1, 0);
		DeleteGame.add(te1, 1, 1);
		DeleteGame.add(te2, 1, 2);
		DeleteGame.add(te3, 1, 3);
		DeleteGame.add(te4, 1, 4);
		DeleteGame.add(Area, 1, 5);

		DeleteGame.add(Add2, 0, 6);
		DeleteGame.add(ba3, 2, 6);
		DeleteGame.add(find2, 1, 6);
		DeleteGame.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, DeleteGame);
		DeleteGameMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(DeleteGameMedia);
		pri.show();
	}

	private void DeleteMovie(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane UpdateMovie = new GridPane();
		Label lab = new Label();
		lab.setText("Code :");
		lab.setPrefHeight(113);
		lab.setPrefWidth(227);
		lab.setFont(Font.font("Oranienbaum", 24));
		lab.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(lab, new Insets(0, 0, 0, 130));

		Label lab2 = new Label();
		lab2.setText("Media Tital :");
		lab2.setPrefHeight(113);
		lab2.setPrefWidth(227);
		lab2.setFont(Font.font("Oranienbaum", 24));
		lab2.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(lab2, new Insets(0, 0, 0, 130));

		Label lab3 = new Label();
		lab3.setText("Number of Copies :");
		lab3.setPrefHeight(113);
		lab3.setPrefWidth(227);
		lab3.setFont(Font.font("Oranienbaum", 23));
		lab3.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(lab3, new Insets(0, 0, 0, 130));

		Label lab4 = new Label();
		lab4.setText("Rate :");
		lab4.setPrefHeight(113);
		lab4.setPrefWidth(227);
		lab4.setFont(Font.font("Oranienbaum", 24));
		lab4.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(lab4, new Insets(0, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("The Messege is :");
		lab5.setPrefHeight(113);
		lab5.setPrefWidth(227);
		lab5.setFont(Font.font("Oranienbaum", 24));
		lab5.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(lab5, new Insets(0, 0, 0, 130));

		TextField text = new TextField();
		text.setPrefHeight(25);
		text.setPrefWidth(195);

		TextField text1 = new TextField();
		text1.setPrefHeight(25);
		text1.setPrefWidth(195);
		text1.setEditable(false);

		TextField text2 = new TextField();
		text2.setPrefHeight(25);
		text2.setPrefWidth(195);
		text2.setEditable(false);

		TextArea Area = new TextArea();
		Area.setPrefHeight(50);
		Area.setPrefWidth(204);
		Area.setEditable(false);
		Area.setPromptText("Erorr");

		ToggleGroup TGg = new ToggleGroup();
		RadioButton R3 = new RadioButton("DR");
		R3.setFont(Font.font("Oranienbaum", 14));
		RadioButton R4 = new RadioButton("HR");
		R4.setFont(Font.font("Oranienbaum", 14));
		RadioButton R5 = new RadioButton("AC");
		R5.setFont(Font.font("Oranienbaum", 14));
		R3.setToggleGroup(TGg);
		R4.setToggleGroup(TGg);
		R5.setToggleGroup(TGg);

		Button Add = new Button("Delete", new ImageView("/imgs/Remove.png"));
		Add.setPrefHeight(61);
		Add.setPrefWidth(106);
		Add.setTextFill(Color.BLACK);
		Add.setStyle("-fx-background-color: #ffffff");
		Add.setFont(Font.font("Oranienbaum", 18));
		Add.setContentDisplay(ContentDisplay.TOP);
		UpdateMovie.setMargin(Add, new Insets(30, 0, 0, 55));
		Add.setOnAction(e -> {

			obj.DeleteMovie(text.getText());
			text.setText("");
			text1.setText("");
			text2.setText("");
			R3.setSelected(false);
			R4.setSelected(false);
			R5.setSelected(false);
			Area.setText("Remove successfully ");

		});

		Button ba = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba.setPrefHeight(61);
		ba.setPrefWidth(106);
		ba.setTextFill(Color.BLACK);
		ba.setStyle("-fx-background-color: #ffffff");
		ba.setFont(Font.font("Oranienbaum", 18));
		ba.setContentDisplay(ContentDisplay.TOP);
		UpdateMovie.setMargin(ba, new Insets(30, 0, 0, 130));
		ba.setOnAction(e -> {
			pri.setScene(DeleteMediaPage);
		});

		Button find2 = new Button("Find", new ImageView("/imgs/Search.png"));
		find2.setPrefHeight(61);
		find2.setPrefWidth(106);
		find2.setTextFill(Color.BLACK);
		find2.setStyle("-fx-background-color: #ffffff");
		find2.setFont(Font.font("Oranienbaum", 18));
		find2.setContentDisplay(ContentDisplay.TOP);
		UpdateMovie.setMargin(find2, new Insets(30, 0, 0, 130));
		find2.setOnAction(e -> {
			Media med = obj.findMedia(text.getText());
			if (med == null) {
				Area.setText("The Media does not exixt");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				text1.setText("");
				text2.setText("");
				R3.setSelected(false);
				R4.setSelected(false);
				R5.setSelected(false);
				return;
			} else {
				Area.setText("The Media does not exixt");
			}
			if (med instanceof Movie) {

				text1.setText(med.getTitle());
				text2.setText(String.valueOf(med.getNumCopy()));
				Area.setText("The Media has been found");
				if (med.getRating().equals("DR")) {
					R3.setSelected(true);
				} else if (med.getRating().equals("HR")) {
					R4.setSelected(true);
				} else
					R5.setSelected(true);
			}

		});

		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(com, new Insets(0, 0, 0, 130));

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				DeleteMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				DeleteGame(pri);
			} else if (combo_box.getValue().equals("Album")) {
				DeleteAlbum(pri);
			}
		});

		UpdateMovie.add(com, 0, 0);
		UpdateMovie.add(lab, 0, 1);
		UpdateMovie.add(lab2, 0, 2);
		UpdateMovie.add(lab3, 0, 3);
		UpdateMovie.add(lab4, 0, 4);
		UpdateMovie.add(lab5, 0, 5);

		UpdateMovie.add(combo_box, 1, 0);
		UpdateMovie.add(text, 1, 1);
		UpdateMovie.add(text1, 1, 2);
		UpdateMovie.add(text2, 1, 3);
		UpdateMovie.add(R3, 1, 4);
		UpdateMovie.add(R4, 2, 4);
		UpdateMovie.add(R5, 3, 4);
		UpdateMovie.add(Area, 1, 5);

		UpdateMovie.add(ba, 2, 6);
		UpdateMovie.add(Add, 1, 6);
		UpdateMovie.add(find2, 0, 6);
		UpdateMovie.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, UpdateMovie);
		DeleteMovieMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());

		pri.setScene(DeleteMovieMedia);
		pri.show();
	}

	private void DeleteAlbum(Stage pri) {

		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane DeleteAlbum = new GridPane();
		Label lab = new Label();
		lab.setText("Code :");
		lab.setPrefHeight(57);
		lab.setPrefWidth(177);
		lab.setFont(Font.font("Oranienbaum", 18));
		lab.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(lab, new Insets(30, 0, 0, 130));

		Label lab2 = new Label();
		lab2.setText("Media Tital :");
		lab2.setPrefHeight(57);
		lab2.setPrefWidth(177);
		lab2.setFont(Font.font("Oranienbaum", 18));
		lab2.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(lab2, new Insets(30, 0, 0, 130));

		Label lab3 = new Label();
		lab3.setText("Number of Copies :");
		lab3.setPrefHeight(57);
		lab3.setPrefWidth(177);
		lab3.setFont(Font.font("Oranienbaum", 18));
		lab3.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(lab3, new Insets(30, 0, 0, 130));

		Label lab4 = new Label();
		lab4.setText("Songs :");
		lab4.setPrefHeight(57);
		lab4.setPrefWidth(177);
		lab4.setFont(Font.font("Oranienbaum", 18));
		lab4.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(lab4, new Insets(30, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("Artict :");
		lab5.setPrefHeight(57);
		lab5.setPrefWidth(177);
		lab5.setFont(Font.font("Oranienbaum", 18));
		lab5.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(lab5, new Insets(30, 0, 0, 130));

		Label lab6 = new Label();
		lab6.setText("The Messege is :");
		lab6.setPrefHeight(37);
		lab6.setPrefWidth(125);
		lab6.setFont(Font.font("Oranienbaum", 16));
		lab6.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(lab6, new Insets(30, 0, 0, 130));

		TextField text = new TextField();
		text.setPrefHeight(25);
		text.setPrefWidth(195);
		DeleteAlbum.setMargin(text, new Insets(30, 0, 0, 0));

		TextField text1 = new TextField();
		text1.setPrefHeight(25);
		text1.setPrefWidth(195);
		text1.setEditable(false);
		DeleteAlbum.setMargin(text1, new Insets(30, 0, 0, 0));

		TextField text2 = new TextField();
		text2.setPrefHeight(25);
		text2.setPrefWidth(195);
		text2.setEditable(false);
		DeleteAlbum.setMargin(text2, new Insets(30, 0, 0, 0));

		TextField text3 = new TextField();
		text3.setPrefHeight(25);
		text3.setPrefWidth(195);
		text3.setEditable(false);
		DeleteAlbum.setMargin(text3, new Insets(30, 0, 0, 0));

		TextField text4 = new TextField();
		text4.setPrefHeight(25);
		text4.setPrefWidth(195);
		text4.setEditable(false);
		DeleteAlbum.setMargin(text4, new Insets(30, 0, 0, 0));

		TextArea Area = new TextArea();
		Area.setPrefHeight(27);
		Area.setPrefWidth(200);
		Area.setEditable(false);

		Button Add = new Button("Find", new ImageView("/imgs/Search.png"));
		Add.setPrefHeight(61);
		Add.setPrefWidth(106);
		Add.setTextFill(Color.BLACK);
		Add.setStyle("-fx-background-color: #ffffff");
		Add.setFont(Font.font("Oranienbaum", 18));
		Add.setContentDisplay(ContentDisplay.TOP);
		DeleteAlbum.setMargin(Add, new Insets(30, 0, 0, 130));

		Add.setOnAction(e -> {
			boolean med = obj.CheackMedia(text.getText());
			if (med == false) {
				Area.setText("The Media dose not exist ");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
			} else {
				Area.setText("The Media has been found");
			}
			for (int i = 0; i < obj.media.size(); i++) {
				if (obj.media.get(i).getCode().equals(text.getText())) {
					if (obj.media.get(i) instanceof Album) {
						text1.setText(obj.media.get(i).getTitle());
						text2.setText(String.valueOf(obj.media.get(i).getNumCopy()));
						text3.setText(obj.media.get(i).getSongs());
						text4.setText(obj.media.get(i).getArtist());
					}
				}
			}

		});

		Button Add1 = new Button("Delete", new ImageView("/imgs/Remove.png"));
		Add1.setPrefHeight(61);
		Add1.setPrefWidth(106);
		Add1.setTextFill(Color.BLACK);
		Add1.setStyle("-fx-background-color: #ffffff");
		Add1.setFont(Font.font("Oranienbaum", 18));
		Add1.setContentDisplay(ContentDisplay.TOP);
		DeleteAlbum.setMargin(Add1, new Insets(30, 0, 0, 55));

		Add1.setOnAction(e -> {
			obj.DeleteAlbum(text.getText());
			text.setText("");
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			Area.setText("Remove successfully");
		});

		Button ba = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba.setPrefHeight(61);
		ba.setPrefWidth(106);
		ba.setTextFill(Color.BLACK);
		ba.setStyle("-fx-background-color: #ffffff");
		ba.setFont(Font.font("Oranienbaum", 18));
		ba.setContentDisplay(ContentDisplay.TOP);
		DeleteAlbum.setMargin(ba, new Insets(30, 0, 0, 130));

		ba.setOnAction(e -> {

			pri.setScene(DeleteMediaPage);
		});
		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		DeleteAlbum.setMargin(com, new Insets(0, 0, 0, 130));

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				DeleteMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				DeleteGame(pri);
			} else if (combo_box.getValue().equals("Album")) {
				DeleteAlbum(pri);
			}
		});

		DeleteAlbum.add(com, 0, 0);
		DeleteAlbum.add(lab, 0, 1);
		DeleteAlbum.add(lab2, 0, 2);
		DeleteAlbum.add(lab3, 0, 3);
		DeleteAlbum.add(lab4, 0, 4);
		DeleteAlbum.add(lab5, 0, 5);
		DeleteAlbum.add(lab6, 0, 6);

		DeleteAlbum.add(combo_box, 1, 0);
		DeleteAlbum.add(text, 1, 1);
		DeleteAlbum.add(text1, 1, 2);
		DeleteAlbum.add(text2, 1, 3);
		DeleteAlbum.add(text3, 1, 4);
		DeleteAlbum.add(text4, 1, 5);
		DeleteAlbum.add(Area, 1, 6);

		DeleteAlbum.add(Add, 0, 7);
		DeleteAlbum.add(ba, 2, 7);
		DeleteAlbum.add(Add1, 1, 7);
		DeleteAlbum.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, DeleteAlbum);
		DeleteAlbumMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(DeleteAlbumMedia);
		pri.show();
	}

	private void UpdateGmes(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane UpdateGame = new GridPane();

		Label l0 = new Label();
		l0.setText("Code :");
		l0.setPrefHeight(113);
		l0.setPrefWidth(227);
		l0.setFont(Font.font("Oranienbaum", 24));
		l0.setTextFill(Color.WHITE);
		UpdateGame.setMargin(l0, new Insets(30, 0, 0, 130));

		Label la0 = new Label();
		la0.setText("Media Tital :");
		la0.setPrefHeight(113);
		la0.setPrefWidth(227);
		la0.setFont(Font.font("Oranienbaum", 24));
		la0.setTextFill(Color.WHITE);
		UpdateGame.setMargin(la0, new Insets(30, 0, 0, 130));

		Label l2 = new Label();
		l2.setText("Number of Copies :");
		l2.setPrefHeight(113);
		l2.setPrefWidth(227);
		l2.setFont(Font.font("Oranienbaum", 23));
		l2.setTextFill(Color.WHITE);
		UpdateGame.setMargin(l2, new Insets(30, 0, 0, 130));

		Label l3 = new Label();
		l3.setText("Weight :");
		l3.setPrefHeight(113);
		l3.setPrefWidth(227);
		l3.setFont(Font.font("Oranienbaum", 24));
		l3.setTextFill(Color.WHITE);
		UpdateGame.setMargin(l3, new Insets(30, 0, 0, 130));

		Label l4 = new Label();
		l4.setText("the Messege is :");
		l4.setPrefHeight(113);
		l4.setPrefWidth(227);
		l4.setFont(Font.font("Oranienbaum", 24));
		l4.setTextFill(Color.WHITE);
		UpdateGame.setMargin(l4, new Insets(30, 0, 0, 130));

		TextField te1 = new TextField();
		te1.setPrefHeight(25);
		te1.setPrefWidth(195);
		UpdateGame.setMargin(te1, new Insets(30, 0, 0, 0));

		TextField te2 = new TextField();
		te2.setPrefHeight(25);
		te2.setPrefWidth(195);
		UpdateGame.setMargin(te2, new Insets(30, 0, 0, 0));

		TextField te3 = new TextField();
		te3.setPrefHeight(25);
		te3.setPrefWidth(195);
		te3.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
		UpdateGame.setMargin(te3, new Insets(30, 0, 0, 0));

		TextField te4 = new TextField();
		te4.setPrefHeight(25);
		te4.setPrefWidth(195);
		te4.setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));
		UpdateGame.setMargin(te4, new Insets(30, 0, 0, 0));

		TextArea Area = new TextArea();
		Area.setPrefHeight(50);
		Area.setPrefWidth(204);
		Area.setEditable(false);
		Area.setPromptText("Erorr");

		Button Add2 = new Button("Update", new ImageView("/imgs/Updates.png"));
		Add2.setPrefHeight(61);
		Add2.setPrefWidth(106);
		Add2.setTextFill(Color.BLACK);
		Add2.setStyle("-fx-background-color: #ffffff");
		Add2.setFont(Font.font("Oranienbaum", 18));
		Add2.setContentDisplay(ContentDisplay.TOP);
		UpdateGame.setMargin(Add2, new Insets(30, 0, 0, 130));

		Add2.setOnAction(e -> {
			try {
				obj.UpdateGame(te2.getText(), Integer.parseInt(te3.getText()), te1.getText(),
						Double.parseDouble(te4.getText()));

				te1.setText("");
				te2.setText("");
				te3.setText("");
				te4.setText("");
				Area.setText("The Media has been Update ");
			} catch (Exception mo) {
				Area.setText("You must import a number");
				Area.setStyle("-fx-text-inner-color: #ff0000");

			}
		});

		Button ba3 = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba3.setPrefHeight(61);
		ba3.setPrefWidth(106);
		ba3.setTextFill(Color.BLACK);
		ba3.setStyle("-fx-background-color: #ffffff");
		ba3.setFont(Font.font("Oranienbaum", 18));
		ba3.setContentDisplay(ContentDisplay.TOP);
		UpdateGame.setMargin(ba3, new Insets(30, 0, 0, 130));

		ba3.setOnAction(e -> {
			pri.setScene(MediaPage);
		});

		Button find2 = new Button("Find", new ImageView("/imgs/Search.png"));
		find2.setPrefHeight(61);
		find2.setPrefWidth(106);
		find2.setTextFill(Color.BLACK);
		find2.setStyle("-fx-background-color: #ffffff");
		find2.setFont(Font.font("Oranienbaum", 18));
		find2.setContentDisplay(ContentDisplay.TOP);
		UpdateGame.setMargin(find2, new Insets(30, 0, 0, 55));

		find2.setOnAction(e -> {
			boolean med = obj.CheackMedia(te1.getText());
			if (med == false) {
				Area.setText("The Media does not exixt");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				te2.setText("");
				te3.setText("");
				te4.setText("");
			} else {
				Area.setText("The Media has been Found");

			}
			for (int i = 0; i < obj.media.size(); i++) {
				if (obj.media.get(i).getCode().equals(te1.getText())) {
					if (obj.media.get(i) instanceof Game) {
						te2.setText(obj.media.get(i).getTitle());
						te3.setText(String.valueOf(obj.media.get(i).getNumCopy()));
						te4.setText(String.valueOf(obj.media.get(i).getWeight()));

					} else {
						Area.setText("The Media does not exixt");
						Area.setStyle("-fx-text-inner-color: #ff0000");
					}
				}
			}

		});

		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();
		UpdateGame.setMargin(com, new Insets(30, 0, 0, 130));

		com.setText("Enter your Media :");

		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		UpdateGame.setMargin(combo_box, new Insets(30, 0, 0, 0));

		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				UpdateMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				UpdateGmes(pri);
			} else if (combo_box.getValue().equals("Album")) {
				UpdateAlbum(pri);
			}
		});

		UpdateGame.add(com, 0, 0);
		UpdateGame.add(l0, 0, 1);
		UpdateGame.add(la0, 0, 2);
		UpdateGame.add(l2, 0, 3);
		UpdateGame.add(l3, 0, 4);
		UpdateGame.add(l4, 0, 5);

		UpdateGame.add(combo_box, 1, 0);
		UpdateGame.add(te1, 1, 1);
		UpdateGame.add(te2, 1, 2);
		UpdateGame.add(te3, 1, 3);
		UpdateGame.add(te4, 1, 4);
		UpdateGame.add(Area, 1, 5);

		UpdateGame.add(Add2, 0, 6);
		UpdateGame.add(ba3, 2, 6);
		UpdateGame.add(find2, 1, 6);
		UpdateGame.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, UpdateGame);
		UpdateGameMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(UpdateGameMedia);
		pri.show();

	}

	private void UpdateMovie(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane UpdateMovie = new GridPane();

		Label l0 = new Label();
		l0.setText("Code :");
		l0.setPrefHeight(113);
		l0.setPrefWidth(227);
		l0.setFont(Font.font("Oranienbaum", 24));
		l0.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(l0, new Insets(0, 0, 0, 130));

		Label la0 = new Label();
		la0.setText("Media Tital :");
		la0.setPrefHeight(113);
		la0.setPrefWidth(227);
		la0.setFont(Font.font("Oranienbaum", 24));
		la0.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(la0, new Insets(0, 0, 0, 130));

		Label l2 = new Label();
		l2.setText("Number of Copies :");
		l2.setPrefHeight(113);
		l2.setPrefWidth(227);
		l2.setFont(Font.font("Oranienbaum", 23));
		l2.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(l2, new Insets(0, 0, 0, 130));

		Label l3 = new Label();
		l3.setText("Rate :");
		l3.setPrefHeight(113);
		l3.setPrefWidth(227);
		l3.setFont(Font.font("Oranienbaum", 24));
		l3.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(l3, new Insets(0, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("The Messege is :");
		lab5.setPrefHeight(113);
		lab5.setPrefWidth(227);
		lab5.setFont(Font.font("Oranienbaum", 24));
		lab5.setTextFill(Color.WHITE);
		UpdateMovie.setMargin(lab5, new Insets(0, 0, 0, 130));

		TextField te1 = new TextField();
		te1.setPrefHeight(25);
		te1.setPrefWidth(195);

		TextField te2 = new TextField();
		te2.setPrefHeight(25);
		te2.setPrefWidth(195);

		TextField te3 = new TextField();
		te3.setPrefHeight(25);
		te3.setPrefWidth(195);
		te3.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

		TextArea Area = new TextArea();
		Area.setPrefHeight(50);
		Area.setPrefWidth(204);
		Area.setEditable(false);
		Area.setPromptText("Erorr");

		ToggleGroup TGg = new ToggleGroup();
		RadioButton R3 = new RadioButton("DR");
		R3.setFont(Font.font("Oranienbaum", 14));
		RadioButton R4 = new RadioButton("HR");
		R4.setFont(Font.font("Oranienbaum", 14));
		RadioButton R5 = new RadioButton("AC");
		R5.setFont(Font.font("Oranienbaum", 14));
		R3.setToggleGroup(TGg);
		R4.setToggleGroup(TGg);
		R5.setToggleGroup(TGg);

		Button Add2 = new Button("Update", new ImageView("/imgs/Updates.png"));
		Add2.setPrefHeight(61);
		Add2.setPrefWidth(106);
		Add2.setTextFill(Color.BLACK);
		Add2.setStyle("-fx-background-color: #ffffff");
		Add2.setFont(Font.font("Oranienbaum", 18));
		Add2.setContentDisplay(ContentDisplay.TOP);
		UpdateMovie.setMargin(Add2, new Insets(30, 0, 0, 55));
		Add2.setOnAction(e -> {
			try {
				RadioButton sel = (RadioButton) TGg.getSelectedToggle();
				String val = sel.getText();
				obj.UpdateteMovie(te2.getText(), Integer.parseInt(te3.getText()), te1.getText(), val);
				te1.setText("");
				te2.setText("");
				te3.setText("");
				R3.setSelected(false);
				R4.setSelected(false);
				R5.setSelected(false);
				Area.setText("The Media has been Update");
			} catch (Exception mo) {
				Area.setText("You must Importt a number");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				te3.setText("");
			}

		});

		Button ba3 = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba3.setPrefHeight(61);
		ba3.setPrefWidth(106);
		ba3.setTextFill(Color.BLACK);
		ba3.setStyle("-fx-background-color: #ffffff");
		ba3.setFont(Font.font("Oranienbaum", 18));
		ba3.setContentDisplay(ContentDisplay.TOP);
		UpdateMovie.setMargin(ba3, new Insets(30, 0, 0, 130));

		ba3.setOnAction(e -> {
			pri.setScene(MediaPage);
		});

		Button find2 = new Button("Find", new ImageView("/imgs/Search.png"));
		find2.setPrefHeight(61);
		find2.setPrefWidth(106);
		find2.setTextFill(Color.BLACK);
		find2.setStyle("-fx-background-color: #ffffff");
		find2.setFont(Font.font("Oranienbaum", 18));
		find2.setContentDisplay(ContentDisplay.TOP);
		UpdateMovie.setMargin(find2, new Insets(30, 0, 0, 130));

		find2.setOnAction(e -> {
			Media med = obj.findMedia(te1.getText());
			if (med == null) {
				Area.setText("The media dose not Exixt");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				te2.setText("");
				te3.setText("");
				R3.setSelected(false);
				R4.setSelected(false);
				R5.setSelected(false);
				return;

			} else {
				Area.setText("The Media does not Exixt");
			}
			if (med instanceof Movie) {

				te2.setText(med.getTitle());
				te3.setText(String.valueOf(med.getNumCopy()));
				Area.setText("The Media has been found");
				if (med.getRating().equals("DR")) {
					R3.setSelected(true);
				} else if (med.getRating().equals("HR")) {
					R4.setSelected(true);
				} else
					R5.setSelected(true);
			}
		});

		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();
		UpdateMovie.setMargin(com, new Insets(0, 0, 0, 130));

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		combo_box.setLayoutY(26);
		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				UpdateMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				UpdateGmes(pri);
			} else if (combo_box.getValue().equals("Album")) {
				UpdateAlbum(pri);
			}
		});

		UpdateMovie.add(com, 0, 0);
		UpdateMovie.add(l0, 0, 1);
		UpdateMovie.add(la0, 0, 2);
		UpdateMovie.add(l2, 0, 3);
		UpdateMovie.add(l3, 0, 4);
		UpdateMovie.add(lab5, 0, 5);

		UpdateMovie.add(combo_box, 1, 0);
		UpdateMovie.add(te1, 1, 1);
		UpdateMovie.add(te2, 1, 2);
		UpdateMovie.add(te3, 1, 3);
		UpdateMovie.add(R3, 1, 4);
		UpdateMovie.add(R4, 2, 4);
		UpdateMovie.add(R5, 3, 4);
		UpdateMovie.add(Area, 1, 5);

		UpdateMovie.add(ba3, 2, 6);
		UpdateMovie.add(Add2, 1, 6);
		UpdateMovie.add(find2, 0, 6);
		UpdateMovie.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, UpdateMovie);
		UpdateMovieMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(UpdateMovieMedia);
		pri.show();

	}

	private void UpdateAlbum(Stage pri) {
		StackPane st17 = new StackPane();
		Image mh17 = new Image("/imgs/main.jpg");
		ImageView mah17 = new ImageView(mh17);
		mah17.setFitHeight(1050);
		mah17.setFitWidth(1920);

		GridPane UpdateAlbum = new GridPane();
		Label lab = new Label();
		lab.setText("Code :");
		lab.setPrefHeight(57);
		lab.setPrefWidth(177);
		lab.setFont(Font.font("Oranienbaum", 18));
		lab.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(lab, new Insets(30, 0, 0, 130));

		Label lab2 = new Label();
		lab2.setText("Media Tital :");
		lab2.setPrefHeight(57);
		lab2.setPrefWidth(177);
		lab2.setFont(Font.font("Oranienbaum", 18));
		lab2.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(lab2, new Insets(30, 0, 0, 130));

		Label lab3 = new Label();
		lab3.setText("Number of Copies :");
		lab3.setPrefHeight(57);
		lab3.setPrefWidth(177);
		lab3.setFont(Font.font("Oranienbaum", 18));
		lab3.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(lab3, new Insets(30, 0, 0, 130));

		Label lab4 = new Label();
		lab4.setText("Songs :");
		lab4.setPrefHeight(57);
		lab4.setPrefWidth(177);
		lab4.setFont(Font.font("Oranienbaum", 18));
		lab4.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(lab4, new Insets(30, 0, 0, 130));

		Label lab5 = new Label();
		lab5.setText("Artict :");
		lab5.setPrefHeight(57);
		lab5.setPrefWidth(177);
		lab5.setFont(Font.font("Oranienbaum", 18));
		lab5.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(lab5, new Insets(30, 0, 0, 130));

		Label lab6 = new Label();
		lab6.setText("The Messege is :");
		lab6.setPrefHeight(37);
		lab6.setPrefWidth(125);
		lab6.setFont(Font.font("Oranienbaum", 16));
		lab6.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(lab6, new Insets(30, 0, 0, 130));

		TextField text = new TextField();
		text.setPrefHeight(25);
		text.setPrefWidth(195);
		UpdateAlbum.setMargin(text, new Insets(30, 0, 0, 0));

		TextField text1 = new TextField();
		text1.setPrefHeight(25);
		text1.setPrefWidth(195);
		UpdateAlbum.setMargin(text1, new Insets(30, 0, 0, 0));

		TextField text2 = new TextField();
		text2.setPrefHeight(25);
		text2.setPrefWidth(195);
		text2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
		UpdateAlbum.setMargin(text2, new Insets(30, 0, 0, 0));

		TextField text3 = new TextField();
		text3.setPrefHeight(25);
		text3.setPrefWidth(195);
		text2.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

		UpdateAlbum.setMargin(text3, new Insets(30, 0, 0, 0));

		TextField text4 = new TextField();
		text4.setPrefHeight(25);
		text4.setPrefWidth(195);
		UpdateAlbum.setMargin(text4, new Insets(30, 0, 0, 0));

		TextArea Area = new TextArea();
		Area.setPrefHeight(27);
		Area.setPrefWidth(200);
		Area.setEditable(false);

		Button Add = new Button("Find", new ImageView("/imgs/Search.png"));
		Add.setPrefHeight(61);
		Add.setPrefWidth(106);
		Add.setTextFill(Color.BLACK);
		Add.setStyle("-fx-background-color: #ffffff");
		Add.setFont(Font.font("Oranienbaum", 18));
		Add.setContentDisplay(ContentDisplay.TOP);
		UpdateAlbum.setMargin(Add, new Insets(30, 0, 0, 130));

		Add.setOnAction(e -> {
//			for (int i = 0; i < obj.media.size(); i++) {
//				if (obj.media.get(i).getCode().equals(text.getText())) {
//					text1.setText(obj.media.get(i).getTitle());
//					text2.setText(String.valueOf(obj.media.get(i).getNumCopy()));
//					text3.setText(obj.media.get(i).getSongs());
//					text4.setText(obj.media.get(i).getArtist());
//					Area.setText("The Media has been found");
//				}
//				else {
//					Area.setText("The Media dose not exixt");
//					Area.setStyle("-fx-text-inner-color: #ff0000");
//
//					text1.setText("");
//					text2.setText("");
//					text3.setText("");
//					text4.setText("");
//				}
//					
//			}

			boolean med = obj.CheackMedia(text.getText());
			if (med == false) {
				Area.setText("The Media dose not exist ");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
			} else {
				Area.setText("The Media has been found");
			}
			for (int i = 0; i < obj.media.size(); i++) {
				if (obj.media.get(i).getCode().equals(text.getText())) {
					if (obj.media.get(i) instanceof Album) {
						text1.setText(obj.media.get(i).getTitle());
						text2.setText(String.valueOf(obj.media.get(i).getNumCopy()));
						text3.setText(obj.media.get(i).getSongs());
						text4.setText(obj.media.get(i).getArtist());
					} else {
						Area.setText("The Media dose not exist ");
						Area.setStyle("-fx-text-inner-color: #ff0000");
					}
				}
			}

		});

		Button Add1 = new Button("Update", new ImageView("/imgs/Updates.png"));
		Add1.setPrefHeight(61);
		Add1.setPrefWidth(106);
		Add1.setTextFill(Color.BLACK);
		Add1.setStyle("-fx-background-color: #ffffff");
		Add1.setFont(Font.font("Oranienbaum", 18));
		Add1.setContentDisplay(ContentDisplay.TOP);
		UpdateAlbum.setMargin(Add1, new Insets(30, 0, 0, 55));

		Add1.setOnAction(e -> {
			try {
				obj.UpdateAlbum(text1.getText(), Integer.parseInt(text2.getText()), text.getText(), text4.getText(),
						text3.getText());

				text.setText("");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				Area.setText("The Media has been Update ");
			} catch (Exception mo) {
				Area.setText("You must import a number ");
				Area.setStyle("-fx-text-inner-color: #ff0000");
				text2.setText("");
			}
		});

		Button ba = new Button("Back", new ImageView("/imgs/Backe.png"));
		ba.setPrefHeight(61);
		ba.setPrefWidth(106);
		ba.setTextFill(Color.BLACK);
		ba.setStyle("-fx-background-color: #ffffff");
		ba.setFont(Font.font("Oranienbaum", 18));
		ba.setContentDisplay(ContentDisplay.TOP);
		UpdateAlbum.setMargin(ba, new Insets(30, 0, 0, 130));

		ba.setOnAction(e -> {

			pri.setScene(MediaPage);
		});
		ComboBox combo_box = new ComboBox();
		combo_box.getItems().addAll("Game", "Album", "Movie");
		Label com = new Label();

		com.setText("Enter your Media :");
		com.setPrefHeight(30);
		com.setPrefWidth(156);
		com.setFont(Font.font("Oranienbaum", 18));
		com.setTextFill(Color.WHITE);
		UpdateAlbum.setMargin(com, new Insets(0, 0, 0, 130));

		combo_box.setPrefHeight(25);
		combo_box.setPrefWidth(150);
		combo_box.setOnAction(e -> {
			if (combo_box.getValue().equals("Movie")) {
				UpdateMovie(pri);
			} else if (combo_box.getValue().equals("Game")) {
				UpdateGmes(pri);
			} else if (combo_box.getValue().equals("Album")) {
				UpdateAlbum(pri);
			}
		});

		UpdateAlbum.add(com, 0, 0);
		UpdateAlbum.add(lab, 0, 1);
		UpdateAlbum.add(lab2, 0, 2);
		UpdateAlbum.add(lab3, 0, 3);
		UpdateAlbum.add(lab4, 0, 4);
		UpdateAlbum.add(lab5, 0, 5);
		UpdateAlbum.add(lab6, 0, 6);

		UpdateAlbum.add(combo_box, 1, 0);
		UpdateAlbum.add(text, 1, 1);
		UpdateAlbum.add(text1, 1, 2);
		UpdateAlbum.add(text2, 1, 3);
		UpdateAlbum.add(text3, 1, 4);
		UpdateAlbum.add(text4, 1, 5);
		UpdateAlbum.add(Area, 1, 6);

		UpdateAlbum.add(Add, 0, 7);
		UpdateAlbum.add(ba, 2, 7);
		UpdateAlbum.add(Add1, 1, 7);
		UpdateAlbum.setAlignment(Pos.CENTER);

		st17.getChildren().addAll(mah17, UpdateAlbum);
		UpdateAlbumMedia = new Scene(st17, screenSize.getWidth(), screenSize.getHeight());
		pri.setScene(UpdateAlbumMedia);
		pri.show();
	}

	MediaRentalManger obj = new MediaRentalManger();

	Scene mainPage, customerPage, MediaPage, RentPage, AddCustomersPage, DeletPage, SearchPage, UpdatePage,
			AddMediaPage, UpdateMediaPage, SearchMediaPage, DeleteMediaPage, AddCartPage, RetrnPage, AddMovieMedia,
			AddGameMedia, AddAlnumMedia, DeleteGameMedia, DeleteMovieMedia, DeleteAlbumMedia, UpdateMovieMedia,
			UpdateGameMedia, UpdateAlbumMedia, AllInfoPage, PrintCartPage, PrintRentPage;

	Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

	@Override
	public void start(Stage primaryStage) {
		obj.readCustomerdata(obj.customer);
		try {
//================================== main page =====================================	

			StackPane st = new StackPane();
			Image mh = new Image("main.jpg");
			ImageView mah = new ImageView(mh);
			mah.setFitHeight(1050);
			mah.setFitWidth(1920);

			GridPane g = new GridPane();
			Button b1 = new Button("Customer", new ImageView("cus.png"));
			b1.setPrefWidth(150);
			b1.setPrefHeight(60);
			b1.setContentDisplay(ContentDisplay.TOP);
			b1.setFont(Font.font("Oranienbaum", 14));
			b1.setOnAction(e -> {
				primaryStage.setScene(customerPage);
			//	obj.readCustomerdata(obj.customer);

			});

			g.setMargin(b1, new Insets(20, 20, 20, 60));
			g.add(b1, 1, 0);
			Button b2 = new Button("Media", new ImageView("med1.png"));
			b2.setPrefWidth(150);
			b2.setPrefHeight(60);
			b2.setContentDisplay(ContentDisplay.TOP);
			b2.setFont(Font.font("Oranienbaum", 14));
			b2.setOnAction(e -> {
				primaryStage.setScene(MediaPage);
				obj.readGameData(obj.media);
				obj.readMovieData(obj.media);
				obj.readAlbumData(obj.media);

			});
			g.setMargin(b2, new Insets(20, 20, 20, 60));
			g.add(b2, 1, 1);
			Button b3 = new Button("Rent", new ImageView("rent.png"));
			b3.setPrefWidth(150);
			b3.setPrefHeight(60);
			b3.setContentDisplay(ContentDisplay.TOP);
			b3.setFont(Font.font("Oranienbaum", 14));
			b3.setOnAction(e -> {
				primaryStage.setScene(RentPage);

			});

			Button save = new Button("Save Data", new ImageView("save1.png"));
			save.setPrefWidth(40);
			save.setPrefHeight(40);
			save.setContentDisplay(ContentDisplay.TOP);
			save.setFont(Font.font("Oranienbaum", 10));
			save.setOnAction(e -> {
				obj.saveCustomerdate();
				obj.saveGameData();
				obj.saveMovieData();
				obj.saveAlbumData();
				obj.saveIntersted_RentedData();

			});

			g.setMargin(b3, new Insets(20, 20, 20, 60));
			g.add(b3, 1, 2);
			Label leb = new Label();
			leb.setText("Rental Media System");
			leb.setPrefWidth(400);
			leb.setPrefHeight(100);
			leb.setFont(Font.font("Oranienbaum", 28));
			g.setMargin(leb, new Insets(30, 0, 30, 20));
			g.add(leb, 1, 3);
			g.add(save, 3, 4);

			g.setAlignment(Pos.CENTER);

			g.add(new ImageView("mn.png"), 2, 1);
			g.add(new ImageView("mn1.png"), 0, 1);

			st.getChildren().addAll(mah, g);
			mainPage = new Scene(st, screenSize.getWidth(), screenSize.getHeight());
//======================== Customer page ==============================

			StackPane st1 = new StackPane();
			Image mh1 = new Image("/main.jpg");
			ImageView mah1 = new ImageView(mh1);
			mah1.setFitHeight(1050);
			mah1.setFitWidth(1920);

			GridPane customerpane = new GridPane();

			Button addCustomer = new Button("Add Customer", new ImageView("AddCustomer.png"));
			addCustomer.setPrefHeight(60);
			addCustomer.setPrefWidth(184);
			addCustomer.setTextFill(Color.BLACK);
			addCustomer.setStyle("-fx-background-color: #ffffff");
			addCustomer.setFont(Font.font("Oranienbaum", 18));
			addCustomer.setContentDisplay(ContentDisplay.TOP);
			customerpane.setMargin(addCustomer, new Insets(65, 30, 30, 150));
			addCustomer.setOnAction(e -> {
				primaryStage.setScene(AddCustomersPage);
			});

			Button Back = new Button("Back", new ImageView("Backe.png"));

			Back.setPrefHeight(60);
			Back.setPrefWidth(184);
			Back.setTextFill(Color.BLACK);
			Back.setStyle("-fx-background-color: #ffffff");
			Back.setFont(Font.font("Oranienbaum", 18));
			Back.setContentDisplay(ContentDisplay.TOP);
			customerpane.setMargin(Back, new Insets(65, 30, 30, 0));
			Back.setAlignment(Pos.CENTER);
			Back.setOnAction(e -> {
				primaryStage.setScene(mainPage);

			});

			Button Updet = new Button("Update Customer", new ImageView("UpdateCustomer.png"));

			Updet.setPrefHeight(60);
			Updet.setPrefWidth(184);
			Updet.setTextFill(Color.BLACK);
			Updet.setStyle("-fx-background-color: #ffffff");
			Updet.setFont(Font.font("Oranienbaum", 18));
			Updet.setContentDisplay(ContentDisplay.TOP);
			customerpane.setMargin(Updet, new Insets(65, 30, 30, 150));
			Updet.setOnAction(e -> {
				primaryStage.setScene(UpdatePage);
			});

			Button Search = new Button("Search Customer ID", new ImageView("Search.png"));

			Search.setPrefHeight(60);
			Search.setPrefWidth(184);
			Search.setTextFill(Color.BLACK);
			Search.setStyle("-fx-background-color: #ffffff");
			Search.setFont(Font.font("Oranienbaum", 18));
			Search.setContentDisplay(ContentDisplay.TOP);
			customerpane.setMargin(Search, new Insets(65, 30, 30, 150));
			Search.setOnAction(e -> {
				primaryStage.setScene(SearchPage);
			});

			Button Delet = new Button("Delete Customer", new ImageView("DeleteCustomer.png"));

			Delet.setPrefHeight(60);
			Delet.setPrefWidth(184);
			Delet.setTextFill(Color.BLACK);
			Delet.setStyle("-fx-background-color: #ffffff");
			Delet.setFont(Font.font("Oranienbaum", 18));
			Delet.setContentDisplay(ContentDisplay.TOP);
			customerpane.setMargin(Delet, new Insets(65, 30, 30, 150));
			Delet.setOnAction(e -> {
				primaryStage.setScene(DeletPage);
			});
			customerpane.add(Delet, 1, 1);
			customerpane.add(Search, 1, 0);
			customerpane.add(Updet, 0, 1);
			customerpane.add(addCustomer, 0, 0);
			customerpane.add(Back, 1, 2);
			customerpane.setAlignment(Pos.CENTER);

			st1.getChildren().addAll(mah1, customerpane);

			customerPage = new Scene(st1, screenSize.getWidth(), screenSize.getHeight());

// ==========================Media========================

			StackPane st2 = new StackPane();
			Image mh2 = new Image("main.jpg");
			ImageView mah2 = new ImageView(mh2);
			mah2.setFitHeight(1050);
			mah2.setFitWidth(1920);

			GridPane mediapane = new GridPane();
			Button added = new Button("Add Media", new ImageView("AddMedia.png"));
			added.setPrefHeight(60);
			added.setPrefWidth(184);
			added.setTextFill(Color.BLACK);
			added.setStyle("-fx-background-color: #ffffff");
			added.setFont(Font.font("Oranienbaum", 18));
			added.setContentDisplay(ContentDisplay.TOP);
			mediapane.setMargin(added, new Insets(65, 30, 30, 150));
			added.setOnAction(e -> {
				primaryStage.setScene(AddMediaPage);
			});

			Button upd = new Button("Update Media", new ImageView("Update.png"));
			upd.setPrefHeight(60);
			upd.setPrefWidth(184);
			upd.setTextFill(Color.BLACK);
			upd.setStyle("-fx-background-color: #ffffff");
			upd.setFont(Font.font("Oranienbaum", 18));
			upd.setContentDisplay(ContentDisplay.TOP);
			mediapane.setMargin(upd, new Insets(65, 30, 30, 150));
			upd.setOnAction(e -> {
				primaryStage.setScene(UpdateMediaPage);
			});

			Button ser = new Button("Serch Media", new ImageView("Search.png"));
			ser.setPrefHeight(60);
			ser.setPrefWidth(184);
			ser.setTextFill(Color.BLACK);
			ser.setStyle("-fx-background-color: #ffffff");
			ser.setFont(Font.font("Oranienbaum", 18));
			ser.setContentDisplay(ContentDisplay.TOP);
			mediapane.setMargin(ser, new Insets(65, 30, 30, 150));
			ser.setOnAction(e -> {
				primaryStage.setScene(SearchMediaPage);
			});

			Button Del = new Button("Delete Media", new ImageView("delete.png"));
			Del.setPrefHeight(60);
			Del.setPrefWidth(184);
			Del.setTextFill(Color.BLACK);
			Del.setStyle("-fx-background-color: #ffffff");
			Del.setFont(Font.font("Oranienbaum", 18));
			Del.setContentDisplay(ContentDisplay.TOP);
			mediapane.setMargin(Del, new Insets(65, 30, 30, 150));
			Del.setOnAction(e -> {
				primaryStage.setScene(DeleteMediaPage);
			});

			Button print = new Button("Print All Information", new ImageView("PrintAll.png"));
			print.setPrefHeight(60);
			print.setPrefWidth(190);
			print.setTextFill(Color.BLACK);
			print.setStyle("-fx-background-color: #ffffff");
			print.setFont(Font.font("Oranienbaum", 18));
			print.setContentDisplay(ContentDisplay.TOP);
			mediapane.setMargin(print, new Insets(65, 30, 30, 150));
			print.setOnAction(e -> {
				primaryStage.setScene(AllInfoPage);
			});
			Button back = new Button("Back", new ImageView("Backe.png"));
			back.setPrefHeight(60);
			back.setPrefWidth(184);
			back.setTextFill(Color.BLACK);
			back.setStyle("-fx-background-color: #ffffff");
			back.setFont(Font.font("Oranienbaum", 18));
			back.setContentDisplay(ContentDisplay.TOP);
			mediapane.setMargin(back, new Insets(65, 30, 30, 150));
			back.setOnAction(e -> {
				primaryStage.setScene(mainPage);
			});
			mediapane.add(back, 1, 2);
			mediapane.add(print, 0, 2);
			mediapane.add(Del, 0, 1);
			mediapane.add(ser, 1, 1);
			mediapane.add(added, 0, 0);
			mediapane.add(upd, 1, 0);

			mediapane.setAlignment(Pos.CENTER);

			st2.getChildren().addAll(mah2, mediapane);
			MediaPage = new Scene(st2, screenSize.getWidth(), screenSize.getHeight());
//================================Rent================
			StackPane st3 = new StackPane();
			Image mh3 = new Image("main.jpg");
			ImageView mah3 = new ImageView(mh3);
			mah3.setFitHeight(1050);
			mah3.setFitWidth(1920);

			GridPane Rentpane = new GridPane();

			Button AddCart = new Button("Add to Cart", new ImageView("AddCart.png"));
			AddCart.setPrefHeight(60);
			AddCart.setPrefWidth(184);
			AddCart.setTextFill(Color.BLACK);
			AddCart.setStyle("-fx-background-color: #ffffff");
			AddCart.setFont(Font.font("Oranienbaum", 18));
			AddCart.setContentDisplay(ContentDisplay.TOP);
			Rentpane.setMargin(AddCart, new Insets(65, 30, 30, 150));
			AddCart.setOnAction(e -> {
				primaryStage.setScene(AddCartPage);
			});

			Button Back1 = new Button("Back", new ImageView("Backe.png"));
			Back1.setPrefHeight(60);
			Back1.setPrefWidth(184);
			Back1.setTextFill(Color.BLACK);
			Back1.setStyle("-fx-background-color: #ffffff");
			Back1.setFont(Font.font("Oranienbaum", 18));
			Back1.setContentDisplay(ContentDisplay.TOP);

			Rentpane.setMargin(Back1, new Insets(65, 30, 30, 0));
			Back1.setOnAction(e -> {
				primaryStage.setScene(mainPage);
			});

			Button Updete = new Button("Print Rent", new ImageView("PrintAll.png"));
			Updete.setPrefHeight(60);
			Updete.setPrefWidth(184);
			Updete.setTextFill(Color.BLACK);
			Updete.setStyle("-fx-background-color: #ffffff");
			Updete.setFont(Font.font("Oranienbaum", 18));
			Updete.setContentDisplay(ContentDisplay.TOP);
			Rentpane.setMargin(Updete, new Insets(65, 30, 30, 150));
			Updete.setOnAction(e -> {
				primaryStage.setScene(PrintRentPage);
			});

			Button Search1 = new Button("Print Cart", new ImageView("PrintAll.png"));
			Search1.setPrefHeight(60);
			Search1.setPrefWidth(184);
			Search1.setTextFill(Color.BLACK);
			Search1.setStyle("-fx-background-color: #ffffff");
			Search1.setFont(Font.font("Oranienbaum", 18));
			Search1.setContentDisplay(ContentDisplay.TOP);
			Rentpane.setMargin(Search1, new Insets(65, 30, 30, 150));
			Search1.setOnAction(e -> {
				primaryStage.setScene(PrintCartPage);
			});
			Button Return = new Button("Return Media", new ImageView("ReturnMedia.png"));
			Return.setPrefHeight(60);
			Return.setPrefWidth(184);
			Return.setTextFill(Color.BLACK);
			Return.setStyle("-fx-background-color: #ffffff");
			Return.setFont(Font.font("Oranienbaum", 18));
			Return.setContentDisplay(ContentDisplay.TOP);
			Rentpane.setMargin(Return, new Insets(65, 30, 30, 150));
			Return.setOnAction(e -> {
				primaryStage.setScene(RetrnPage);
			});

			Rentpane.add(Back1, 1, 2);
			Rentpane.add(Return, 0, 1);
			Rentpane.add(Search1, 1, 1);
			Rentpane.add(AddCart, 0, 0);
			Rentpane.add(Updete, 1, 0);

			Rentpane.setAlignment(Pos.CENTER);

			st3.getChildren().addAll(mah3, Rentpane);
			RentPage = new Scene(st3, screenSize.getWidth(), screenSize.getHeight());
//========================================AddCustomer======================
			StackPane st4 = new StackPane();
			Image mh4 = new Image("main.jpg");
			ImageView mah4 = new ImageView(mh4);
			mah4.setFitHeight(1050);
			mah4.setFitWidth(1920);

			GridPane AddCstomer = new GridPane();
			Label lab = new Label();
			lab.setText("Customer ID :");
			lab.setPrefHeight(113);
			lab.setPrefWidth(227);
			lab.setFont(Font.font("Oranienbaum", 24));
			lab.setTextFill(Color.WHITE);
			AddCstomer.setMargin(lab, new Insets(0, 0, 0, 130));

			Label lab2 = new Label();
			lab2.setText("Customer Name :");
			lab2.setPrefHeight(113);
			lab2.setPrefWidth(227);
			lab2.setFont(Font.font("Oranienbaum", 24));
			lab2.setTextFill(Color.WHITE);
			AddCstomer.setMargin(lab2, new Insets(0, 0, 0, 130));

			Label lab3 = new Label();
			lab3.setText("Customer Addrees :");
			lab3.setPrefHeight(113);
			lab3.setPrefWidth(227);
			lab3.setFont(Font.font("Oranienbaum", 24));
			lab3.setTextFill(Color.WHITE);
			AddCstomer.setMargin(lab3, new Insets(0, 0, 0, 130));

			Label lab4 = new Label();
			lab4.setText("Customer Mobile :");
			lab4.setPrefHeight(113);
			lab4.setPrefWidth(227);
			lab4.setFont(Font.font("Oranienbaum", 24));
			lab4.setTextFill(Color.WHITE);
			AddCstomer.setMargin(lab4, new Insets(0, 0, 0, 130));

			Label labm = new Label();
			labm.setText("Customer Plan :");
			labm.setPrefHeight(113);
			labm.setPrefWidth(227);
			labm.setFont(Font.font("Oranienbaum", 24));
			labm.setTextFill(Color.WHITE);
			AddCstomer.setMargin(labm, new Insets(0, 0, 0, 130));

			Label labn = new Label();
			labn.setText("The Messege is  :");
			labn.setPrefHeight(17);
			labn.setPrefWidth(181);
			labn.setFont(Font.font("Oranienbaum", 18));
			labn.setTextFill(Color.WHITE);
			AddCstomer.setMargin(labn, new Insets(0, 0, 0, 130));

			ToggleGroup TGG = new ToggleGroup();
			RadioButton R1 = new RadioButton("LIMITED");
			R1.setFont(Font.font("Oranienbaum", 14));
			RadioButton R2 = new RadioButton("UNLIMITED");
			R2.setFont(Font.font("Oranienbaum", 14));

			R1.setToggleGroup(TGG);
			R2.setToggleGroup(TGG);

			TextField text = new TextField();
			text.setPrefHeight(25);
			text.setPrefWidth(195);

			TextField text1 = new TextField();
			text1.setPrefHeight(25);
			text1.setPrefWidth(195);

			TextField text2 = new TextField();
			text2.setPrefHeight(25);
			text2.setPrefWidth(195);

			TextField text3 = new TextField();
			text3.setPrefHeight(25);
			text3.setPrefWidth(195);

			TextArea tr = new TextArea();
			tr.setPrefHeight(25);
			tr.setPrefWidth(195);
			tr.setEditable(false);
			AddCstomer.setMargin(tr, new Insets(0, 0, 0, 130));

			Button Add = new Button("Add", new ImageView("Add.png"));
			Add.setPrefHeight(61);
			Add.setPrefWidth(106);
			Add.setTextFill(Color.BLACK);
			Add.setStyle("-fx-background-color: #ffffff");
			Add.setFont(Font.font("Oranienbaum", 18));
			Add.setContentDisplay(ContentDisplay.TOP);
			AddCstomer.setMargin(Add, new Insets(30, 0, 0, 130));
			Add.setOnAction(e -> {
				RadioButton sel = (RadioButton) TGG.getSelectedToggle();
				String val = sel.getText();

				if (obj.CheckId(text.getText()) == true) {
					tr.setText("The Customer is exiting ");

				} else {

					obj.addCustomer(text1.getText(), text2.getText(), val, text.getText(), text3.getText());
					tr.setText("Added successfully");
					text.setText("");
					text1.setText("");
					text2.setText("");
					text3.setText("");
					R1.setSelected(false);
					R2.setSelected(false);
				}

			});

			Button ba = new Button("Back", new ImageView("Backe.png"));
			ba.setPrefHeight(61);
			ba.setPrefWidth(106);
			ba.setTextFill(Color.BLACK);
			ba.setStyle("-fx-background-color: #ffffff");
			ba.setFont(Font.font("Oranienbaum", 18));
			ba.setContentDisplay(ContentDisplay.TOP);
			AddCstomer.setMargin(ba, new Insets(30, 0, 0, 130));
			ba.setOnAction(e -> {
				primaryStage.setScene(customerPage);
			});
			AddCstomer.add(lab, 0, 0);
			AddCstomer.add(lab2, 0, 1);
			AddCstomer.add(lab3, 0, 2);
			AddCstomer.add(lab4, 0, 3);
			AddCstomer.add(labm, 0, 4);
			AddCstomer.add(labn, 0, 5);

			AddCstomer.add(text, 1, 0);
			AddCstomer.add(text1, 1, 1);
			AddCstomer.add(text2, 1, 2);
			AddCstomer.add(text3, 1, 3);
			AddCstomer.add(R2, 1, 4);
			AddCstomer.add(R1, 2, 4);
			AddCstomer.add(tr, 1, 5);
			AddCstomer.add(Add, 0, 6);
			AddCstomer.add(ba, 1, 6);

			AddCstomer.setAlignment(Pos.CENTER);

			st4.getChildren().addAll(mah4, AddCstomer);
			AddCustomersPage = new Scene(st4, screenSize.getWidth(), screenSize.getHeight());
//==================Delete Customer====================
			StackPane st5 = new StackPane();
			Image mh5 = new Image("main.jpg");
			ImageView mah5 = new ImageView(mh5);
			mah5.setFitHeight(1050);
			mah5.setFitWidth(1920);

			GridPane deletepane = new GridPane();
			Label la = new Label();
			la.setText("Customer ID :");
			la.setPrefHeight(113);
			la.setPrefWidth(227);
			la.setFont(Font.font("Oranienbaum", 24));
			la.setTextFill(Color.WHITE);
			deletepane.setMargin(la, new Insets(0, 0, 0, 130));

			Label la2 = new Label();
			la2.setText("Customer Name :");
			la2.setPrefHeight(113);
			la2.setPrefWidth(227);
			la2.setFont(Font.font("Oranienbaum", 24));
			la2.setTextFill(Color.WHITE);
			deletepane.setMargin(la2, new Insets(0, 0, 0, 130));

			Label la3 = new Label();
			la3.setText("Customer Addrees :");
			la3.setPrefHeight(113);
			la3.setPrefWidth(227);
			la3.setFont(Font.font("Oranienbaum", 24));
			la3.setTextFill(Color.WHITE);
			deletepane.setMargin(la3, new Insets(0, 0, 0, 130));

			Label la4 = new Label();
			la4.setText("Customer Mobile :");
			la4.setPrefHeight(113);
			la4.setPrefWidth(227);
			la4.setFont(Font.font("Oranienbaum", 24));
			la4.setTextFill(Color.WHITE);
			deletepane.setMargin(la4, new Insets(0, 0, 0, 130));
			Label la5 = new Label();

			la5.setText("Customer Plan :");
			la5.setPrefHeight(113);
			la5.setPrefWidth(227);
			la5.setFont(Font.font("Oranienbaum", 24));
			la5.setTextFill(Color.WHITE);
			deletepane.setMargin(la5, new Insets(0, 0, 0, 130));

			Label labn1 = new Label();
			labn1.setText("The Messege is  :");
			labn1.setPrefHeight(17);
			labn1.setPrefWidth(181);
			labn1.setFont(Font.font("Oranienbaum", 18));
			labn1.setTextFill(Color.WHITE);
			deletepane.setMargin(labn1, new Insets(0, 0, 0, 130));

			TextField tex = new TextField();
			tex.setPrefHeight(25);
			tex.setPrefWidth(195);

			TextField tex1 = new TextField();
			tex1.setPrefHeight(25);
			tex1.setPrefWidth(195);
			tex1.setEditable(false);

			TextField tex2 = new TextField();
			tex2.setPrefHeight(25);
			tex2.setPrefWidth(195);
			tex2.setEditable(false);

			TextField tex3 = new TextField();
			tex3.setPrefHeight(25);
			tex3.setPrefWidth(195);

			TextArea tr1 = new TextArea();
			tr1.setPrefHeight(25);
			tr1.setPrefWidth(195);
			tr1.setEditable(false);
			deletepane.setMargin(tr1, new Insets(0, 0, 0, 130));

			ToggleGroup TGg = new ToggleGroup();
			RadioButton R3 = new RadioButton("LIMITED");
			R3.setFont(Font.font(14));
			R3.setToggleGroup(TGg);

			RadioButton R4 = new RadioButton("UNLIMITED");
			R4.setFont(Font.font(14));
			R4.setToggleGroup(TGg);

			Button Add1 = new Button("Delete", new ImageView("Remove.png"));
			Add1.setPrefHeight(61);
			Add1.setPrefWidth(106);
			Add1.setTextFill(Color.BLACK);
			Add1.setStyle("-fx-background-color: #ffffff");
			Add1.setFont(Font.font("Oranienbaum", 18));
			Add1.setContentDisplay(ContentDisplay.TOP);
			deletepane.setMargin(Add1, new Insets(30, 0, 0, 130));
			Add1.setOnAction(e -> {
				obj.DeleteCustomer(tex.getText());
				tex.setText("");
				tex1.setText("");
				tex2.setText("");
				tex3.setText("");
				R3.setSelected(false);
				R4.setSelected(false);
				tr1.setText("The Customer has been Delete ");

			});

			Button ba1 = new Button("Back", new ImageView("Backe.png"));
			ba1.setPrefHeight(61);
			ba1.setPrefWidth(106);
			ba1.setTextFill(Color.BLACK);
			ba1.setStyle("-fx-background-color: #ffffff");
			ba1.setFont(Font.font("Oranienbaum", 18));
			ba1.setContentDisplay(ContentDisplay.TOP);
			deletepane.setMargin(ba1, new Insets(30, 0, 0, 130));
			ba1.setOnAction(e -> {
				primaryStage.setScene(customerPage);
			});

			Button find = new Button("Find", new ImageView("Search.png"));
			find.setPrefHeight(61);
			find.setPrefWidth(106);
			find.setTextFill(Color.BLACK);
			find.setStyle("-fx-background-color: #ffffff");
			find.setFont(Font.font("Oranienbaum", 18));
			find.setContentDisplay(ContentDisplay.TOP);
			deletepane.setMargin(find, new Insets(30, 0, 0, 130));
			find.setOnAction(e -> {
				boolean cus = obj.CheckId(tex.getText());
				if (cus == false) {
					tr1.setText("The Customer does not Existing");
					tr1.setStyle("-fx-text-inner-color: #ff0000");
				} else {
					tr1.setText("The Customer is Existing");
				}
				for (int i = 0; i < obj.customer.size(); i++) {
					if (obj.customer.get(i).getID().equals(tex.getText())) {
						tex1.setText(obj.customer.get(i).getName());
						tex2.setText(obj.customer.get(i).getAddress());
						tex3.setText(obj.customer.get(i).getMobileNimber());
						if (obj.customer.get(i).getPlan().equals("LIMITED")) {
							R3.setSelected(true);
						} else {
							R4.setSelected(true);
						}
					}
				}

			});

			deletepane.add(la, 0, 0);
			deletepane.add(la2, 0, 1);
			deletepane.add(la3, 0, 2);
			deletepane.add(la4, 0, 3);
			deletepane.add(la5, 0, 4);
			deletepane.add(labn1, 0, 5);

			deletepane.add(tex, 1, 0);
			deletepane.add(tex1, 1, 1);
			deletepane.add(tex2, 1, 2);
			deletepane.add(tex3, 1, 3);
			deletepane.add(R4, 1, 4);
			deletepane.add(R3, 2, 4);
			deletepane.add(tr1, 1, 5);

			deletepane.add(Add1, 1, 6);
			deletepane.add(ba1, 2, 6);
			deletepane.add(find, 0, 6);
			deletepane.setAlignment(Pos.CENTER);

			st5.getChildren().addAll(mah5, deletepane);
			DeletPage = new Scene(st5, screenSize.getWidth(), screenSize.getHeight());
//==========================Search=============================================
			StackPane st6 = new StackPane();
			Image mh6 = new Image("main.jpg");
			ImageView mah6 = new ImageView(mh6);
			mah6.setFitHeight(1050);
			mah6.setFitWidth(1920);

			GridPane Searchpane = new GridPane();

			Label lan = new Label();
			lan.setText("Customer ID :");
			lan.setPrefHeight(113);
			lan.setPrefWidth(227);
			lan.setFont(Font.font("Oranienbaum", 24));
			lan.setTextFill(Color.WHITE);
			Searchpane.setMargin(lan, new Insets(0, 0, 0, 130));

			Label lan1 = new Label();
			lan1.setText("Customer Name :");
			lan1.setPrefHeight(113);
			lan1.setPrefWidth(227);
			lan1.setFont(Font.font("Oranienbaum", 24));
			lan1.setTextFill(Color.WHITE);
			Searchpane.setMargin(lan1, new Insets(0, 0, 0, 130));

			Label lan2 = new Label();
			lan2.setText("Customer Addrees :");
			lan2.setPrefHeight(113);
			lan2.setPrefWidth(227);
			lan2.setFont(Font.font("Oranienbaum", 24));
			lan2.setTextFill(Color.WHITE);
			Searchpane.setMargin(lan2, new Insets(0, 0, 0, 130));

			Label lan3 = new Label();
			lan3.setText("Customer Mobile :");
			lan3.setPrefHeight(113);
			lan3.setPrefWidth(227);
			lan3.setFont(Font.font("Oranienbaum", 24));
			lan3.setTextFill(Color.WHITE);
			Searchpane.setMargin(lan3, new Insets(0, 0, 0, 130));

			Label lan4 = new Label();
			lan4.setText("Customer Plan :");
			lan4.setPrefHeight(113);
			lan4.setPrefWidth(227);
			lan4.setFont(Font.font("Oranienbaum", 24));
			lan4.setTextFill(Color.WHITE);
			Searchpane.setMargin(lan4, new Insets(0, 0, 0, 130));

			Label labn2 = new Label();
			labn2.setText("The Messege is  :");
			labn2.setPrefHeight(17);
			labn2.setPrefWidth(181);
			labn2.setFont(Font.font("Oranienbaum", 18));
			labn2.setTextFill(Color.WHITE);
			Searchpane.setMargin(labn2, new Insets(0, 0, 0, 130));

			TextField texn = new TextField();
			texn.setPrefHeight(25);
			texn.setPrefWidth(195);

			TextField texn1 = new TextField();
			texn1.setPrefHeight(25);
			texn1.setPrefWidth(195);
			texn1.setEditable(false);

			TextField texn2 = new TextField();
			texn2.setPrefHeight(25);
			texn2.setPrefWidth(195);
			texn2.setEditable(false);

			TextField texn3 = new TextField();
			texn3.setPrefHeight(25);
			texn3.setPrefWidth(195);
			texn3.setEditable(false);

			TextArea tr2 = new TextArea();
			tr2.setPrefHeight(25);
			tr2.setPrefWidth(195);
			tr2.setEditable(false);

			ToggleGroup TGgg = new ToggleGroup();
			RadioButton R8 = new RadioButton("LIMITED");
			R8.setFont(Font.font("Oranienbaum", 14));
			R8.setToggleGroup(TGgg);

			RadioButton R9 = new RadioButton("UNLIMITED");
			R9.setFont(Font.font("Oranienbaum", 14));
			R9.setToggleGroup(TGgg);

			Button Add13 = new Button("Clear", new ImageView("UpdateCustomer.png"));
			Add13.setPrefHeight(61);
			Add13.setPrefWidth(106);
			Add13.setTextFill(Color.BLACK);
			Add13.setStyle("-fx-background-color: #ffffff");
			Add13.setFont(Font.font("Oranienbaum", 18));
			Add13.setContentDisplay(ContentDisplay.TOP);
			Searchpane.setMargin(Add13, new Insets(30, 0, 0, 55));
			Add13.setOnAction(e -> {
				texn1.setText("");
				texn2.setText("");
				texn3.setText("");
				R8.setSelected(false);
				R9.setSelected(false);

			});

			Button ba12 = new Button("Back", new ImageView("Backe.png"));
			ba12.setPrefHeight(61);
			ba12.setPrefWidth(106);
			ba12.setTextFill(Color.BLACK);
			ba12.setStyle("-fx-background-color: #ffffff");
			ba12.setFont(Font.font("Oranienbaum", 18));
			ba12.setContentDisplay(ContentDisplay.TOP);
			Searchpane.setMargin(ba12, new Insets(30, 0, 0, 130));
			ba12.setOnAction(e -> {
				primaryStage.setScene(customerPage);
			});

			Button find23 = new Button("Find", new ImageView("Search.png"));
			find23.setPrefHeight(61);
			find23.setPrefWidth(106);
			find23.setTextFill(Color.BLACK);
			find23.setStyle("-fx-background-color: #ffffff");
			find23.setFont(Font.font("Oranienbaum", 18));
			find23.setContentDisplay(ContentDisplay.TOP);
			Searchpane.setMargin(find23, new Insets(30, 0, 0, 130));
			find23.setOnAction(e -> {

				boolean cus = obj.CheckId(texn.getText());
				if (cus == false) {
					tr2.setText("The Customer does not Existing");
					tr2.setStyle("-fx-text-inner-color: #ff0000");
				} else {
					tr2.setText("The Customer is Existing");
				}
				for (int i = 0; i < obj.customer.size(); i++) {
					if (obj.customer.get(i).getID().equals(texn.getText())) {
						texn1.setText(obj.customer.get(i).getName());
						texn2.setText(obj.customer.get(i).getAddress());
						texn3.setText(obj.customer.get(i).getMobileNimber());
						if (obj.customer.get(i).getPlan().equals("LIMITED")) {
							R8.setSelected(true);
						} else {
							R9.setSelected(true);
						}

					}
				}

			});

			Searchpane.add(lan, 0, 0);
			Searchpane.add(lan1, 0, 1);
			Searchpane.add(lan2, 0, 2);
			Searchpane.add(lan3, 0, 3);
			Searchpane.add(lan4, 0, 4);
			Searchpane.add(labn2, 0, 5);

			Searchpane.add(texn, 1, 0);
			Searchpane.add(texn1, 1, 1);
			Searchpane.add(texn2, 1, 2);
			Searchpane.add(texn3, 1, 3);
			Searchpane.add(R8, 1, 4);
			Searchpane.add(R9, 2, 4);
			Searchpane.add(tr2, 1, 5);

			Searchpane.add(Add13, 1, 6);
			Searchpane.add(ba12, 2, 6);
			Searchpane.add(find23, 0, 6);
			Searchpane.setAlignment(Pos.CENTER);

			st6.getChildren().addAll(mah6, Searchpane);
			SearchPage = new Scene(st6, screenSize.getWidth(), screenSize.getHeight());
//================Update================================
			StackPane st7 = new StackPane();
			Image mh7 = new Image("main.jpg");
			ImageView mah7 = new ImageView(mh7);
			mah7.setFitHeight(1050);
			mah7.setFitWidth(1920);

			GridPane Updatepane = new GridPane();

			Label lanb = new Label();
			lanb.setText("Customer ID :");
			lanb.setPrefHeight(113);
			lanb.setPrefWidth(227);
			lanb.setFont(Font.font("Oranienbaum", 24));
			lanb.setTextFill(Color.WHITE);
			Updatepane.setMargin(lanb, new Insets(0, 0, 0, 130));

			Label lanb1 = new Label();
			lanb1.setText("Customer Name :");
			lanb1.setPrefHeight(113);
			lanb1.setPrefWidth(227);
			lanb1.setFont(Font.font("Oranienbaum", 24));
			lanb1.setTextFill(Color.WHITE);
			Updatepane.setMargin(lanb1, new Insets(0, 0, 0, 130));

			Label lanb2 = new Label();
			lanb2.setText("Customer Addrees :");
			lanb2.setPrefHeight(113);
			lanb2.setPrefWidth(227);
			lanb2.setFont(Font.font("Oranienbaum", 24));
			lanb2.setTextFill(Color.WHITE);
			Updatepane.setMargin(lanb2, new Insets(0, 0, 0, 130));

			Label lanb3 = new Label();
			lanb3.setText("Customer Mobile :");
			lanb3.setPrefHeight(113);
			lanb3.setPrefWidth(227);
			lanb3.setFont(Font.font("Oranienbaum", 24));
			lanb3.setTextFill(Color.WHITE);
			Updatepane.setMargin(lanb3, new Insets(0, 0, 0, 130));

			Label lanb4 = new Label();
			lanb4.setText("Customer Plan :");
			lanb4.setPrefHeight(113);
			lanb4.setPrefWidth(227);
			lanb4.setFont(Font.font("Oranienbaum", 24));
			lanb4.setTextFill(Color.WHITE);
			Updatepane.setMargin(lanb4, new Insets(0, 0, 0, 130));

			Label labnb2 = new Label();
			labnb2.setText("The Messege is  :");
			labnb2.setPrefHeight(17);
			labnb2.setPrefWidth(181);
			labnb2.setFont(Font.font("Oranienbaum", 18));
			labnb2.setTextFill(Color.WHITE);
			Updatepane.setMargin(labnb2, new Insets(0, 0, 0, 130));

			TextField texnb = new TextField();
			texnb.setPrefHeight(25);
			texnb.setPrefWidth(195);

			TextField texnb1 = new TextField();
			texnb1.setPrefHeight(25);
			texnb1.setPrefWidth(195);

			TextField texnb2 = new TextField();
			texnb2.setPrefHeight(25);
			texnb2.setPrefWidth(195);

			TextField texnb3 = new TextField();
			texnb3.setPrefHeight(25);
			texnb3.setPrefWidth(195);
			texnb3.setEditable(false);

			TextArea tr3 = new TextArea();
			tr3.setPrefHeight(25);
			tr3.setPrefWidth(195);

			ToggleGroup Tgg = new ToggleGroup();
			RadioButton R5 = new RadioButton("LIMITED");
			R5.setFont(Font.font("Oranienbaum", 14));
			R5.setToggleGroup(Tgg);

			RadioButton R6 = new RadioButton("UNLIMITED");
			R6.setFont(Font.font("Oranienbaum", 14));
			R6.setToggleGroup(Tgg);

			Button Addb13 = new Button("Update", new ImageView("UpdateCustomer.png"));
			Addb13.setPrefHeight(61);
			Addb13.setPrefWidth(106);
			Addb13.setTextFill(Color.BLACK);
			Addb13.setStyle("-fx-background-color: #ffffff");
			Addb13.setFont(Font.font("Oranienbaum", 18));
			Addb13.setContentDisplay(ContentDisplay.TOP);
			Updatepane.setMargin(Addb13, new Insets(30, 0, 0, 55));
			Addb13.setOnAction(e -> {
				RadioButton sel = (RadioButton) Tgg.getSelectedToggle();
				String val = sel.getText();
				obj.UpdateCustomer(texnb1.getText(), texnb2.getText(), val, texnb.getText(), texnb3.getText());
				texnb1.setText("");
				texnb2.setText("");
				texnb3.setText("");
				R5.setSelected(false);
				R6.setSelected(false);
				tr3.setText("The customer has been Update");

			});

			Button bab12 = new Button("Back", new ImageView("Backe.png"));
			bab12.setPrefHeight(61);
			bab12.setPrefWidth(106);
			bab12.setTextFill(Color.BLACK);
			bab12.setStyle("-fx-background-color: #ffffff");
			bab12.setFont(Font.font("Oranienbaum", 18));
			bab12.setContentDisplay(ContentDisplay.TOP);
			Updatepane.setMargin(bab12, new Insets(30, 0, 0, 130));
			bab12.setOnAction(e -> {
				primaryStage.setScene(customerPage);
			});

			Button findb23 = new Button("Find", new ImageView("Search.png"));
			findb23.setPrefHeight(61);
			findb23.setPrefWidth(106);
			findb23.setTextFill(Color.BLACK);
			findb23.setStyle("-fx-background-color: #ffffff");
			findb23.setFont(Font.font("Oranienbaum", 18));
			findb23.setContentDisplay(ContentDisplay.TOP);
			Updatepane.setMargin(findb23, new Insets(30, 0, 0, 130));
			findb23.setOnAction(e -> {

				boolean cus = obj.CheckId(texnb.getText());
				if (cus == false) {
					tr3.setText("The Customer does not Existing");
					tr3.setStyle("-fx-text-inner-color: #ff0000");
				} else {
					tr3.setText("The Customer is Existing");
				}
				for (int i = 0; i < obj.customer.size(); i++) {
					if (obj.customer.get(i).getID().equals(texnb.getText())) {
						texnb1.setText(obj.customer.get(i).getName());
						texnb2.setText(obj.customer.get(i).getAddress());
						texnb3.setText(obj.customer.get(i).getMobileNimber());
						if (obj.customer.get(i).getPlan().equals("LIMITED")) {
							R5.setSelected(true);
						} else {
							R6.setSelected(true);
						}
					}
				}

			});

			Updatepane.add(lanb, 0, 0);
			Updatepane.add(lanb1, 0, 1);
			Updatepane.add(lanb2, 0, 2);
			Updatepane.add(lanb3, 0, 3);
			Updatepane.add(lanb4, 0, 4);
			Updatepane.add(labnb2, 0, 5);

			Updatepane.add(texnb, 1, 0);
			Updatepane.add(texnb1, 1, 1);
			Updatepane.add(texnb2, 1, 2);
			Updatepane.add(texnb3, 1, 3);
			Updatepane.add(R5, 1, 4);
			Updatepane.add(R6, 2, 4);
			Updatepane.add(tr3, 1, 5);
			Updatepane.setAlignment(Pos.CENTER);

			Updatepane.add(Addb13, 1, 6);
			Updatepane.add(bab12, 2, 6);
			Updatepane.add(findb23, 0, 6);

			st7.getChildren().addAll(mah7, Updatepane);
			UpdatePage = new Scene(st7, screenSize.getWidth(), screenSize.getHeight());
//			===============================================AddMedia===================
			StackPane st8 = new StackPane();
			Image mh8 = new Image("main.jpg");
			ImageView mah8 = new ImageView(mh8);
			mah8.setFitHeight(1050);
			mah8.setFitWidth(1920);

			GridPane AddMediaPane = new GridPane();
			ComboBox combo_box = new ComboBox();
			AddMediaPane.setMargin(combo_box, new Insets(30, 0, 0, 130));
			combo_box.getItems().addAll("Game", "Album", "Movie");
			Label com = new Label();
			AddMediaPane.setMargin(com, new Insets(30, 0, 0, 130));
			com.setText("Enter your Media :");
			com.setPrefHeight(30);
			com.setPrefWidth(156);
			com.setFont(Font.font("Oranienbaum", 18));
			com.setTextFill(Color.WHITE);
			combo_box.setPrefHeight(30);
			combo_box.setPrefWidth(156);
			combo_box.setOnAction(e -> {
				if (combo_box.getValue().equals("Movie")) {
					AddMovie(primaryStage);
				} else if (combo_box.getValue().equals("Game")) {
					AddGmes(primaryStage);
				} else if (combo_box.getValue().equals("Album")) {
					AddAlbum(primaryStage);
				}
			});

			Button Backe = new Button("Back", new ImageView("Backe.png"));
			Backe.setPrefHeight(44);
			Backe.setPrefWidth(88);
			Backe.setTextFill(Color.BLACK);
			Backe.setStyle("-fx-background-color: #ffffff");
			Backe.setFont(Font.font("Oranienbaum", 18));
			Backe.setContentDisplay(ContentDisplay.TOP);
			AddMediaPane.setMargin(Backe, new Insets(50, 0, 0, 0));
			Backe.setOnAction(e -> {
				primaryStage.setScene(MediaPage);
			});
			AddMediaPane.add(com, 0, 0);
			AddMediaPane.add(combo_box, 1, 0);
			AddMediaPane.add(Backe, 1, 1);
			AddMediaPane.setAlignment(Pos.CENTER);

			st8.getChildren().addAll(mah8, AddMediaPane);
			AddMediaPage = new Scene(st8, screenSize.getWidth(), screenSize.getHeight());

//==========================UpdateMedia==============================================
			StackPane st9 = new StackPane();
			Image mh9 = new Image("main.jpg");
			ImageView mah9 = new ImageView(mh9);
			mah9.setFitHeight(1050);
			mah9.setFitWidth(1920);

			GridPane UpdatMediaPane = new GridPane();

			ComboBox combobox = new ComboBox();
			combobox.getItems().addAll("Game", "Album", "Movie");
			UpdatMediaPane.setMargin(combobox, new Insets(30, 0, 0, 130));
			Label comb = new Label();
			UpdatMediaPane.setMargin(comb, new Insets(30, 0, 0, 130));
			comb.setText("Enter your Media :");
			comb.setPrefHeight(30);
			comb.setPrefWidth(156);
			comb.setFont(Font.font("Oranienbaum", 18));
			comb.setTextFill(Color.WHITE);

			combobox.setLayoutX(381);
			combobox.setLayoutY(281);
			combobox.setPrefHeight(30);
			combobox.setPrefWidth(156);
			combobox.setOnAction(e -> {
				if (combobox.getValue().equals("Movie")) {
					UpdateMovie(primaryStage);
				} else if (combobox.getValue().equals("Game")) {
					UpdateGmes(primaryStage);
				} else if (combobox.getValue().equals("Album")) {
					UpdateAlbum(primaryStage);
				}
			});

			Button Backed = new Button("Back", new ImageView("Backe.png"));
			UpdatMediaPane.setMargin(Backed, new Insets(40, 0, 0, 0));
			Backed.setPrefHeight(44);
			Backed.setPrefWidth(88);
			Backed.setTextFill(Color.BLACK);
			Backed.setStyle("-fx-background-color: #ffffff");
			Backed.setFont(Font.font("Oranienbaum", 18));
			Backed.setContentDisplay(ContentDisplay.TOP);
			Backed.setOnAction(e -> {
				primaryStage.setScene(MediaPage);
			});

			UpdatMediaPane.add(comb, 0, 0);
			UpdatMediaPane.add(combobox, 1, 0);
			UpdatMediaPane.add(Backed, 1, 1);
			UpdatMediaPane.setAlignment(Pos.CENTER);

			st9.getChildren().addAll(mah9, UpdatMediaPane);
			UpdateMediaPage = new Scene(st9, screenSize.getWidth(), screenSize.getHeight());
//============================================Serach Media=================================================
			StackPane st12 = new StackPane();
			Image mh12 = new Image("main.jpg");
			ImageView mah12 = new ImageView(mh12);
			mah12.setFitHeight(1050);
			mah12.setFitWidth(1920);

			GridPane SerchMediaPane = new GridPane();

			Label label = new Label();
			label.setText("Code :");
			label.setPrefHeight(35);
			label.setPrefWidth(140);
			label.setFont(Font.font("Oranienbaum", 18));
			label.setTextFill(Color.WHITE);

			SerchMediaPane.setMargin(label, new Insets(30, 0, 0, 130));

			Label labe2 = new Label();
			labe2.setText("The Information :");
			labe2.setPrefHeight(35);
			labe2.setPrefWidth(140);
			labe2.setFont(Font.font("Oranienbaum", 18));
			labe2.setTextFill(Color.WHITE);
			SerchMediaPane.setMargin(labe2, new Insets(30, 0, 0, 130));

			TextField text_f = new TextField();
			text_f.setPrefHeight(25);
			text_f.setPrefWidth(211);
			SerchMediaPane.setMargin(text_f, new Insets(30, 30, 0, 0));

			TextArea Area1 = new TextArea();
			Area1.setPrefHeight(258);
			Area1.setPrefWidth(437);
			Area1.setEditable(false);
			SerchMediaPane.setMargin(Area1, new Insets(30, 30, 0, 0));

			Button backed = new Button("Back", new ImageView("Backe.png"));
			backed.setPrefHeight(44);
			backed.setPrefWidth(88);
			backed.setTextFill(Color.BLACK);
			backed.setStyle("-fx-background-color: #ffffff");
			backed.setFont(Font.font("Oranienbaum", 18));
			backed.setContentDisplay(ContentDisplay.TOP);
			backed.setAlignment(Pos.CENTER_RIGHT);
			SerchMediaPane.setMargin(backed, new Insets(30, 0, 0, 20));
			backed.setOnAction(e -> {
				primaryStage.setScene(MediaPage);
			});

			Button Search2 = new Button("Search", new ImageView("Search.png"));
			Search2.setPrefHeight(44);
			Search2.setPrefWidth(88);
			Search2.setTextFill(Color.BLACK);
			Search2.setStyle("-fx-background-color: #ffffff");
			Search2.setFont(Font.font("Oranienbaum", 18));
			Search2.setContentDisplay(ContentDisplay.TOP);
			SerchMediaPane.setMargin(Search2, new Insets(30, 0, 0, 130));
			Search2.setOnAction(e -> {
				Media med = obj.findMedia(text_f.getText());
				if (med == null) {
					Area1.setText("The media does not Exixting ");
					Area1.setStyle("-fx-text-inner-color: #ff0000");
				} else
					Area1.setText(obj.MediaInfo(text_f.getText()));

			});
			SerchMediaPane.add(label, 0, 0);
			SerchMediaPane.add(labe2, 0, 1);
			SerchMediaPane.add(text_f, 1, 0);
			SerchMediaPane.add(Area1, 1, 1);

			SerchMediaPane.add(Search2, 0, 2);
			SerchMediaPane.add(backed, 2, 2);

			SerchMediaPane.setAlignment(Pos.CENTER);

			st12.getChildren().addAll(mah12, SerchMediaPane);
			SearchMediaPage = new Scene(st12, screenSize.getWidth(), screenSize.getHeight());
//==============================AllInfo=====================================
			StackPane st11 = new StackPane();
			Image mh11 = new Image("main.jpg");
			ImageView mah11 = new ImageView(mh11);
			mah11.setFitHeight(1050);
			mah11.setFitWidth(1920);

			GridPane InfoPane = new GridPane();

			TextArea Area2 = new TextArea();
			Area2.setPrefHeight(325);
			Area2.setPrefWidth(701);
			Area2.setEditable(false);
			InfoPane.setMargin(Area2, new Insets(30, 0, 0, 130));

			Button backede = new Button("Back", new ImageView("Backe.png"));
			backede.setPrefHeight(60);
			backede.setPrefWidth(120);
			backede.setTextFill(Color.BLACK);
			backede.setStyle("-fx-background-color: #ffffff");
			backede.setFont(Font.font("Oranienbaum", 18));
			backede.setContentDisplay(ContentDisplay.TOP);
			InfoPane.setMargin(backede, new Insets(30, 0, 0, 0));
			backede.setOnAction(e -> {
				primaryStage.setScene(MediaPage);
			});

			Button Search3 = new Button("Print", new ImageView("PrintAll.png"));

			Search3.setPrefHeight(60);
			Search3.setPrefWidth(120);
			Search3.setTextFill(Color.BLACK);
			Search3.setStyle("-fx-background-color: #ffffff");
			Search3.setFont(Font.font("Oranienbaum", 18));
			Search3.setContentDisplay(ContentDisplay.TOP);
			InfoPane.setMargin(Search3, new Insets(30, 0, 0, 15));
			Search3.setOnAction(e -> {
				Area2.setText(obj.getAllMediaInfo());
			});

			InfoPane.add(Area2, 0, 0);
			InfoPane.add(Search3, 0, 1);
			InfoPane.add(backede, 1, 1);
			InfoPane.setAlignment(Pos.CENTER);

			st11.getChildren().addAll(mah11, InfoPane);
			AllInfoPage = new Scene(st11, screenSize.getWidth(), screenSize.getHeight());

//==============================Delete Media================================
			StackPane st10 = new StackPane();
			Image mh10 = new Image("main.jpg");
			ImageView mah10 = new ImageView(mh10);
			mah10.setFitHeight(1050);
			mah10.setFitWidth(1920);

			GridPane DeleteMediaPane = new GridPane();

			ComboBox combox = new ComboBox();
			combox.getItems().addAll("Game", "Album", "Movie");
			DeleteMediaPane.setMargin(combox, new Insets(30, 0, 0, 130));
			Label comb0 = new Label();
			DeleteMediaPane.setMargin(comb0, new Insets(30, 0, 0, 130));
			comb0.setText("Enter your Media :");

			comb0.setPrefHeight(30);
			comb0.setPrefWidth(156);
			comb0.setFont(Font.font("Oranienbaum", 18));
			comb0.setTextFill(Color.WHITE);
			combox.setPrefHeight(30);
			combox.setPrefWidth(156);

			Button backes = new Button("Back", new ImageView("Backe.png"));
			backes.setPrefHeight(44);
			backes.setPrefWidth(88);
			backes.setTextFill(Color.BLACK);
			backes.setStyle("-fx-background-color: #ffffff");
			backes.setFont(Font.font("Oranienbaum", 18));
			backes.setContentDisplay(ContentDisplay.TOP);
			DeleteMediaPane.setMargin(backes, new Insets(40, 0, 0, 0));
			backes.setOnAction(e -> {
				primaryStage.setScene(MediaPage);
			});
			combox.setOnAction(e -> {
				if (combox.getValue().equals("Movie")) {
					DeleteMovie(primaryStage);
				} else if (combox.getValue().equals("Game")) {
					DeleteGame(primaryStage);
				} else if (combox.getValue().equals("Album")) {
					DeleteAlbum(primaryStage);
				}
			});

			DeleteMediaPane.add(comb0, 0, 0);
			DeleteMediaPane.add(combox, 1, 0);
			DeleteMediaPane.add(backes, 1, 1);
			DeleteMediaPane.setAlignment(Pos.CENTER);

			st10.getChildren().addAll(mah10, DeleteMediaPane);
			DeleteMediaPage = new Scene(st10, screenSize.getWidth(), screenSize.getHeight());

//===============================Return Media==================			
			StackPane st15 = new StackPane();
			Image mh15 = new Image("main.jpg");
			ImageView mah15 = new ImageView(mh15);
			mah15.setFitHeight(1050);
			mah15.setFitWidth(1920);

			GridPane Returnpane = new GridPane();

			Label label_2 = new Label();
			label_2.setText("Customer ID :");
			label_2.setPrefHeight(35);
			label_2.setPrefWidth(140);
			label_2.setFont(Font.font("Oranienbaum", 18));
			label_2.setTextFill(Color.WHITE);
			Returnpane.setMargin(label_2, new Insets(30, 0, 0, 130));

			Label label_21 = new Label();
			label_21.setText("Code :");
			label_21.setPrefHeight(35);
			label_21.setPrefWidth(140);
			label_21.setFont(Font.font("Oranienbaum", 18));
			label_21.setTextFill(Color.WHITE);
			Returnpane.setMargin(label_21, new Insets(30, 0, 0, 130));

			Label label2 = new Label();
			label2.setText("The Messege :");
			label2.setPrefHeight(35);
			label2.setPrefWidth(140);
			label2.setFont(Font.font("Oranienbaum", 20));
			label2.setTextFill(Color.WHITE);
			Returnpane.setMargin(label2, new Insets(30, 0, 0, 130));

			TextField text_fi = new TextField();
			text_fi.setPrefHeight(25);
			text_fi.setPrefWidth(211);
			Returnpane.setMargin(text_fi, new Insets(30, 0, 0, 0));

			TextField text_field = new TextField();
			text_field.setPrefHeight(25);
			text_field.setPrefWidth(211);
			Returnpane.setMargin(text_field, new Insets(30, 0, 0, 0));

			TextArea Area3 = new TextArea();
			Area3.setPrefHeight(258);
			Area3.setPrefWidth(437);
			Area3.setEditable(false);
			Returnpane.setMargin(Area3, new Insets(30, 0, 0, 0));

			Button backe_U = new Button("Back", new ImageView("Backe.png"));
			backe_U.setPrefHeight(60);
			backe_U.setPrefWidth(120);
			backe_U.setTextFill(Color.BLACK);
			backe_U.setStyle("-fx-background-color: #ffffff");
			backe_U.setFont(Font.font("Oranienbaum", 16));
			backe_U.setContentDisplay(ContentDisplay.TOP);
			Returnpane.setMargin(backe_U, new Insets(30, 0, 0, 20));
			backe_U.setOnAction(e -> {
				primaryStage.setScene(RentPage);
			});

			Button Search4 = new Button("Return Media", new ImageView("ReturnMedia.png"));
			Search4.setPrefHeight(60);
			Search4.setPrefWidth(120);
			Search4.setTextFill(Color.BLACK);
			Search4.setStyle("-fx-background-color: #ffffff");
			Search4.setFont(Font.font("Oranienbaum", 16));
			Search4.setContentDisplay(ContentDisplay.TOP);
			Returnpane.setMargin(Search4, new Insets(30, 0, 0, 130));
			Search4.setOnAction(e -> {
				obj.returnMedia(text_fi.getText(), text_field.getText());
				text_fi.setText("");
				text_field.setText("");
			});

			Returnpane.add(label_2, 0, 0);
			Returnpane.add(label_21, 0, 1);
			Returnpane.add(label2, 0, 2);
			Returnpane.add(text_fi, 1, 0);
			Returnpane.add(text_field, 1, 1);
			Returnpane.add(Area3, 1, 2);
			Returnpane.add(backe_U, 2, 3);
			Returnpane.add(Search4, 0, 3);
			Returnpane.setAlignment(Pos.CENTER);

			st15.getChildren().addAll(mah15, Returnpane);
			RetrnPage = new Scene(st15, screenSize.getWidth(), screenSize.getHeight());

//==================================PrintCart=============================
			StackPane st13 = new StackPane();
			Image mh13 = new Image("main.jpg");
			ImageView mah13 = new ImageView(mh13);
			mah13.setFitHeight(1050);
			mah13.setFitWidth(1920);

			GridPane PrintCart = new GridPane();

			Label label_23 = new Label();
			label_23.setText("Customer ID :");
			label_23.setPrefHeight(35);
			label_23.setPrefWidth(140);
			label_23.setFont(Font.font("Oranienbaum", 18));
			label_23.setTextFill(Color.WHITE);
			PrintCart.setMargin(label_23, new Insets(30, 0, 0, 130));

			Label label21 = new Label();
			label21.setText("Intersted Media Cart :");
			label21.setPrefHeight(35);
			label21.setPrefWidth(140);
			label21.setFont(Font.font("Oranienbaum", 14));
			label21.setTextFill(Color.WHITE);
			PrintCart.setMargin(label21, new Insets(30, 0, 0, 130));

			TextField text_fie = new TextField();
			text_fie.setPrefHeight(25);
			text_fie.setPrefWidth(211);
			PrintCart.setMargin(text_fie, new Insets(30, 0, 0, 0));

			TextArea Area4 = new TextArea();
			Area4.setPrefHeight(258);
			Area4.setPrefWidth(437);
			Area4.setEditable(false);

			Button backe_Up = new Button("Back", new ImageView("Backe.png"));
			backe_Up.setPrefHeight(60);
			backe_Up.setPrefWidth(120);
			backe_Up.setTextFill(Color.BLACK);
			backe_Up.setStyle("-fx-background-color: #ffffff");
			backe_Up.setFont(Font.font("Oranienbaum", 18));
			backe_Up.setContentDisplay(ContentDisplay.TOP);
			PrintCart.setMargin(backe_Up, new Insets(30, 0, 0, 20));
			backe_Up.setOnAction(e -> {
				primaryStage.setScene(RentPage);
			});

			Button Search5 = new Button("Print", new ImageView("PrintAll.png"));
			Search5.setPrefHeight(60);
			Search5.setPrefWidth(120);
			Search5.setTextFill(Color.BLACK);
			Search5.setStyle("-fx-background-color: #ffffff");
			Search5.setFont(Font.font("Oranienbaum", 18));
			Search5.setContentDisplay(ContentDisplay.TOP);
			PrintCart.setMargin(Search5, new Insets(30, 0, 0, 130));
			Search5.setOnAction(e -> {
				if (obj.getIntrsted(text_fie.getText()) == null) {
					return;
				} else {

					Area4.setText(obj.getIntrsted(text_fie.getText()));
				}

			});

			PrintCart.add(label_23, 0, 0);
			PrintCart.add(label21, 0, 1);
			PrintCart.add(text_fie, 1, 0);
			PrintCart.add(Area4, 1, 1);
			PrintCart.add(Search5, 0, 2);
			PrintCart.add(backe_Up, 2, 2);
			PrintCart.setAlignment(Pos.CENTER);

			st13.getChildren().addAll(mah13, PrintCart);
			PrintCartPage = new Scene(st13, screenSize.getWidth(), screenSize.getHeight());

//=========================================printRent==========================================================
			StackPane st14 = new StackPane();
			Image mh14 = new Image("main.jpg");
			ImageView mah14 = new ImageView(mh14);
			mah14.setFitHeight(1050);
			mah14.setFitWidth(1920);

			GridPane PrintRent = new GridPane();

			Label label_234 = new Label();
			label_234.setText("Customer ID :");
			label_234.setPrefHeight(35);
			label_234.setPrefWidth(140);
			label_234.setFont(Font.font("Oranienbaum", 18));
			label_234.setTextFill(Color.WHITE);
			PrintRent.setMargin(label_234, new Insets(30, 0, 0, 130));

			Label label211 = new Label();
			label211.setText("Rented Media Cart :");
			label211.setPrefHeight(35);
			label211.setPrefWidth(140);
			label211.setFont(Font.font("Oranienbaum", 14));
			label211.setTextFill(Color.WHITE);
			PrintRent.setMargin(label211, new Insets(30, 0, 0, 130));

			TextField text_fiel = new TextField();
			text_fiel.setPrefHeight(25);
			text_fiel.setPrefWidth(211);
			PrintRent.setMargin(text_fiel, new Insets(30, 0, 0, 0));

			TextArea Area5 = new TextArea();
			Area5.setPrefHeight(258);
			Area5.setPrefWidth(437);
			Area5.setEditable(false);

			Button backe_Up_ = new Button("Back", new ImageView("Backe.png"));
			backe_Up_.setPrefHeight(60);
			backe_Up_.setPrefWidth(120);
			backe_Up_.setTextFill(Color.BLACK);
			backe_Up_.setStyle("-fx-background-color: #ffffff");
			backe_Up_.setFont(Font.font("Oranienbaum", 18));
			backe_Up_.setContentDisplay(ContentDisplay.TOP);
			PrintRent.setMargin(backe_Up_, new Insets(30, 0, 0, 20));
			backe_Up_.setOnAction(e -> {
				primaryStage.setScene(RentPage);
			});

			Button Search6 = new Button("Print", new ImageView("PrintAll.png"));
			Search6.setPrefHeight(60);
			Search6.setPrefWidth(120);
			Search6.setTextFill(Color.BLACK);
			Search6.setStyle("-fx-background-color: #ffffff");
			Search6.setFont(Font.font("Oranienbaum", 18));
			Search6.setContentDisplay(ContentDisplay.TOP);
			PrintRent.setMargin(Search6, new Insets(30, 0, 0, 130));
			Search6.setOnAction(e -> {

				for (int i = 0; i < obj.customer.size(); i++) {
					if (obj.customer.get(i).getID().equals(text_fiel.getText())) {
						Area5.setText(obj.customer.get(i).getRented().toString());
					}
				}

			});
			PrintRent.add(label_234, 0, 0);
			PrintRent.add(label211, 0, 1);
			PrintRent.add(text_fiel, 1, 0);
			PrintRent.add(Area5, 1, 1);
			PrintRent.add(Search6, 0, 2);
			PrintRent.add(backe_Up_, 2, 2);
			PrintRent.setAlignment(Pos.CENTER);

			st14.getChildren().addAll(mah14, PrintRent);
			PrintRentPage = new Scene(st14, screenSize.getWidth(), screenSize.getHeight());
//==============================AddCart============================================
			StackPane st16 = new StackPane();
			Image mh16 = new Image("main.jpg");
			ImageView mah16 = new ImageView(mh16);
			mah16.setFitHeight(1050);
			mah16.setFitWidth(1920);

			GridPane AddCart1 = new GridPane();

			Label le = new Label();
			le.setText("Customer ID :");
			le.setPrefHeight(30);
			le.setPrefWidth(150);
			le.setFont(Font.font("Oranienbaum", 18));
			le.setTextFill(Color.WHITE);
			AddCart1.setMargin(le, new Insets(30, 0, 0, 130));

			Label le1 = new Label();
			le1.setText("Code :");
			le1.setPrefHeight(30);
			le1.setPrefWidth(150);
			le1.setFont(Font.font("Oranienbaum", 18));
			le1.setTextFill(Color.WHITE);
			AddCart1.setMargin(le1, new Insets(30, 0, 0, 130));

			Label le2 = new Label();
			le2.setText("Customer information :");
			le2.setPrefHeight(25);
			le2.setPrefWidth(195);
			le2.setFont(Font.font("Oranienbaum", 18));
			le2.setTextFill(Color.WHITE);
			AddCart1.setMargin(le2, new Insets(30, 0, 0, 130));

			Label le3 = new Label();
			le3.setText("Media Information :");
			le3.setPrefHeight(25);
			le3.setPrefWidth(195);
			le3.setFont(Font.font("Oranienbaum", 18));
			le3.setTextFill(Color.WHITE);
			AddCart1.setMargin(le3, new Insets(30, 0, 0, 130));

			Label le4 = new Label();
			le4.setText("Rented Date :");
			le4.setPrefHeight(30);
			le4.setPrefWidth(150);
			le4.setFont(Font.font("Oranienbaum", 18));
			le4.setTextFill(Color.WHITE);
			AddCart1.setMargin(le4, new Insets(30, 0, 0, 130));

			TextField texted = new TextField();
			texted.setPrefHeight(25);
			texted.setPrefWidth(168);
			AddCart1.setMargin(texted, new Insets(30, 0, 0, 0));

			TextField texted1 = new TextField();
			texted1.setPrefHeight(25);
			texted1.setPrefWidth(168);
			AddCart1.setMargin(texted1, new Insets(30, 0, 0, 0));

			TextArea Area6 = new TextArea();
			Area6.setPrefHeight(200);
			Area6.setPrefWidth(200);
			Area6.setEditable(false);
			AddCart1.setMargin(Area6, new Insets(30, 0, 0, 0));

			TextArea Area7 = new TextArea();
			Area7.setPrefHeight(200);
			Area7.setPrefWidth(200);
			Area7.setEditable(false);
			AddCart1.setMargin(Area7, new Insets(30, 0, 0, 0));

			Button ba4 = new Button("Back", new ImageView("Backe.png"));
			ba4.setPrefHeight(44);
			ba4.setPrefWidth(88);
			ba4.setTextFill(Color.BLACK);
			ba4.setStyle("-fx-background-color: #ffffff");
			ba4.setFont(Font.font("Oranienbaum", 12));
			ba4.setContentDisplay(ContentDisplay.TOP);
			AddCart1.setMargin(ba4, new Insets(30, 0, 0, 60));
			ba4.setOnAction(e -> {
				primaryStage.setScene(RentPage);
			});

			Button ba5 = new Button("Prosess", new ImageView("process.png"));
			ba5.setPrefHeight(44);
			ba5.setPrefWidth(88);
			ba5.setTextFill(Color.BLACK);
			ba5.setStyle("-fx-background-color: #ffffff");
			ba5.setFont(Font.font("Oranienbaum", 12));
			ba5.setContentDisplay(ContentDisplay.TOP);
			AddCart1.setMargin(ba5, new Insets(30, 0, 0, 0));
			ba5.setOnAction(e -> {
				obj.processRequests();
				Area6.setText("");
				Area7.setText("");
			});

			Button ba6 = new Button("Add Cart", new ImageView("AddCart.png"));
			ba6.setPrefHeight(44);
			ba6.setPrefWidth(88);
			ba6.setTextFill(Color.BLACK);
			ba6.setStyle("-fx-background-color: #ffffff");
			ba6.setFont(Font.font("Oranienbaum", 12));
			ba6.setContentDisplay(ContentDisplay.TOP);
			AddCart1.setMargin(ba6, new Insets(30, 0, 0, 0));
			ba6.setOnAction(e -> {
				boolean b = obj.addToCart(texted.getText(), texted1.getText());
				Custmor in = obj.findcustomer(texted.getText());
				Media in1 = obj.findMedia(texted1.getText());

				if (b == false) {
					return;
				} else {
					Area7.setText(in.toString());
					Area6.setText(in1.toString());
				}

			});

			DatePicker Date = new DatePicker();
			Date.setPrefHeight(30);
			Date.setPrefWidth(150);
			Date.setEditable(false);
			AddCart1.setMargin(Date, new Insets(30, 0, 0, 0));

			AddCart1.add(le4, 0, 0);
			AddCart1.add(le, 0, 1);
			AddCart1.add(le1, 0, 2);
			AddCart1.add(le3, 0, 3);

			AddCart1.add(Date, 1, 0);
			AddCart1.add(texted, 1, 1);
			AddCart1.add(texted1, 1, 2);

			AddCart1.add(Area6, 1, 3);

			AddCart1.add(le2, 2, 3);
			AddCart1.add(Area7, 3, 3);

			AddCart1.add(ba6, 1, 4);
			AddCart1.add(ba5, 3, 4);
			AddCart1.add(ba4, 2, 4);

			AddCart1.setAlignment(Pos.CENTER);

			st16.getChildren().addAll(mah16, AddCart1);
			AddCartPage = new Scene(st16, screenSize.getWidth(), screenSize.getHeight());

			primaryStage.hide();
			primaryStage.setMaximized(true);
			primaryStage.setScene(mainPage);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
