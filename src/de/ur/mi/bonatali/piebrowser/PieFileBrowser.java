package de.ur.mi.bonatali.piebrowser;

import java.awt.Dimension;
import java.awt.Toolkit;
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
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		container = new Group ();
		final Scene scene = new Scene(container, Color.TRANSPARENT);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.centerOnScreen();
		final Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		stage.setWidth(screenSize.getWidth());
		stage.setHeight(screenSize.getHeight());
		stage.toFront();
		stage.setTitle("DAS IST MEINE BACHELORARBEIT, BITCH!");
		stage.show();
		
	}

}
