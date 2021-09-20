package event.stcevent.game;

import event.stcevent.STCEvent;

public class FarmLandPurchaseSuccessResponse extends STCEvent {

	private static final long serialVersionUID = 1276653459813505505L;

	public FarmLandPurchaseSuccessResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Successfully bought farmland";
	}

}
