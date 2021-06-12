package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class NotLoggedInResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -2724540564312195067L;

	public NotLoggedInResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String doGetDescription() {
		return "Not logged in yet";
	}

}
