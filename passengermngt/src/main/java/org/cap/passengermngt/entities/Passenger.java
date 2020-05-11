package org.cap.passengermngt.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "passengerdetails")
public class Passenger {

	@Id
	@GeneratedValue
	@Column(name = "passenger_uin")
	private BigInteger passengerUIN;

	@Column(name = "pnr_number")
	private BigInteger pnrNumber;

	@Column(name = "passenger_name")
	private String passengerName;

	@Column(name = "passenger_age")
	private Integer passengerAge;

	@Column(name = "passenger_luggage")
	private double passegerLuggage;

	public Passenger() {
		super();
	}

	public Passenger(BigInteger pnrNumber, String passengerName, Integer passengerAge, BigInteger passengerUIN,
			double passegerLuggage) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.passegerLuggage = passegerLuggage;
	}

	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

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

	public double getPassegerLuggage() {
		return passegerLuggage;
	}

	public void setPassegerLuggage(double passegerLuggage) {
		this.passegerLuggage = passegerLuggage;
	}
	
	
	
}
