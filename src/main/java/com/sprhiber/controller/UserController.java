package com.sprhiber.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sprhiber.model.User;
import com.sprhiber.service.UserService;

@Controller
/*@Component*/
public class UserController {
	
	@Autowired(required=true)
	private UserService userService;
	
	@ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }
	/*@Autowired
	private UserDao userdao;*/
	@GetMapping("/")
	public String useForm(Model model) {
	//	model.
		model.addAttribute("users", userService.list());
		return "editUsers";
	}
	/*@RequestMapping("/form")
	public String newForm(Locale locale,Model model) {
		model.addAttribute("users", userService.list());
		return "editUsers";
	}*/
	@GetMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
	//	int id=Integer.parseInt(request.getParameter("id"));
		Long id=Long.parseLong(request.getParameter("id"));
		userService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/updateUser")
	public String updateUser(HttpServletRequest request,Model model) {
		Long id=Long.parseLong(request.getParameter("id"));
		User user=userService.getUser(id);
		model.addAttribute("user",user);
		model.addAttribute("users",userService.list());
		return "editUsers";
	}
	
	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") @Valid User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("users",userService.list());
			return "editUsers";
		}
		userService.save(user);
		return "redirect:/";
	}
}
