package OllProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OllProj.component.entity.User;
import OllProj.component.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		//System.out.println(user.getName());
		//return user;
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return null;
	//return userRepository.findAll();
	}

}
