package org.cap.passengermngt.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;

import org.cap.passengermngt.entities.Passenger;

public class PassengerDto {

	private String passengerName;
	private Integer passengerAge;
	private BigInteger pnrNumber;
	private double passegerLuggage;
	
	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public double getPassegerLuggage() {
		return passegerLuggage;
	}

	public void setPassegerLuggage(double passegerLuggage) {
		this.passegerLuggage = passegerLuggage;
	}

}
