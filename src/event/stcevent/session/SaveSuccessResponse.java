package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class SaveSuccessResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -5831927914016495651L;

	public SaveSuccessResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Successful save";
	}

}
