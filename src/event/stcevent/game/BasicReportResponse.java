package event.stcevent.game;

import event.ctsevent.CTSEvent;

public class BasicReportResponse extends CTSEvent {

	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year;
	private int month;
	private int day;
	private int numSessions;
	private long activeTime;
	private long wastedTime;
	private String[] harvestItems;
	private int[] harvestAmounts;

	public BasicReportResponse(long id, int year, int month, int day, int numSessions, long activeTime, long wastedTime, String[] harvestItems, int[] harvestAmounts) {
		super(id);
		this.year = year;
		this.month = month;
		this.day = day;
		this.numSessions = numSessions;
		this.activeTime = activeTime;
		this.wastedTime = wastedTime;
		this.harvestItems = harvestItems;
		this.harvestAmounts = harvestAmounts;
	}

	@Override
	public String getDescription() {
		String string = "\n============Basic Report============"
				+ "\nBasic report type for " + MONTHS[month - 1] + " " + day + ", " + year
				+ "\nNumber of sessions completed: " + numSessions
				+ "\nActive time: " + activeTime / 3600000 + "h " + (activeTime % 3600000) / 60000 + "m " + (activeTime % 60000) / 1000 + "s"
				+ "\nWasted time: " + wastedTime / 3600000 + "h " + (wastedTime % 3600000) / 60000 + "m " + (wastedTime % 60000) / 1000 + "s"
				+ "\nTotal Yield:"
				+ "\n\t========Total Yield=========";
		for (int i = 0; i < harvestItems.length; i++) {
			string += "\n\t" + harvestAmounts[i] + "x " + harvestItems[i];
		}
		string += "\n\t============================"
				+ "\n====================================";
		return string;
	}

}
