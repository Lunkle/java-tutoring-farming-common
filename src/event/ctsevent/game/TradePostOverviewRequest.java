package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class TradePostOverviewRequest extends CTSEvent {

	private static final long serialVersionUID = 3726082556196760605L;

	public TradePostOverviewRequest(long id) {
		super(id);
	}

	@Override
	protected String doGetDescription() {
		return "Getting trade posting overview";
	}

}
