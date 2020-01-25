package com.sprhiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprhiber.model.Address;
import com.sprhiber.service.AddressService;
import com.sprhiber.service.StateService;

@Controller
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@ModelAttribute("address")
	public Address fromBackingObject() {
		return new Address();
	}
	@Autowired
	StateService stateService;
	
	@GetMapping("/addressForm")
	public String addressForm(Model model) {
		model.addAttribute("states",stateService.allState());
		return "addressForm";
	}
	
	@PostMapping("/saveAddress")
	public String saveAddress(@RequestParam("state.stateId") Long stateId, @RequestParam("city.cityId") Long cityId, @ModelAttribute Address address) {
		System.out.println(address);
		addressService.save(stateId,cityId,address);
		System.out.println("Saved");
		return "addressSaved";
	}
	
	@GetMapping("/allAddress")
	public String allAddress(Model model) {
		model.addAttribute("addresses", addressService.list());
		System.out.println(addressService.list());
		return "allAddress";
	}
	
}
