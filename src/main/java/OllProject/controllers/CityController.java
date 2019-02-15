package OllProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import OllProject.component.entity.City;
import OllProject.service.CityService;

@Controller
public class CityController {
	@Autowired 
	private CityService cityService;
	@PostMapping(path="/city")
	public @ResponseBody City addNewCity (@RequestBody  City city) {
		return cityService.save(city);		
	}
}