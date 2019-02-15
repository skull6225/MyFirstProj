package OllProj.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OllProj.component.entity.Search;
import OllProj.component.repositories.UserRepository;

@Service
public class SearchService {

	@Autowired
	private UserRepository userRepository;
	
	public List<String> searchName(Search search) {
		System.out.println(search.getSearch());
		return userRepository.searchName(search);
	}
//	public List<String> searchAddress(SearchAddress searchAddress) {
//		System.out.println(searchAddress.getSearchAddress());
//		return userRepository.searchAddress(searchAddress);
//	}


}
