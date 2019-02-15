package OllProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OllProject.component.entity.City;
import OllProject.component.repositories.UserRepository;

@Service
public class CityService {

	@Autowired
	private UserRepository userRepository;
	
	public City save(City city) {
		//System.out.println(user.getName());
		//return user;
		System.out.println(city);
		return userRepository.save(city);
	}
}
