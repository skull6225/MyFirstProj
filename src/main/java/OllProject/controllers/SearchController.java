package OllProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import OllProject.component.entity.Search;
import OllProject.service.SearchService;

@Controller
public class SearchController {
	@Autowired 
	private SearchService searchService;

	@GetMapping(path="/user")
	@ResponseBody
	public List<String> searchName(@RequestBody Search email) {
		System.out.println(email);
		return searchService.searchName(email);	
	}
	@GetMapping(path="/city")
	@ResponseBody
	public List<String> searchAddress(@RequestBody Search searchAddress) {
		return searchService.searchAddr(searchAddress);	
	}
}
