package de.ur.mi.bonatali.piebrowser;

import java.io.File;
import java.net.URLConnection;

public class Folder {
	

	private File folder;
	private String name;
	private File [] items;
	private String [] itemNames;
	
	private int setNum = 8;
	private int max;
	
	private int currentIndex = 0;
	
	
	public Folder (String url) {
		folder = new File (url);
		name = folder.getName();
		items = folder.listFiles(); //directories and files
		max = items.length;
	}
	
	public File [] getNextItemSet () {
		File [] set = new File [setNum];
		for (int i = 0; i<setNum; i++) {
			if (i+currentIndex < items.length) {
				set [i] = items [i+currentIndex];
			} else {
				currentIndex = 0; //von neu
			}
			
			
		}
		currentIndex += setNum;
		return set;
	}
	
	public String [] getNextItems () {
		String [] set = new String [setNum];
		for (int i = 0; i<setNum; i++) {
			if (i+currentIndex < items.length) {
				if (items [i+currentIndex].getName() != null)
				set [i] = items [i+currentIndex].getName();
				else set [i] = "warum funktioniert das nich?.zip";
			} else {
				currentIndex = 0; //von neu
			}
			
			
		}
		currentIndex += setNum;
		return set;
	}
	
	public String getName () {
		return name;
	}
	
	public boolean isFolder (File item) {
		return item.isDirectory();
	}
	
	public void openFile (File item) {
		if (!item.isDirectory()) {
			//openFile
		} 
	}

}
