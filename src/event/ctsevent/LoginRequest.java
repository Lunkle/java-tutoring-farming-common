package event.ctsevent;

public class LoginRequest extends CTSEvent {

	private String username;
	private String password;

	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected String getUsername() {
		return username;
	}

	protected String getPassword() {
		return password;
	}

	@Override
	public String getDescription() {
		return "Attempting login";
	}

}
