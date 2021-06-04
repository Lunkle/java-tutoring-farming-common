package event.stcevent.login;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginSuccess extends STCEvent implements Serializable {

	private static final long serialVersionUID = -8131290834795864995L;

	private long respondingTo;

	public LoginSuccess(long id, long respondingTo) {
		super(id);
		this.respondingTo = respondingTo;
	}

	public long getRespondingTo() {
		return respondingTo;
	}

	@Override
	public String getDescription() {
		return "Successful login";
	}

}
