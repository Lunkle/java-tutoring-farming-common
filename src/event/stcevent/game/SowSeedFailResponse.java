package event.stcevent.game;

import event.stcevent.STCEvent;

public class SowSeedFailResponse extends STCEvent {

	private static final long serialVersionUID = -805833691612948920L;
	private String failReason;

	public SowSeedFailResponse(long id, long respondingTo, String failReason) {
		super(id, respondingTo);
		this.failReason = failReason;
	}

	public String getFailReason() {
		return failReason;
	}

	@Override
	public String getDescription() {
		return "Failed to sow seed\n " + failReason;
	}

}
