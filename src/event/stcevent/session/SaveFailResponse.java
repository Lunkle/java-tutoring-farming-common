package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class SaveFailResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -3454063514728355991L;

	public SaveFailResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String doGetDescription() {
		return "Failed save";
	}

}
