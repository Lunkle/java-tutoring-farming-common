package event.ctsevent;

public class LoginRequest extends CTSEvent {

	private String username;
	private String password;

	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getDescription() {
		return "Attempting login";
	}

}
