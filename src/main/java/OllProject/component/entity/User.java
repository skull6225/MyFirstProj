package OllProject.component.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity 
public class User {

    private String Type = "User";
	
	@Id
    private UUID id = UUID.randomUUID();
    
    private String name;

    private String email;
    
    public String getUser() {
		return Type;
	}

	public void setUser(String Type) {
		this.Type = Type;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}