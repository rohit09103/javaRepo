/**
 * 
 */
package com.localost.spring.cloud.roomreservation.bean;

import java.util.Date;

/**
 * @author rohit
 * @date 07-Apr-2020
 */
public class RoomReservation {
	
	private long roomId;
	private long guestId;
	private String roomName;
	private String roomNumber;
	private String firstName;
	private String lastName;
	private Date date;
	
	public RoomReservation() {
		// TODO Auto-generated constructor stub
	}
	
	public RoomReservation(long roomId,String roomNumber,String roomName) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomName = roomName;
	}
	/**
	 * @return the roomId
	 */
	public long getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the guestId
	 */
	public long getGuestId() {
		return guestId;
	}
	/**
	 * @param guestId the guestId to set
	 */
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
