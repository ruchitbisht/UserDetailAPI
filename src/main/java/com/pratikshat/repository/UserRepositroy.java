package com.pratikshat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratikshat.entity.User;
import com.pratikshat.request.UserRequest;
import com.pratikshat.response.UserResponse;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

	@Query("select u from User u where u.country like  %:n% ")
	List<User> getByCountryContaining(@Param("n") String country);

	@Query("select new com.pratikshat.response.UserResponse( concat(u.firstName,' ',u.surname) as fullName,u.country,u.image, u.userDOB,u.age) from User u")
	List<UserResponse> findName();

	
	@Query("select  u from User u where u.firstName like %:data% or u.surname like %:data% or u.country like %:data% or u.id like %:data% ")
	List<User> getData(@Param("data") String data);
	
	
	@Query("select u from User u where u.firstName like %:data%")
	List<User> getDataByFirstName(@Param("data") String data);
	
	
	@Query("Select u from User u where u.surname like %:data%")
	List<User> getDataBySurname(@Param("data") String data);
	
	@Query("Select u from User u where u.country like %:data%")
	List<User> getDataByCountry(String data);
	
	@Query("select u from User u where u.firstName like %:data1% and u.surname like %:data2%")
	List<User> getDataByFirstNameAndSurname(String data1,String data2);
	
	@Query("select u from User u where u.firstName like %:data1% and u.country like %:data2%")
	List<User> getDataByFirstNameAndCountry(String data1,String data2);
	
	@Query("select u from User u where u.surname like %:data1% and u.country like %:data2%")
	List<User> getDataBySurameAndCountry(String data1,String data2);
	
	@Query("select u from User u where u.firstName like %:data1% and u.surname like %:data2% and u.country like %:data3% ")
	List<User> getDataByFirstName_SurnameAndCountry(String data1,String data2,String data3);
	
	
	
	
	
}
