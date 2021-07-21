package com.pratikshat.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pratikshat.entity.User;
import com.pratikshat.request.FilterRequest;
import com.pratikshat.request.UserRequest;
import com.pratikshat.response.UserResponse;

public interface UserService {

	public User userUploads(MultipartFile multipartFile, UserRequest user);

	public List<UserResponse> getUser();

	public List<User> getUserByCountry(String country);

	public List<User> getUserData(String data);

	public List<User> getDataByData(FilterRequest filter) throws Exception;

}
