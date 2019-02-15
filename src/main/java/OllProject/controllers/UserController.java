package OllProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import OllProject.component.entity.User;
import OllProject.service.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userService;

	@PostMapping(path="/user")
	public @ResponseBody String addNewUser (@RequestBody  User user) {
		return userService.save(user);		
	}

}