package org.cap.passengermngt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.cap.passengermngt.dao.PassengerDao;
import org.cap.passengermngt.dto.PassengerDto;
import org.cap.passengermngt.entities.Passenger;
import org.cap.passengermngt.exceptions.PassengerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	private PassengerDao passengerDao;

	
	public PassengerDao getPassengerDao() {
		return passengerDao;
	}
	@Autowired
	public void setPassengerDao(PassengerDao passengerDao) {
		this.passengerDao = passengerDao;
	}
	
	@Override
	public Passenger addPassenger(Passenger passenger) {
		passenger = passengerDao.save(passenger);
		return passenger;
	}

	@Override
	public Passenger findPassenger(BigInteger uin) {
		Optional<Passenger> optional = passengerDao.findById(uin);
		if (optional.isPresent()) {
			Passenger passenger = optional.get();
			return passenger;
		}
		throw new PassengerNotFoundException("Passengers not found for UIN=" + uin);
	}
//
//	@Override
//	public List<Passenger> viewAllUsers() {
//		List<User> list = userDao.findAll();
//		return list;
//	}
//
	@Override
	public boolean deletePassenger(BigInteger uin){
		Optional<Passenger> optional = passengerDao.findById(uin);
		if (optional.isPresent()) {
			passengerDao.deleteById(uin);
			return true;
		}
		throw new PassengerNotFoundException("Passengers not found for UIN=" + uin);
		
	}
	
	@Override
	public Passenger updatePassenger(Passenger passenger){
		passenger = passengerDao.save(passenger);
		return passenger;
	}
	
	@Override
	public Passenger setUpdatedDetails(PassengerDto dto){
		Passenger passenger= new Passenger();
		passenger.setPassengerName(dto.getPassengerName());
		passenger.setPassengerAge(dto.getPassengerAge());
		passenger.setPnrNumber(dto.getPnrNumber());
		passenger.setPassegerLuggage(dto.getPassegerLuggage());
		return passenger;
	}
	
}
