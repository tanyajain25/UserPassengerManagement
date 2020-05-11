package org.cap.passengermngt.dao;

import java.math.BigInteger;

import org.cap.passengermngt.entities.Passenger; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, BigInteger>{

}
