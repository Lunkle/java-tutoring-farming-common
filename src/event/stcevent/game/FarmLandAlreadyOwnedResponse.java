package event.stcevent.game;

import event.stcevent.STCEvent;

public class FarmLandAlreadyOwnedResponse extends STCEvent {

	private static final long serialVersionUID = -176038887359566607L;

	public FarmLandAlreadyOwnedResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Farmland already owned";
	}

}
