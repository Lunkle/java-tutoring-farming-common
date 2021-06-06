package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ReportPurchaseRequest extends CTSEvent {

	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year;
	private int month;
	private int day;
	private String type;

	public ReportPurchaseRequest(long id, int year, int month, int day, String type) {
		super(id);
		this.year = year;
		this.month = month;
		this.day = day;
		this.type = type;
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

	public String getType() {
		return type;
	}

	@Override
	public String getDescription() {
		String string = "Purchasing ";
		String lowerCase = type.toLowerCase();
		if ("basic".equals(lowerCase) || "advanced".equals(lowerCase)) {
			string += lowerCase;
		} else {
			string += "an invalid";
		}
		string += " report type for ";
		if (month <= 12) {
			string += MONTHS[month - 1] + " " + day + ", " + year;
		} else {
			string += " an invalid date";
		}
		return string;
	}

}
