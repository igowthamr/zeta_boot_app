package com.example.demo.model;

public class Image {
	
	String id;
	byte[] data;
	
	public Image(String i,byte[] d) {
		id=i;
		data=d;
	}
	
	public String getId() {
		return this.id;
	}
	
	public byte[] getBytes() {
		return this.data;
	}
}
