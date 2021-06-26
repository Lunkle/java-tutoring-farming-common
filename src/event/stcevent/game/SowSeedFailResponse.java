package event.stcevent.game;

import event.stcevent.STCEvent;

@Deprecated
public class SowSeedFailResponse extends STCEvent {

	private static final long serialVersionUID = 29608008849065570L;
	private String failReason;

	public SowSeedFailResponse(long id, long respondingTo, String failReason) {
		super(id, respondingTo);
		this.failReason = failReason;
	}

	public String getFailReason() {
		return failReason;
	}

	@Override
	protected String doGetDescription() {
		return "Failed to sow seed\n " + failReason;
	}

}
