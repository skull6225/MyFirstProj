package OllProject.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OllProject.component.entity.Delete;
import OllProject.component.repositories.UserRepository;

@Service
public class DeleteService {

	@Autowired
	private UserRepository userRepository;
	
	public List<String> deleteUser(Delete email) {
		return userRepository.deleteUser(email);
	}
	public List<String> deleteCity(Delete id) {
		return userRepository.deleteCity(id);
	}


}
