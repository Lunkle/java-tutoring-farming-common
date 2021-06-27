package event.stcevent.game;

import event.stcevent.STCEvent;

public class TradePostOverviewResponse extends STCEvent {

	private static final long serialVersionUID = 1836046848164195298L;
	private boolean[][] hasPosting;

	public TradePostOverviewResponse(long id, long respondingTo, boolean[][] hasPosting) {
		super(id, respondingTo);
		this.hasPosting = hasPosting;
	}

	public boolean[][] getHasPosting() {
		return hasPosting;
	}

	@Override
	protected String doGetDescription() {
		String description = "\n=Trades==";
		for (int i = 0; i < hasPosting.length; i++) {
			description += '\n';
			for (int j = 0; j < hasPosting[i].length; j++) {
				description += '{';
				if (hasPosting[i][j]) {
					description += '.';
				} else {
					description += ' ';
				}
				description += '}';
			}
		}
		description += "\n=========";
		return description;
	}
}
