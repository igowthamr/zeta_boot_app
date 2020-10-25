package com.example.demo.db;

import com.example.demo.model.Image;

public interface IImageDB {
	
	public Image getImage(String id) ;
	
	public Image getRandomImage() ;
}
