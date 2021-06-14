package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopSlotOccupiedResponse extends STCEvent {

	private static final long serialVersionUID = -1665925115907625571L;

	public ShopSlotOccupiedResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Shop slot occupied";
	}

}
