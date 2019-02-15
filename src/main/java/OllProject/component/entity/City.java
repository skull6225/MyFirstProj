package OllProject.component.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity 
public class City {
    
    private String Type = "Address";
	
	@Id
    private UUID id = UUID.randomUUID();
    
    private String City;

    private String Home;
    
    public String getAddress() {
		return Type;
	}

	public void setAddress(String Type) {
		this.Type = Type;
	}

	public UUID getUUID() {
		return id;
	}

	public void setUUID(UUID id) {
		this.id = id;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getHome() {
		return Home;
	}

	public void setHome(String Home) {
		this.Home = Home;
	}
	
}