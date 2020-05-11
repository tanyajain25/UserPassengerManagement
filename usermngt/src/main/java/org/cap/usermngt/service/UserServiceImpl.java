package org.cap.usermngt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.cap.usermngt.dao.UserDao;
import org.cap.usermngt.dto.LoginCredentialsDto;
import org.cap.usermngt.entities.User;
import org.cap.usermngt.exceptions.InvalidLoginException;
import org.cap.usermngt.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * addUser(User):User :- Adds a new user. viewUser(BigInteger):User :- Shows the
	 * details of a user identifiable by the user id. viewUser(): List<User> :-
	 * Shows the details of all users. updateUser(User):User :- Updates the details
	 * of a user. deleteUser(BigInteger):void Removes a user as per the user id.
	 * validateUser(User): void :- Validates the attributes of a user.
	 */
	@Override
	public User addUser(User user) {
		user = userDao.save(user);
		return user;
	}

	@Override
	public User viewUser(BigInteger id) {
		Optional<User> optional = userDao.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			return user;
		}
		throw new UserNotFoundException("User not found for id=" + id);
	}

	@Override
	public List<User> viewAllUsers() {
		List<User> list = userDao.findAll();
		return list;
	}

	@Override
	public void deleteUser(BigInteger userId) {
		userDao.deleteById(userId);
	}

	@Override
	public User updateUser(User user) {
		user = userDao.save(user);
		return user;
	}

	public boolean isValidLogin(LoginCredentialsDto valid) {

		Optional<User> optional = userDao.findById(valid.getUserId());
		if (optional.isPresent()) {
			User user = optional.get();
			user.getUserPassword().equals(valid.getPassword());
			return true;
		}

		throw new InvalidLoginException("UserId and Password don't match");

	}
}
