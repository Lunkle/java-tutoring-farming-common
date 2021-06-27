package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class TradeOverviewRequest extends CTSEvent {

	private static final long serialVersionUID = 3726082556196760605L;

	public TradeOverviewRequest(long id) {
		super(id);
	}

	@Override
	protected String doGetDescription() {
		return "Getting trade posting overview";
	}

}
