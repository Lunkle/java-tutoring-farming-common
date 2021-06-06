package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ReportPricingRequest extends CTSEvent {

	private static final long serialVersionUID = 4526352448249553065L;

	public ReportPricingRequest(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Asking about pricing";
	}

}
