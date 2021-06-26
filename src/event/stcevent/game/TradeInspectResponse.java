package event.stcevent.game;


import event.stcevent.STCEvent;

public class TradeInspectResponse extends STCEvent {

	private static final long serialVersionUID = 7575652991145747380L;
	private static final int MS_PER_MINUTE = 60000;
	private static final int MS_PER_HOUR = 3600000;
	private static final int MS_PER_DAY = 86400000;
	private String settlementName;
	long distance;
	int availableFor;
	String[] buyingItems,sellingItems;
	int[] buyingAmts,sellingAmts;

	public TradeInspectResponse(long id, long respondingTo, String settlementName, long distance, int availableFor,
			                    String[] buyingItems, int[] buyingAmts, String[] sellingItems, int[] sellingAmts) {
		super(id, respondingTo);
		this.settlementName = settlementName;
		this.distance = distance;
		this.availableFor = availableFor;
		this.buyingItems = buyingItems;
		this.buyingAmts = buyingAmts;
		this.sellingItems = sellingItems;
		this.sellingAmts = sellingAmts;
	}

	public String getSettlementName() {
		return settlementName;
	}

	public long getDistance() {
		return distance;
	}

	public int getAvailableFor() {
		return availableFor;
	}
	
	public String[] getBuying() {
		return buyingItems;
	}
	
	public String[] getSelling() {
		return sellingItems;
	}
	
	public int[] getBuyingAmounts() {
		return buyingAmts;
	}
	
	public int[] getSellingAmounts() {
		return sellingAmts;
	}

	@Override
	protected String doGetDescription() {
		int largestBuyLength = 0, largestSellLength = 0;
		for (String item : buyingItems) {
			largestBuyLength = Math.max(item.length(), largestBuyLength);
		}
		for (String item : sellingItems) {
			largestSellLength = Math.max(item.length(), largestSellLength);
		}
		
		String indent = "\t";
		
		String string = "\n===Trade Inspect=============\nLocated in "
				+ settlementName + ", " + distance + "km away.\nAvailable for:" + formatDuration(availableFor) + '\n';
				
				
		string += "Buying:\n";
		for  (int i = 0; i < buyingItems.length; i++) {
			String item = buyingItems[i];
			int amt = buyingAmts[i];
			string += indent;
			string += amt + "x " + item + '\n';
		}

		string += "Selling:\n";
		for  (int i = 0; i < sellingItems.length; i++) {
			String item = sellingItems[i];
			int amt = sellingAmts[i];
			string += indent;
			string += amt + "x " + item + '\n';
		}
		
		string += "============================";
		return string;
	}

	private String formatDuration(long millis) {
		return  millis / MS_PER_DAY + "d "
			   + (millis % MS_PER_DAY) / MS_PER_HOUR + "h "
			   + (millis % MS_PER_HOUR) / MS_PER_MINUTE + "m "
			   + (millis % MS_PER_MINUTE) / 1000 + "s";
	}

}
