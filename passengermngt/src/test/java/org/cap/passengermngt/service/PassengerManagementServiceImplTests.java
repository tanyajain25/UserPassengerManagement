package org.cap.passengermngt.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.cap.passengermngt.entities.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(PassengerServiceImpl.class)
public class PassengerManagementServiceImplTests {
	
	@Autowired
	private PassengerService service;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testAddPassenger(){
		BigInteger pnrNumber = BigInteger.valueOf(1012);
		String passengerName= "Mansi";
		Integer passengerAge= 21;
		double passegerLuggage= 14000.00;
		
		Passenger passenger= new Passenger();
		passenger.setPnrNumber(pnrNumber);
		passenger.setPassengerName(passengerName);
		passenger.setPassengerAge(passengerAge);
		passenger.setPassegerLuggage(passegerLuggage);
		
		/*Room result = roomService.save(room);
        List<Room> fetched = entityManager.createQuery("from Room").getResultList();
        Assertions.assertEquals(1, fetched.size());// verifying one got inserted
        Room expected = fetched.get(0);
        Assertions.assertEquals(expected, result);// verifying fetch and stored are equal
        Assertions.assertEquals(floorNo, expected.getFloorNo());
        Assertions.assertEquals(roomNo, expected.getRoomNo());*/
		Passenger result= service.addPassenger(passenger);
		List<Passenger> fetched = entityManager.createQuery("From passengerdetails").getResultList();
		Assertions.assertEquals(1, fetched.size());// verifying one got inserted
	    Passenger expected = fetched.get(0);
	    Assertions.assertEquals(expected, result);// verifying fetch and stored are equal
	    Assertions.assertEquals(pnrNumber, expected.getPnrNumber());
        Assertions.assertEquals(passengerName, expected.getPassengerName());
        Assertions.assertEquals(passengerAge, expected.getPassengerAge());
        Assertions.assertEquals(passegerLuggage, expected.getPassegerLuggage());
        	
	}
}
