package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class FarmLandNotOwnedResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -4770847606385112672L;

	public FarmLandNotOwnedResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "You don't own this farm land";
	}

}
