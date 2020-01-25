package com.sprhiber.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprhiber.model.City;
import com.sprhiber.service.CityService;
import com.sprhiber.service.StateService;

@Controller
public class CityStateController {
	
	@Autowired
	CityService cityService;
	
	@Autowired
	StateService stateService;
	private ModelAndView mav;
	@RequestMapping(value = "/cityState", method = RequestMethod.GET)
	public ModelAndView loadState() {
		mav = new ModelAndView();
	    mav.addObject("stateList",stateService.allState() );
	    mav.setViewName("cityState");
	    return mav;
	}
	

	@RequestMapping(value = "/loadCities", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> loadCity(@RequestParam(value = "stateId") Long stateId) throws IllegalStateException {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("stateId = "+stateId);
	   List<String> list=new ArrayList<String>();
	   list.add("--Select City--");
	   list.addAll(cityService.loadCity(stateId));
	   System.out.println(list.size());
	   if(list!=null) {
		   System.out.println("Is Not Null "+list);
		   map.put("message","Data found");
		   map.put("data", list);
	   }
	   System.out.println(list);
	   for (Map.Entry<String, Object> entry : map.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	  
	return map;
	}
	@GetMapping("/stateAndCity")
	public String loadStateCity(Model model) {
		model.addAttribute("stateList",stateService.allState() );
		return "stateAndCity";
	}
	@RequestMapping(value="/loadStateCities",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> loadStateCities(@RequestParam(value="stateId") Long stateId){
		Map<String,Object> map=new HashMap<String,Object>();
		List<City> list=cityService.getCities(stateId);
		if(list!=null) {
			System.out.println("List Is Not Null "+list);
			   map.put("message","Data found");
			   map.put("data", list);
		}
		return map;
	}

}
