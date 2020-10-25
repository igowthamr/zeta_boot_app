package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.Image;

public interface IImageService {
	
	public Image getRandomImage();
	
	public Image getImageAgainstId(String id);
	
	public Map<String,String> allImagesInDb();
}
