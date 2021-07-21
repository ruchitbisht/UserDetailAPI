package com.pratikshat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pratikshat.entity.User;
import com.pratikshat.request.FilterRequest;
import com.pratikshat.request.UserRequest;
import com.pratikshat.response.UserResponse;
import com.pratikshat.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/uploads")
	public UserRequest userUploads(@RequestPart("file") MultipartFile multipartFile,
			@RequestPart("data") UserRequest user) {
		userService.userUploads(multipartFile, user);
		return user;
	}
	
	@GetMapping("/upload/check")
	public List<User> getDataByData(@RequestBody FilterRequest filter) throws Exception{
		return userService.getDataByData(filter);
		
	}

	@GetMapping("/uploads")
	public List<UserResponse> getUser() {
		return userService.getUser();
	}

	@GetMapping("/upload/{country}")
	public List<User> getUserByCountry(@PathVariable("country") String country) {
		return userService.getUserByCountry(country);
	}
	
	@GetMapping("/upload/search/{data}")
	public List<User> getUserData(@PathVariable("data") String data){
		return userService.getUserData(data);
	}


}
