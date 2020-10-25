package com.example.demo.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Image;

public class ImageUtil {

	public static Image getImageUrl(String u,String key) {
		InputStream in = null;
		String value = null;
		try {
			URL url = new URL(u);
			URLConnection conn = url.openConnection();
			Map<String, List<String>> map = conn.getHeaderFields();

			System.out.println("Printing Response Header...\n");

			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey()
		                           + " ,Value : " + entry.getValue());
				if(entry.getKey() != null && entry.getKey().equalsIgnoreCase(key)) {
					value = entry.getValue().get(0);
				}
			}
			in = url.openStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[4096];
		try {
			while ((nRead = in.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] media = buffer.toByteArray();
		return new Image((value), media);
	}

	
	
	
}
