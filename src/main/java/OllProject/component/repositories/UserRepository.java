package OllProject.component.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import OllProject.component.entity.City;
import OllProject.component.entity.Delete;
import OllProject.component.entity.Search;
import OllProject.component.entity.User;


@Repository
public class UserRepository {

	public Scanner scanner;
	public ObjectMapper mapper;
	public List<String> items;
//-----------------------------------------------------------------------------------------------------------------------
	public String save(User user) {
		boolean pruf = true;

		   ObjectMapper objectMapper = new ObjectMapper();
		   user.getEmail();
		   if ((new File("fileName.txt")).exists() == false) {
			   try {
				new FileWriter("fileName.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   } 
		    try {
		    	BufferedReader br = new BufferedReader(new FileReader("fileName.txt")); 
		    	List<User> myObjects = null;
	    		boolean empyFile = false;
		    	boolean valid = EmailValidator.getInstance().isValid(user.getEmail());

		    	if (br.readLine() != null) {
		    		mapper = new ObjectMapper();
		    		myObjects = mapper.readValue(new File("fileName.txt"), new TypeReference<List<User>>(){});
		    		for(User qwe : myObjects) {
		    			if(qwe.getEmail().equals(user.getEmail()) != false) {
					    	pruf = false;
				    	}
					 }
		    	}
		    	else if(valid == true){
		    		objectMapper.writeValue(new FileWriter("fileName.json",true), user);
			        scanner = new Scanner(new File("fileName.json"));
					String content = scanner.useDelimiter("\\Z").next();
					String result = content.replaceAll("\\}\\{","},{");
					items = Arrays.asList(result.split("\\s*,\\s*"));
					PrintWriter out = new PrintWriter(new FileWriter("fileName.txt"));
					out.println(items);
				    out.close();
				    empyFile = true;
				}
		    	
		    	if(pruf == true && valid == true && empyFile == false) {
		    	objectMapper.writeValue(new FileWriter("fileName.json",true), user);
		        scanner = new Scanner(new File("fileName.json"));
				String content = scanner.useDelimiter("\\Z").next();
				String result = content.replaceAll("\\}\\{","},{");
				items = Arrays.asList(result.split("\\s*,\\s*"));
				PrintWriter out = new PrintWriter(new FileWriter("fileName.txt"));
				out.println(items);
			    out.close();
		    	}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    String returnJsonString = "{UUID:"+user.getId()+"}";
		    if (pruf == false)
		    {
		    	return "error";
		    }
		    else {
				return returnJsonString;

			}
	}
//-----------------------------------------------------------------------------------------------------------------------
	public List<String> searchName(Search email) {
		List<String> returnResult = new ArrayList<>();
	    try {
			String searchAll = email.getEmail();
	        mapper = new ObjectMapper();
			List<User> myObjects = mapper.readValue(new File("fileName.txt"), new TypeReference<List<User>>(){});
	    	List<User> resUsers = new ArrayList<User>();
	    	System.out.println();
		    for(User userSearch : myObjects) {
		    	if(userSearch.getUser().equals("User") && userSearch.getEmail().equals(searchAll)) {
		    		resUsers.add(userSearch);
		    	}
			 }
			 for(User user1 : resUsers) {
				 returnResult.add("UUID: "+user1.getId()+" |Name: "+user1.getName()+" |Email: "+user1.getEmail());
			 }
		}  catch (IOException e) {
			e.printStackTrace();
		} 
		return returnResult;
	}
//-----------------------------------------------------------------------------------------------------------------------
	public List<String> searchAddr(Search searchAddress) {
		List<String> returnResult = new ArrayList<>();
	    try {
			String searchAll = searchAddress.getEmail();
	        mapper = new ObjectMapper();
			List<City> myObjects = mapper.readValue(new File("city.txt"), new TypeReference<List<City>>(){});
	    	List<City> resUsers = new ArrayList<City>();
	    	
		    for(City citySearch : myObjects) {
		    	if(citySearch.getAddress().equals("City") && citySearch.getCity().equals(searchAll)) {
		    		resUsers.add(citySearch);
		    	}
			 }
			 for(City user1 : resUsers) {
				 returnResult.add("UUID: "+user1.getUUID()+" |City: "+user1.getCity()+" |Home: "+user1.getAddress());
			 }
		}  catch (IOException e) {
			e.printStackTrace();
		} 
		return returnResult;
	}
//-----------------------------------------------------------------------------------------------------------------------
	public City save(City city) {
		  ObjectMapper objectMapper = new ObjectMapper();
		    try {
				objectMapper.writeValue(new FileWriter("city.json",true), city);
		        scanner = new Scanner(new File("city.json"));
				String content = scanner.useDelimiter("\\Z").next();
				String result = content.replaceAll("\\}\\{","},{");
				items = Arrays.asList(result.split("\\s*,\\s*"));
				PrintWriter out = new PrintWriter(new FileWriter("city.txt"));
				out.println(items);
			    out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
	}
//-----------------------------------------------------------------------------------------------------------------------
	public List<String> deleteCity(Delete deleteCity) {
		  ObjectMapper objectMapper = new ObjectMapper();

		List<String> returnResult = new ArrayList<>();
	    try {
			String searchAll = deleteCity.getDeleteUUID();
	        mapper = new ObjectMapper();
			List<City> myObjects = mapper.readValue(new File("city.txt"), new TypeReference<List<City>>(){});
	    	File fileJson = new File("city.json");
	        fileJson.delete();
	        System.out.println(searchAll);
		    for(City deleteCit : myObjects) {
		    	if(deleteCit.getUUID().equals(searchAll) == false) {
					objectMapper.writeValue(new FileWriter("city.json",true), deleteCit);

		    	}
			 }
	        scanner = new Scanner(new File("city.json"));
			String content = scanner.useDelimiter("\\Z").next();
			String result = content.replaceAll("\\}\\{","},{");
			items = Arrays.asList(result.split("\\s*,\\s*"));
			PrintWriter out = new PrintWriter(new FileWriter("city.txt"));
			out.println(items);
		    out.close();

		}  catch (IOException e) {
			e.printStackTrace();
		}
		return returnResult;
		} 
	//delete user from file
//-----------------------------------------------------------------------------------------------------------------------
	public List<String> deleteUser(Delete email) {
		  ObjectMapper objectMapper = new ObjectMapper();

		try {
			String searchAll = email.getDelete();
	        mapper = new ObjectMapper();
			List<User> myObjects = mapper.readValue(new File("fileName.txt"), new TypeReference<List<User>>(){});
	    	File fileJson = new File("fileName.json");
	        fileJson.delete();
		    for(User deleteUser : myObjects) {
		    	if(deleteUser.getEmail().equals(searchAll) == false) {
					objectMapper.writeValue(new FileWriter("fileName.json",true), deleteUser);

		    	}
			 }
	        scanner = new Scanner(new File("fileName.json"));
			String content = scanner.useDelimiter("\\Z").next();
			String result = content.replaceAll("\\}\\{","},{");
			items = Arrays.asList(result.split("\\s*,\\s*"));
			PrintWriter out = new PrintWriter(new FileWriter("fileName.txt"));
			out.println(items);
		    out.close();

		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// TODO Auto-generated method stub
		return null;
	}

	//TODO add methods to work with files
}