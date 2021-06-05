package event.stcevent.game;

import event.stcevent.STCEvent;

public class SowSeedFailResponse extends STCEvent {

	private static final long serialVersionUID = -805833691612948920L;
	private String plantName;
	private String failReason;

	public SowSeedFailResponse(long id, long respondingTo, String plantName, String failReason) {
		super(id, respondingTo);
		this.plantName = plantName;
		this.failReason = failReason;
	}

	@Override
	public String getDescription() {
		return "Failed to sow a " + plantName + " seed. " + failReason;
	}

}
