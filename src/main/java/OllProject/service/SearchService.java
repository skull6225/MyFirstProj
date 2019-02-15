package OllProject.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OllProject.component.entity.Search;
import OllProject.component.repositories.UserRepository;

@Service
public class SearchService {

	@Autowired
	private UserRepository userRepository;
	
	public List<String> searchName(Search email) {
		System.out.println(email.getEmail());
		return userRepository.searchName(email);
	}
	public List<String> searchAddr(Search searchAddress) {
		System.out.println(searchAddress.getEmail());
		return userRepository.searchAddr(searchAddress);
	}


}
