package com.viettel.gallery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.viettel.gallery.entity.Gallery;

public class HomeController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/{id}")
	public Gallery getGallery(@PathVariable int id) {
		try {
			Gallery gallery = new Gallery();
			gallery.setId(id);
			List<Object> images = restTemplate.getForObject("http://imageservice/image/list-images", List.class);
			gallery.setImages(images);
			return gallery;
		} catch (Exception e) {
			Gallery gallery = new Gallery(id, null);
			return gallery;
		}
	}

}
