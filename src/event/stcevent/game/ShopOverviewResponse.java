package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopOverviewResponse extends STCEvent {

	private static final long serialVersionUID = -8016580920617417002L;
	private boolean[][] hasItem;
	private boolean[][] isSold;

	public ShopOverviewResponse(long id, long respondingTo, boolean[][] hasItem, boolean[][] isSold) {
		super(id, respondingTo);
		this.hasItem = hasItem;
		this.isSold = isSold;
	}

	public boolean[][] getHasItem() {
		return hasItem;
	}

	public boolean[][] getIsSold() {
		return isSold;
	}

	@Override
	protected String doGetDescription() {
		String description = "\n==Shop===";
		for (int i = 0; i < hasItem.length; i++) {
			description += '\n';
			for (int j = 0; j < hasItem[i].length; j++) {
				description += '{';
				if (hasItem[i][j] && isSold[i][j]) {
					description += '!';
				} else if (hasItem[i][j]) {
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
