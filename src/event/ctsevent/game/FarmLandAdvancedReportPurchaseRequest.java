package event.ctsevent.game;

import java.time.ZoneId;

import event.ctsevent.CTSEvent;

public class FarmLandAdvancedReportPurchaseRequest extends CTSEvent {

	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year;
	private int month;
	private int day;
	private ZoneId zoneId = ZoneId.systemDefault();

	public FarmLandAdvancedReportPurchaseRequest(long id, int year, int month, int day) {
		super(id);
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	@Override
	protected String doGetDescription() {
		String string = "Purchasing advanced report for ";
		if (month <= 12) {
			string += MONTHS[month - 1] + " " + day + ", " + year;
		} else {
			string += " an invalid date";
		}
		return string;
	}
}
