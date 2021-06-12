package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class SessionClosedResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = 1169306396025596160L;

	public SessionClosedResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String doGetDescription() {
		return "Successfully closed session";
	}

}
