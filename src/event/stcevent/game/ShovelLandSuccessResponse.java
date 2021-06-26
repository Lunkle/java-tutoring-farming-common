package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class ShovelLandSuccessResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -1947440616411562740L;

	public ShovelLandSuccessResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Successfully Shoveled Land Slot";
	}

}
