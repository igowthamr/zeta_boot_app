package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IImageService;

@RestController
@RequestMapping("")
public class Controller {
	
	@Autowired
	private IImageService service;

	@RequestMapping(value = "/message",method = RequestMethod.GET, produces = "application/json")
	public String giveMessage() {
		return "Hello messgae";
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "image/jpeg")
	public ResponseEntity<byte[]> getImageAsResponseEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		byte[] media = service.getRandomImage().getBytes();
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "image/jpeg")
	public ResponseEntity<byte[]> getImageAsResponseEntityById(@PathVariable(value="id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		byte[] media = service.getImageAgainstId(id).getBytes();
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	

	

}
