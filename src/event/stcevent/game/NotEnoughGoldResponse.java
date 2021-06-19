package event.stcevent.game;

import event.stcevent.STCEvent;

public class NotEnoughGoldResponse extends STCEvent {

	private static final long serialVersionUID = 8179992435185953874L;
	private int requiredGold;

	public NotEnoughGoldResponse(long id, long respondingTo, int requiredGold) {
		super(id, respondingTo);
		this.requiredGold = requiredGold;
	}

	public int getRequiredGold() {
		return requiredGold;
	}

	@Override
	protected String doGetDescription() {
		return "Not enough gold coins\nYou need at least " + getRequiredGold() + " to make this purchase";
	}

}
