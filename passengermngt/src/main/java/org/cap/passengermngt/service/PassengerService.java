package org.cap.passengermngt.service;

import java.math.BigInteger;
import java.util.List;

import org.cap.passengermngt.dto.PassengerDto;
import org.cap.passengermngt.entities.Passenger;


public interface PassengerService {

	Passenger addPassenger(Passenger passenger);

	Passenger findPassenger(BigInteger uin);

	boolean deletePassenger(BigInteger uin);

	Passenger updatePassenger(Passenger passenger);

	 Passenger setUpdatedDetails(PassengerDto dto);
   
}
