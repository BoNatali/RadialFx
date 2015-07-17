/**
 * Copyright 2014 (C) Mr LoNee - (Laurent NICOLAS) - www.mrlonee.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
package com.mrlonee.radialfx.colormenu;

import java.awt.List;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineToBuilder;
import javafx.scene.shape.MoveToBuilder;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.stage.Screen;
import javafx.util.Duration;

import com.mrlonee.radialfx.core.RadialMenuItem;
import com.mrlonee.radialfx.core.RadialMenuItemBuilder;

public class RadialColorMenu extends Group {

    private ItemExtEventHandler itemExtMouseHandler;
    private ObjectProperty<Paint> selectedColor;
    private final double minOffset = 5;
    private Collection <RadialMenuItem> subItems = new ArrayList <RadialMenuItem>();
    private Collection <RadialMenuItem> parentItems = new ArrayList <RadialMenuItem> ();
    private int evoke = 0;
    Group submenu;

    //refactored
    public RadialColorMenu() {
	selectedColor = new SimpleObjectProperty<Paint>(Color.AQUA);
	itemExtMouseHandler = new ItemExtEventHandler();

	final Color[] colors = new Color[] { Color.PEACHPUFF, Color.PALETURQUOISE,
		Color.PINK, Color.HOTPINK, Color.ALICEBLUE, Color.POWDERBLUE, Color.ROSYBROWN, Color.PLUM };

	int i = colors.length;
	for (final Color color : colors) {
	    addColorItem(color, (i * 360d / colors.length) + 67.50, 360d / colors.length);
	    i--;
	}
	
	

	final Circle center = new Circle();
	center.fillProperty().bind(selectedColor);
	center.setRadius(60);
	center.setCenterX(0);
	center.setCenterY(0);

	getChildren().add(center);
    }
    
    private void setUpSubMenu (Color parentColor, double parentEndX, double parentENDY, double startangle) {
    	final Color[] colors = new Color[8];
    	Arrays.fill(colors, parentColor);
    	
    	/*final Color[] colors = new Color[] { Color.PEACHPUFF, Color.PALETURQUOISE,
    			Color.PINK, Color.HOTPINK, Color.ALICEBLUE, Color.POWDERBLUE, Color.ROSYBROWN, Color.PLUM };*/

    	submenu = new Group();
    		int i = 0;
    		for (final Color color : colors) {
    			if (i<4) {
    				addColorSubItem(color, (startangle - (i*  180d/ 8)), 180d / 8);
    			} else {
    				addColorSubItem(color, (startangle - (i*  180d/ 8)) + 180d, 180d / 8);
    			}
    		    i++;
    		}
    		
    		getChildren().addAll(subItems); 
    		
	}

    private void addColorSubItem(Color color, double startAngle, double length) {
    	double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    	System.out.println("But I am taking this one: " + startAngle);
    	RadialMenuItem subItem = RadialMenuItemBuilder.create()
    			.startAngle(startAngle).length(length).backgroundFill(color)
    			.backgroundMouseOnFill(color).strokeVisible(false).offset(minOffset)
    			.innerRadius(screenHeight/2 - 120 + 4).radius(screenHeight/2 - 20).build();
    	subItems.add (subItem);
		
	}

	private void addColorItem(final Color color, final double startAngle,
	    final double length) {

    double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
	final RadialMenuItem colorItem = RadialMenuItemBuilder.create()
		.startAngle(startAngle).length(length).backgroundFill(color)
		.backgroundMouseOnFill(color).strokeVisible(false).offset(minOffset)
		.innerRadius(60).radius(screenHeight/2 - 120).build();
	getChildren().add(colorItem);
	
	//radius is set here

	final Path extGraphic = PathBuilder
		.create()
		.elements(MoveToBuilder.create().x(-2.5).y(0).build(),
			LineToBuilder.create().x(-2.5).y(5).build(),
			LineToBuilder.create().x(2.5).y(0).build(),
			LineToBuilder.create().x(-2.5).y(-5).build(),
			LineToBuilder.create().x(-2.5).y(0).build())
		.fill(Color.WHITE)
		.stroke(null)
		.rotate(-colorItem.startAngleProperty().get()
			- colorItem.lengthProperty().get() / 2.0)

		.build();
	/*final RadialMenuItem colorItemExt = RadialMenuItemBuilder.create()
		.startAngle(startAngle).length(length).backgroundFill(color)
		.backgroundMouseOnFill(color).strokeVisible(false)
		.innerRadius(142).radius(180).graphic(extGraphic).offset(minOffset)
		.build();

	getChildren().add(colorItemExt);
	colorItemExt.setOnMouseClicked(itemExtMouseHandler); */

	final Paint selectColor = Color.GRAY;
	final double colorOffset = 6;
	final RadialMenuItem colorItemSel = RadialMenuItemBuilder.create()
		.startAngle(startAngle + colorOffset).offset(minOffset)
		.length(length - colorOffset * 2).backgroundFill(selectColor)
		.strokeVisible(false).innerRadius(132).radius(134).build();
	colorItemSel.setOpacity(0.0);
	getChildren().add(colorItemSel);

	final EventHandler<MouseEvent> mouseHandler = new ItemOnEventHandler(
		colorItemSel, colorItem);
	colorItem.setOnMouseEntered(mouseHandler);
	colorItem.setOnMouseExited(mouseHandler);
	colorItem.setOnMouseMoved(mouseHandler);
    }

    private final class ItemExtEventHandler implements EventHandler<MouseEvent> {

	RadialMenuItem selected = null;

	@Override
	public void handle(final MouseEvent event) {
	    final RadialMenuItem item = (RadialMenuItem) event.getSource();

	    if (item == selected) {
		// do close
	    } else if (selected != null) {
		// do replace
	    } else {
		// do open
	    }
	    selected = item;
	}
    }

    private final class ItemOnEventHandler implements EventHandler<MouseEvent> {

	private final RadialMenuItem colorItemSel;
	private final RadialMenuItem colorItem;
	private RadialMenuItem lastParent;
	double offset = 0;
	boolean enteredByInner = false;

	private ItemOnEventHandler(final RadialMenuItem colorItemSel,
		final RadialMenuItem colorItem) {
	    this.colorItemSel = colorItemSel;
	    this.colorItem = colorItem;
	   
	}

	@Override
	public void handle(final MouseEvent event) {
		boolean submenuDisplayed = getChildren().containsAll(subItems);
		
	    if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
	    	System.out.println ("Mouseevent evoked again: " + evoke);
			evoke ++;
				if (lastParent != colorItem) {
					//delete old submenu
					getChildren().removeAll(subItems);
			    	subItems.clear();
			    	//create new
			    	System.out.println ("SUBMENU HERE PLS!");
			    	drawSubmenu (event);
			    	
				}
				lastParent = colorItem;
	    		
	    } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
	    	boolean enteredChildren = true;
	    	System.out.println ("SUBMENU GONE PLS!");
	    	
	    	
		if (enteredByInner) {
		   
		 
		    
		}
		enteredByInner = false;
	    } else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
		if (enteredByInner) {
		    final double distanceToCenter = Point2D.distance(
			    event.getX(), event.getY(), 0, 0);

		    offset = 0.4 * (distanceToCenter - colorItem
			    .getInnerRadius());
		    colorItem.setOffset(offset);
		    colorItemSel.setOffset(offset);
		}
	    }
	    ;
	    
	    
	}

	private void drawSubmenu(MouseEvent event) {
		boolean isFolder = true;
		
		if (isFolder) {
			RadialMenuItem parent = (RadialMenuItem) event.getSource();
			System.out.println("my parent");
			ObjectProperty<Paint> parentPaint = parent.backgroundFillProperty();
			Color parentColor =  (Color) parentPaint.getValue();
			double startAngle = parent.getStartAngle();
			double innerEndX = parent.getinnerEndX();
			double innerEndY = parent.getinnerEndX();
			
			
			setUpSubMenu(parentColor, innerEndX, innerEndY, startAngle);
			System.out.println("This is my startangle: " + startAngle);
			//add Submenu, 8 Items, half angle, radius = size - radiusParent, startAngle innerEndY, innerEndx
		}
		
	}

    }

    public ObjectProperty<Paint> selectedColorProperty() {
	return selectedColor;
    }

    public Paint getSelectedColor() {
	return selectedColor.get();
    }

}
