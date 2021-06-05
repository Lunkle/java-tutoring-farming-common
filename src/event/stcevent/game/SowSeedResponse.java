package event.stcevent.game;

import event.stcevent.STCEvent;

public class SowSeedResponse extends STCEvent {

	private static final long serialVersionUID = -805833691612948920L;
	private String plantName;
	private String failReason;
	private boolean success;

	public SowSeedResponse(long id, long respondingTo, String plantName) {
		this(id, respondingTo, plantName, "");
		this.success = true;
	}

	public SowSeedResponse(long id, long respondingTo, String plantName, String failReason) {
		super(id, respondingTo);
		this.plantName = plantName;
		this.failReason = failReason;
		this.success = false;
	}

	@Override
	public String getDescription() {
		if (success) {
			return "Successfully sowed a " + plantName + " seed.";
		}
		return "Failed to sow a " + plantName + " seed. Reason: " + failReason;
	}

}
