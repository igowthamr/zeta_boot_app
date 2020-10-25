package com.example.demo.service;

import com.example.demo.model.Image;

public interface IImageService {
	
	public Image getRandomImage();
	
	public Image getImageAgainstId(String id);
}
