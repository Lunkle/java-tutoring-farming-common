package event.stcevent.login;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginSuccess extends STCEvent implements Serializable {

	private static final long serialVersionUID = -5831927914016495651L;

	public LoginSuccess(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String getDescription() {
		return "Successful login";
	}

}
