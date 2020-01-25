package com.sprhiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sprhiber.model.City;
import com.sprhiber.service.CityService;
import com.sprhiber.service.StateService;

@Controller
public class CityController {

	@Autowired
	CityService cityService;
	
	@Autowired
	StateService stateService;
	@ModelAttribute("city")
	public City fromBackingObject() {
		return new City();
	}
	@GetMapping("/newCityForm")
	public String newCityPage(Model model) {
		
		model.addAttribute("states",stateService.allState());
		model.addAttribute("cities",cityService.allCity());
		return "newCityPage";
	}
	
	@PostMapping("/saveCity")
	public String saveCity(@RequestParam Long stateId,@ModelAttribute City city) {
		System.out.println("Not saved");
//		City city=new City();
	//	city.setCityName(cityName);
		//city.setState(stateId);
//		Long stateId=(Long)state.getStateId();
		cityService.save(stateId,city);
		System.out.println("Saved");
		return "redirect:/newCityForm";
	}
	
}
