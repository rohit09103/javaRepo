/**
 * 
 */
package com.localost.spring.cloud.roomreservation.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.localost.spring.cloud.roomreservation.GuestClient;
import com.localost.spring.cloud.roomreservation.ReservationClient;
import com.localost.spring.cloud.roomreservation.RoomClient;
import com.localost.spring.cloud.roomreservation.bean.Guest;
import com.localost.spring.cloud.roomreservation.bean.Reservation;
import com.localost.spring.cloud.roomreservation.bean.Room;
import com.localost.spring.cloud.roomreservation.bean.RoomReservation;

/**
 * @author rohit
 * @date 07-Apr-2020
 */
@RestController
@RequestMapping("room-reservation")
public class RoomReservationController {

	private final RoomClient roomClient;
	private final GuestClient guestClient;
	private final ReservationClient reservationClient;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public RoomReservationController(RoomClient roomClient,GuestClient guestClient,ReservationClient reservationClient) {
		this.roomClient = roomClient;
		this.guestClient = guestClient;
		this.reservationClient = reservationClient;
	}

	@GetMapping
	public List<RoomReservation> getRoomReservations(@RequestParam(name = "date",required = false) String dateString) {
		List<Room> rooms = this.roomClient.getAllRooms();
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		rooms.forEach(room -> {
			roomReservationMap.put(room.getId(), new RoomReservation(room.getId(), room.getRoomNumber(), room.getRoomName()));
		});
		Date date = createDateFromDateString(dateString);
		List<Reservation> reservations = this.reservationClient.getAllReservations(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestClient.getGuest(reservation.getGuestId());
            roomReservation.setGuestId(guest.getId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });
		return new ArrayList<>(roomReservationMap.values());
	}

//	private List<Room> getAllRooms() {
//		ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange("http://ROOMSERVICES/rooms",
//				HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
//				});
//		return roomResponse.getBody();
//	}
	
	private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null != dateString){
            try{
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}
