package com.sprhiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sprhiber.model.State;
import com.sprhiber.service.StateService;

@Controller
public class StateController {
	
	@Autowired(required=true)
	StateService stateService;
	
	@ModelAttribute("state")
	public State fromBackingObject() {
		return new State();
	} 
	@GetMapping("/stateForm")
	public String stateForm(Model model) {
		model.addAttribute("states",stateService.allState());
		return "stateForm";
	}
	@PostMapping("/saveState")
	public String saveState(@ModelAttribute State state) {
			stateService.save(state);
		return "redirect:/stateForm";
	}
}
