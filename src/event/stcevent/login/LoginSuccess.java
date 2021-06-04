package event.stcevent.login;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginSuccess extends STCEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8131290834795864995L;

	public LoginSuccess(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Successful login";
	}

}
