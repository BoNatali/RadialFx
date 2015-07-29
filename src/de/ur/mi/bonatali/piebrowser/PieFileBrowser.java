package de.ur.mi.bonatali.piebrowser;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import com.mrlonee.radialfx.*;

public class PieFileBrowser extends Application{
	
	public static void main(final String[] args) {
		launch(args);
	}

	private PieBrowser pie;
	private Group container; //Gruppe von grafischen Elementen
	
	private String rootUrl;
	private Folder root;
	
	private Image logoImg;
	private ImageView logoView; 
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		container = new Group ();
		File f = new File("/resources/de/ur/mi/bonatali/icons/logo2.png");
		//logoImg = new Image (f.toURI().toString());
		logoImg = new Image ("file:/resources/de/ur/mi/bonatali/icons/logo2.png", 200.0, 200.0, true, true);
		System.out.println ("PLEASE SHOW"  + logoImg.getHeight() + logoImg.impl_getUrl() + logoImg.getWidth() + logoImg.getHeight() + logoImg.isBackgroundLoading());
		logoView = new ImageView ();
		logoView.setImage(logoImg);
		logoView.setFitWidth(200.0);
		//logoView.setPreserveRatio(true);
		logoView.setSmooth(true);
		System.out.println ("PLEASE SHOW" + logoImg.getHeight() + logoView.getFitWidth() + logoView.getFitHeight() + logoImg.isBackgroundLoading());
		
		
		
		
		final Scene scene = new Scene(container, Color.TRANSPARENT);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		//stage.centerOnScreen();
		final Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		stage.setWidth(screenSize.getWidth());
		stage.setHeight(screenSize.getHeight());
		
		logoView.setTranslateX(0.0);
		logoView.setTranslateY(screenSize.getHeight());
		container.getChildren().add(logoView);
		
		stage.toFront();
		stage.setTitle("DAS IST MEINE BACHELORARBEIT, BITCH!");
		stage.show();
		
		
		System.out.println ("IS IT?" + container.getChildren().contains(logoView));
		rootUrl = "/Users/Natali/Documents/test";
		root = new Folder (rootUrl);
		String rootName = root.getName();
		
		String [] itemNames = root.getNextItems();
		Image [] itemIcons = new Image [8];
		System.out.println ("My Folder: " + rootName);
		for (int i = 0; i<itemNames.length; i++){
			System.out.println ("my Item round 1: " + itemNames [i]);
			itemIcons [i] = IconMap.getFileIcon(itemNames [i]);
		}
		
		itemNames = root.getNextItems();
		itemIcons = new Image [8];
		System.out.println ("My Folder: " + rootName);
		for (int i = 0; i<itemNames.length; i++){
			System.out.println ("my Item round 2: " + itemNames [i]);
			itemIcons [i] = IconMap.getFileIcon(itemNames [i]);
		}
		
		itemNames = root.getNextItems();
		itemIcons = new Image [8];
		System.out.println ("My Folder: " + rootName);
		for (int i = 0; i<itemNames.length; i++){
			System.out.println ("my Item round 3: " + itemNames [i]);
			itemIcons [i] = IconMap.getFileIcon(itemNames [i]);
		}
		
		itemNames = root.getNextItems();
		itemIcons = new Image [8];
		System.out.println ("My Folder: " + rootName);
		for (int i = 0; i<itemNames.length; i++){
			System.out.println ("my Item round 4: " + itemNames [i]);
			itemIcons [i] = IconMap.getFileIcon(itemNames [i]);
		}
		
		itemNames = root.getNextItems();
		itemIcons = new Image [8];
		System.out.println ("My Folder: " + rootName);
		for (int i = 0; i<itemNames.length; i++){
			System.out.println ("my Item round 5: " + itemNames [i]);
			itemIcons [i] = IconMap.getFileIcon(itemNames [i]);
		}
		
		
		pie = new PieBrowser();
		pie.setTranslateX(screenSize.getWidth()/2); //alignment on screen
		pie.setTranslateY(screenSize.getHeight()/2);
		container.getChildren().addAll(pie);
		
		intiateOnClickListeners();
		
	}

	private void intiateOnClickListeners() {
		// TODO Auto-generated method stub
		
	}

}
