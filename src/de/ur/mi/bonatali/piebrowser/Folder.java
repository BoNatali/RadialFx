package de.ur.mi.bonatali.piebrowser;

import java.io.File;

public class Folder {
	
	private String name;
	private String parentName;
	private File [] items;
	
	public Folder (String name, String parentName, File [] items) {
		this.name = name;
		this.parentName = parentName;
		this.items = items;
	}
	
	public File [] getNextItemSet () {
		File [] set = items;
		return set;
	}

}
