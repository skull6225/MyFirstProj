package OllProj.controllers;


//import java.util.UUID;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class NameController {
//	@RequestMapping("/name")
//	public Name greeting(@RequestParam String name,String lname,String email) {
//        UUID uuid = UUID.randomUUID();
//        return new Name(uuid,String.format(name),String.format(lname),String.format(email));
//    }
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import OllProj.component.entity.User;
import OllProj.service.UserService;

@Controller 
@RequestMapping(path="/demo") 
public class NameController {
	@Autowired 
	private UserService userService;

	@GetMapping(path="/add")
	public @ResponseBody User addNewUser (@RequestBody  User user) {
		return userService.save(user);		
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userService.findAll();
	}
}