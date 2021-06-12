package event.stcevent.game;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import event.stcevent.STCEvent;

public class BasicReportResponse extends STCEvent {

	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year;
	private int month;
	private int day;
	private int numSessions;
	private long activeTime;
	private double efficiency;
	private String[] harvestItems;
	private int[] harvestAmounts;
	private long paymentTime;

	public BasicReportResponse(long id, long respondingTo, long paymentTime, int year, int month, int day,
			int numSessions, long activeTime, double efficiency, String[] harvestItems, int[] harvestAmounts) {
		super(id, respondingTo);
		this.paymentTime = paymentTime;
		this.year = year;
		this.month = month;
		this.day = day;
		this.numSessions = numSessions;
		this.activeTime = activeTime;
		this.efficiency = efficiency;
		this.harvestItems = harvestItems;
		this.harvestAmounts = harvestAmounts;
	}

	@Override
	public String doGetDescription() {
		String string = "\n============Basic Report============"
				+ "\nBasic report type for " + MONTHS[month - 1] + " " + day + ", " + year
				+ "\nPaid for on " + millisToDate(paymentTime)
				+ "\nNumber of sessions completed: " + numSessions
				+ "\nActive time: " + activeTime / 3600000 + "h " + (activeTime % 3600000) / 60000 + "m " + (activeTime % 60000) / 1000 + "s"
				+ "\nAverage efficiency: " + formatDecimal(100 * efficiency) + "%"
				+ "\nTotal Yield:"
				+ "\n\t========Total Yield=========";
		for (int i = 0; i < harvestItems.length; i++) {
			string += "\n\t" + harvestAmounts[i] + "x " + harvestItems[i];
		}
		string += "\n\t============================"
				+ "\n====================================";
		return string;
	}

	private String millisToDate(long millis) {
		LocalDateTime localDate = Instant.ofEpochMilli(millis).atZone(ZoneId.of("UTC")).toLocalDateTime();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, HH:mm:ss");
		return localDate.format(dateFormatter);
	}

	private String formatDecimal(double d) {
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(d);
	}

}
