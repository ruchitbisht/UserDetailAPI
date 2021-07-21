package com.pratikshat.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pratikshat.entity.User;
import com.pratikshat.repository.UserRepositroy;
import com.pratikshat.request.FilterRequest;
import com.pratikshat.request.UserRequest;
import com.pratikshat.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositroy userRepository;

	public final String uploadLocation = "C:\\Users\\Ruchit\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\Student\\src\\main\\resources\\static\\image";

	@Override
	@Transactional
	public User userUploads(MultipartFile multipartFile, UserRequest user) {

		User user2 = null;
		try {

			Files.copy(multipartFile.getInputStream(),
					Paths.get(uploadLocation + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			// Age Calculation
			user.setAge((long) ((new Date().getYear() + 1900) - (user.getUserDOB().getYear() + 1900)));
			System.out.println(new Date().getYear() + 1900);

			// Image Url
			String url = ServletUriComponentsBuilder.fromCurrentContextPath().path(uploadLocation)
					.path(multipartFile.getOriginalFilename()).toUriString();

			user.setImage(url);

			user2 = new User();
			user2.setFirstName(user.getFirstName());
			user2.setSurname(user.getSurname());
			user2.setCountry(user.getCountry());
			user2.setImage(user.getImage());
			user2.setUserDOB(user.getUserDOB());
			user2.setAge(user.getAge());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRepository.save(user2);
	}

	@Override
	public List<User> getUserByCountry(String country) {
		List<User> user = userRepository.getByCountryContaining(country);
		return user;
	}

	@Override
	public List<UserResponse> getUser() {

		return userRepository.findName();
	}

	@Override
	public List<User> getUserData(String data) {
		System.out.println(userRepository.getData(data).toString());
		List<User> user = userRepository.getData(data);

		System.out.println(user);
		return user;
	}

	@Override
	public List<User> getDataByData(FilterRequest filter) throws Exception {

//		List<User> return null;
//		filter.getFirstName() != null
//		if( Objects.nonNull(filter.getFirstName())) {
//			return userRepository.getDataByFirstName(filter.getFirstName());
//			
//		}else if(filter.getSurname() != null) {
//			u= userRepository.getDataBySurname(filter.getSurname());
//			
//		}else if(filter.getCountry() != null) {
//			u= userRepository.getDataByCountry(filter.getCountry());
//			
//		}else if(filter.getFirstName() !=null && filter.getSurname() !=null) {
//			
//			return userRepository.getDataByFirstNameAndSurname(filter.getFirstName(), filter.getSurname());
//			System.out.println(u);
//		}else if(filter.getFirstName() != null && filter.getCountry() != null) {
//			u= userRepository.getDataByFirstNameAndCountry(filter.getFirstName(), filter.getCountry());
//		}else if(filter.getSurname() !=null && filter.getCountry() !=null) {
//			u= userRepository.getDataBySurameAndCountry(filter.getSurname(), filter.getCountry());
//		}else if(filter.getFirstName() !=null && filter.getSurname() !=null && filter.getCountry() !=null) {
//			u= userRepository.getDataByFirstName_SurnameAndCountry(filter.getFirstName(), filter.getSurname(), filter.getCountry());
//		}else {
//			throw new Exception("Nulll....");
//		}	

		if (filter.getFirstName() != null && filter.getSurname() != null && filter.getCountry() != null) {
			return userRepository.getDataByFirstName_SurnameAndCountry(filter.getFirstName(), filter.getSurname(),
					filter.getCountry());
		}
		if (filter.getSurname() != null && filter.getCountry() != null) {
			return userRepository.getDataBySurameAndCountry(filter.getSurname(), filter.getCountry());
		}
		if (filter.getFirstName() != null && filter.getCountry() != null) {
			System.out.println("here");
			return userRepository.getDataByFirstNameAndCountry(filter.getFirstName(), filter.getCountry());
		}
		if (filter.getFirstName() != null && filter.getSurname() != null) {
			return userRepository.getDataByFirstNameAndSurname(filter.getFirstName(), filter.getSurname());
		}
		if (filter.getCountry() != null) {
			return userRepository.getDataByCountry(filter.getCountry());
		}
		if (filter.getSurname() != null) {
			return userRepository.getDataBySurname(filter.getSurname());
		}
		if (Objects.nonNull(filter.getFirstName())) {
			System.out.println("here is");
			return userRepository.getDataByFirstName(filter.getFirstName());
		} else {
			throw new Exception("Nulll....");
		}

	}

}
