package de.ur.mi.bonatali.piebrowser;

import javax.swing.ImageIcon;

public class IconMap {
	
	private static ImageIcon icon; 
	
	//img 
	private final String JPG = "jpg";
	private final String PNG = "png";
	private final String JPEG = "jpeg";
	
	//archive
	private final String ZIP = "zip";
	private final String RAR = "rar";
	
	//documents
	private final String PDF = "pdf";
	private final String DOC = "doc";
	private final String DOCX = "docx";
	private final String OTF = "otf";
	
	//music
	private final String MP3 = "mp3";
	
	//video
	private final String MP4 = "mp4";
	
	public static ImageIcon getFileIcon (String fileName) {
		int typeStart = fileName.lastIndexOf('.');
		String fileType = fileName.substring(typeStart+1, fileName.length());
		System.out.println ("My Type:" + fileType);
		return icon;
	}
	
	public static ImageIcon getFolderIcon () {
		return icon;
	}

}
