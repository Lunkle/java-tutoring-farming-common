package event.stcevent.game;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import event.stcevent.STCEvent;

public class FarmLandBasicReportResponse extends STCEvent {

	private static final long serialVersionUID = -4333448402500976078L;
	private static final int MS_PER_MINUTE = 60000;
	private static final int MS_PER_HOUR = 3600000;
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

	public FarmLandBasicReportResponse(long id, long respondingTo, long paymentTime, int year, int month, int day,
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

	public static void main(String[] args) {
		long activeTime = 100000000;
		double efficiency = 0.95;
		FarmLandBasicReportResponse response = new FarmLandBasicReportResponse(0, 0, 0, 2021, 6, 12, 13, activeTime, efficiency, new String[0], new int[0]);
		System.out.println(response.getDescription());
	}

	@Override
	protected String doGetDescription() {
		String string = "\n===Basic Report==============================="
				+ "\nBasic report type for:\t" + MONTHS[month - 1] + " " + day + ", " + year
				+ "\nPaid for on:          \t" + millisToDate(paymentTime)
				+ "\nSessions completed:   \t" + numSessions
				+ "\nActive time:          \t" + formatDuration(activeTime)
				+ "\nAverage efficiency:   \t" + formatDecimal(100 * efficiency) + "%"
				+ "\nWasted Time:          \t" + formatDuration((long) (activeTime * (1 - efficiency)))
				+ "\nTotal Yield:"
				+ "\n\t===Total Yield========================";
		for (int i = 0; i < harvestItems.length; i++) {
			string += "\n\t" + harvestAmounts[i] + "x " + harvestItems[i];
		}
		string += "\n\t======================================"
				+ "\n==============================================";
		return string;
	}

	private String millisToDate(long millis) {
		LocalDateTime localDate = Instant.ofEpochMilli(millis).atZone(ZoneId.of("UTC")).toLocalDateTime();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm:ss a");
		return localDate.format(dateFormatter);
	}

	private static String formatDecimal(double d) {
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(d);
	}

	private static String formatDuration(long millis) {
		return millis / MS_PER_HOUR + "h "
				+ (millis % MS_PER_HOUR) / MS_PER_MINUTE + "m "
				+ (millis % MS_PER_MINUTE) / 1000 + "s";
	}

}
