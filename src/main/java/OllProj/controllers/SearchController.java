package OllProj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import OllProj.component.entity.Search;
import OllProj.service.SearchService;

@Controller
public class SearchController {
	@Autowired 
	private SearchService searchService;

	@PostMapping(path="/user")
	@ResponseBody
	public List<String> searchName(@RequestBody Search search) {
		return searchService.searchName(search);	
	}
//	@PostMapping(path="/address")
//	@ResponseBody
//	public List<String> searchAddress(@RequestBody SearchAddress searchAddress) {
//		return searchService.searchAddress(searchAddress);	
//	}
}
