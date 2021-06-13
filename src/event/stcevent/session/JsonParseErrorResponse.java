package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class JsonParseErrorResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = 2710130530331841287L;

	public JsonParseErrorResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Could not recognize json";
	}

}
