package org.cap.usermngt.dao;

import java.math.BigInteger;

import org.cap.usermngt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, BigInteger>{

	
}
