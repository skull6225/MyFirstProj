package OllProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OllProject.component.entity.User;
import OllProject.component.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public String save(User user) {
		//System.out.println(user.getName());
		//return user;
		return userRepository.save(user);
	}
}
