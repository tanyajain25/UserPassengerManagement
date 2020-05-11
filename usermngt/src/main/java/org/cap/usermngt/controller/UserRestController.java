package org.cap.usermngt.controller;

import org.cap.usermngt.dto.LoginCredentialsDto;
import org.cap.usermngt.dto.UserDto;
import org.cap.usermngt.entities.User;
import org.cap.usermngt.exceptions.InvalidLoginException;
import org.cap.usermngt.exceptions.UserNotFoundException;
import org.cap.usermngt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

	private static final Logger Log = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody UserDto dto) {
		User user = convertFromDto(dto);
		user = service.addUser(user);
		ResponseEntity<User> reponse = new ResponseEntity<User>(user, HttpStatus.OK);
		return reponse;
	}

	public User convertFromDto(UserDto dto) {
		User user = new User();
		user.setUserType(dto.getUserType());
		user.setUserName(dto.getUserName());
		user.setUserPassword(dto.getUserPassword());
		user.setUserPhone(dto.getUserPhone());
		user.setUserEmail(dto.getUserEmail());
		return user;
	}

	@GetMapping("/getbyuserid/{userId}")
	public ResponseEntity<User> findByUserId(@PathVariable("userId") BigInteger userId) {
		User user = service.viewUser(userId);
		ResponseEntity<User> reponse = new ResponseEntity<User>(user, HttpStatus.OK);
		return reponse;
	}

	@GetMapping("/getall")
	public ResponseEntity<List<User>> fetchAllUsers() {
		List<User> listOfUsers = service.viewAllUsers();
		ResponseEntity<List<User>> reponse = new ResponseEntity<List<User>>(listOfUsers, HttpStatus.OK);
		return reponse;
	}

	@DeleteMapping("/deletebyuserid/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") BigInteger userId) {
		service.deleteUser(userId);
		String message = "Deleted";
		ResponseEntity<String> reponse = new ResponseEntity<String>(message, HttpStatus.OK);
		return reponse;
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
	  User  users = service.updateUser(user);
		ResponseEntity<User> response = new ResponseEntity<>(users, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/validlogin")
	public ResponseEntity<Boolean> checkLoginCredentials(@RequestBody LoginCredentialsDto dto){
		 boolean valid =service.isValidLogin(dto);
		 ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(valid, HttpStatus.OK);
			return response;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException exception) {
		Log.error("User Not Found Exception", exception);
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(InvalidLoginException.class)
	public ResponseEntity<String> handleInvalidLogin(InvalidLoginException exception) {
		Log.error("Invalid Login Exception", exception);
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}
}
