/**
 * 
 */
package com.localost.spring.cloud.roomreservation;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.localost.spring.cloud.roomreservation.bean.Room;

/**
 * @author rohit
 * @date 07-Apr-2020
 */
@FeignClient("roomservices")
public interface RoomClient {
	
	@GetMapping("/rooms")
	List<Room> getAllRooms();
	
	@GetMapping("/rooms/{id}")
	Room getRoom(@PathVariable("id") long id);

}
