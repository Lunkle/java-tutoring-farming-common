package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopSellSuccessResponse extends STCEvent {

	private static final long serialVersionUID = -1999185593286483632L;

	public ShopSellSuccessResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Successfully selling items";
	}

}
