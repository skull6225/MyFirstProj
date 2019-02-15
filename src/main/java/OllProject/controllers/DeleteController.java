package OllProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import OllProject.component.entity.Delete;
import OllProject.service.DeleteService;;

@Controller
public class DeleteController {
	@Autowired 
	private DeleteService deleteService;

	@DeleteMapping(path="/user")
	@ResponseBody
	public List<String> deleteUser(@RequestBody Delete email) {
		return deleteService.deleteUser(email);	
	}
	@DeleteMapping(path="/city")
	@ResponseBody
	public List<String> deleteCity(@RequestBody Delete id) {
		return deleteService.deleteCity(id);	
	}
}
