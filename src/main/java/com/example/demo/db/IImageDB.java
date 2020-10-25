package com.example.demo.db;

import java.util.Map;

import com.example.demo.model.Image;

public interface IImageDB {
	
	public Image getImage(String id) ;
	
	public Image getRandomImage() ;
	
	public Map<String,String> allImagesInDb();
}
