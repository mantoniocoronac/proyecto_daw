package web.dto;

public class UserRegistrationDto {

	private String username;
	private String password;
	private String email;
	private String tlf;
	private String direccion;
	
	public UserRegistrationDto(String username, String password, String email, String tlf, String direccion) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.tlf = tlf;
		this.direccion = direccion;
	}
	
	public UserRegistrationDto() {

	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
