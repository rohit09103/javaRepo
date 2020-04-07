/**
 * 
 */
package com.localost.spring.cloud.roomreservation;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.localost.spring.cloud.roomreservation.bean.Guest;

/**
 * @author rohit
 * @date 07-Apr-2020
 */
@FeignClient("guestservices")
public interface GuestClient {
	
	@GetMapping("/guests")
	List<Guest> getAllGuests();
	
	@GetMapping("/guests/{id}")
	Guest getGuest(@PathVariable("id") long id);

}
