package event.stcevent.game;

import event.stcevent.STCEvent;

public class TextResponse extends STCEvent {

	private static final long serialVersionUID = 8551497087266206540L;
	private String description;

	public TextResponse(long id, long respondingTo, String description) {
		super(id, respondingTo);
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}

}