package OllProj.component.repositories;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import OllProj.component.entity.Search;
import OllProj.component.entity.User;

@Repository
public class UserRepository {

	public Scanner scanner;
	public ObjectMapper mapper;
	public List<String> items;

	public User save(User user) {

		   ObjectMapper objectMapper = new ObjectMapper();
		    try {
				objectMapper.writeValue(new FileWriter("fileName.json",true), user);
		        scanner = new Scanner(new File("fileName.json"));
				String content = scanner.useDelimiter("\\Z").next();
				String result = content.replaceAll("\\}\\{","},{");
				items = Arrays.asList(result.split("\\s*,\\s*"));
				PrintWriter out = new PrintWriter(new FileWriter("fileName.txt"));
				out.println(items);
			    out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return null;
	}

	public List<String> searchName(Search search) {
		List<String> x = new ArrayList<>();
	    try {
			String searchAll = search.getSearch();
	        mapper = new ObjectMapper();
			List<User> myObjects = mapper.readValue(new File("fileName.txt"), new TypeReference<List<User>>(){});
	    	List<User> resUsers = new ArrayList<User>();
		    for(User user1 : myObjects) {
				 if(user1.getName().equals(searchAll)) {
					 resUsers.add(user1);
				 }
			 }
		    int i = 0;
			 for(User user1 : resUsers) {
				 i++;
				 System.out.println(user1.getEmail());
				 System.out.println(user1.getName());
				 x.add("UUID: "+user1.getId()+" |Name: "+user1.getName()+" |Email: "+user1.getEmail());
			 }
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// TODO Auto-generated method stub
		return x;
	}


	//TODO add methods to work with files
}