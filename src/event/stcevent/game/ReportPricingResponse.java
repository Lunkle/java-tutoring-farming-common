package event.stcevent.game;

import event.stcevent.STCEvent;

public class ReportPricingResponse extends STCEvent {

	private static final long serialVersionUID = 29608008849065570L;

	public ReportPricingResponse(long id, long respondingTo, String failReason) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "\n====Report Pricing===="
				+ "\nBasic report: 10 gold coins"
				+ "\nAdvanced report: 15 gold coins"
				+ "\n======================";
	}

}
