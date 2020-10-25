package com.example.demo.db;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.example.demo.model.Image;
import com.example.demo.util.ImageUtil;

@Component
public class MongoImageDB implements IImageDB {
	
	private HashMap<String,String> inMem = new HashMap<>();
	
	private String randomImageUrl = "https://picsum.photos/1000/700";
	
	private String randomIdUrl = "https://picsum.photos/id/%id%/1000/700";

	@Override
	public Image getImage(String id) {
		Image image = null;
		if(inMem.get(id) != null) {
			image = ImageUtil.getImageUrl(inMem.get(id), "Picsum-Id");
		}else {
			image = ImageUtil.getImageUrl(randomImageUrl, "Picsum-Id");
			inMem.put(id, randomIdUrl.replaceFirst("%id%", image.getId()));
		}
		return image;
	}
	
	public void setImageUrlAgainstId(int id,String url) {
		
	}
	
	public String getImageUrlAgainstId(int id) {
		return inMem.get(id);
	}

	@Override
	public Image getRandomImage() {
		return ImageUtil.getImageUrl(randomImageUrl, "Picsum-Id");
	}
}
