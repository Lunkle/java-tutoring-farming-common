package event.stcevent.game;

import event.stcevent.STCEvent;

public class SowSeedSuccessResponse extends STCEvent {

	private static final long serialVersionUID = -805833691612948920L;

	public SowSeedSuccessResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Successfully sowed seed";
	}

}
