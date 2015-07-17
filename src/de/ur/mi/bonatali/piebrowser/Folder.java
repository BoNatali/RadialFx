package de.ur.mi.bonatali.piebrowser;

import java.io.File;

public class Folder {
	

	private File folder;
	private String name;
	private File [] items;
	
	private int currentIndex = 0;
	
	
	public Folder (String url) {
		folder = new File (url);
		name = folder.getName();
		items = folder.listFiles();
	}
	
	public File [] getNextItemSet () {
		File [] set = new File [8];
		int counter = 0;
		for (int i = currentIndex; i<items.length; i++) {
			if (counter < 8) {
				set [counter] = items [currentIndex];
			} else {
				break;
			}
			
		}
		return set;
	}
	
	public String getName () {
		return name;
	}

}
