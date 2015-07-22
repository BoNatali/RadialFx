package de.ur.mi.bonatali.piebrowser;

import java.util.Arrays;

import javafx.scene.image.Image;

public class IconMap {
	
	private static Image icon; 
	
	//most common file extensions grouped as categories 
	private static String [] imageFormats = {"jpg", "jpeg", "png", "bmp"} ;
	private static String [] archiveFormats = {"zip", "rar", "7z"};
	private static String [] documentFormats = {"pdf", "doc", "docx", "odt"};
	private static String [] audioFormats = {"mp3", "wav", "wma"};
	private static String [] videoFormats = {"mp4", "wmv", "mpg", "mpeg", "avi"};
	
	
	private static  Image folderImg = new Image ("file:3.png"); 
	private static Image imageImg = new Image ("file:3.png"); 
	private static Image archiveImg = new Image ("file:3.png"); 
	private static Image documentImg = new Image ("file:3.png"); 
	private static Image audioImg = new Image ("file:3.png"); 
	private static Image videoImg = new Image ("file:3.png"); 
	private static Image defaultImg = new Image ("file:3.png"); 
	
	public static Image getFileIcon (String fileName) {
		
		//setting icon to default
		icon = defaultImg;
		
		//extract file extension
		String fileType;
		
		if (fileName != null) {
		int typeStart = fileName.lastIndexOf('.');
		fileType = fileName.substring(typeStart+1, fileName.length()); 
		} else {
			fileType = "none";
		}
		
		
		//set image according to type
		if (isImage(fileType)) {
			System.out.println("IS IMAGE!!!");
			return icon = imageImg;
			
		}
		
		if (isArchive(fileType)) {
			System.out.println("IS Archive!!!");
			return icon = archiveImg;
			
		}
		
		if (isDocument(fileType)) {
			System.out.println("IS DOCUMENT!!!");
			return icon = documentImg;
			
		}
		
		if (isAudio(fileType)) {
			System.out.println("IS AUDIO!!!");
			return icon = audioImg;
			
		}
		
		if (isVideo(fileType)) {
			System.out.println("IS VIDEO!!!");
			return icon = videoImg;
			
		}
		
		System.out.println("IS DEFAULT!!!");
		return icon;
	}
	
	public static Image getFolderIcon () {
		return icon = folderImg;
	}
	
	private static boolean isImage (String fileExtension) {
		return Arrays.asList(imageFormats).contains(fileExtension);
	}
	
	private static boolean isDocument (String fileExtension) {
		return Arrays.asList(documentFormats).contains(fileExtension);
	}
	
	private static boolean isArchive (String fileExtension) {
		return Arrays.asList(archiveFormats).contains(fileExtension);
	}
	
	private static boolean isAudio (String fileExtension) {
		return Arrays.asList(audioFormats).contains(fileExtension);
	}
	
	private static boolean isVideo (String fileExtension) {
		return Arrays.asList(videoFormats).contains(fileExtension);
	}

}
