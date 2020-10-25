package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.IImageDB;
import com.example.demo.model.Image;

@Service
public class ImageServiceImpl implements IImageService {
	
	@Autowired
	private IImageDB imageDb;
	
	@Override
	public Image getRandomImage() {
		return imageDb.getRandomImage();
	}

	@Override
	public Image getImageAgainstId(String id) {
		Image image =  imageDb.getImage(id);
		return image;
	}

	@Override
	public Map<String, String> allImagesInDb() {
		return imageDb.allImagesInDb();
	}
	
	
}
