package event.stcevent.game;

import event.stcevent.STCEvent;

public class AdvancedReportResponse extends STCEvent {

	private static final int MILLISECONDS_PER_MINUTE = 60000;
	private static final int MILLISECONDS_PER_HOUR = 3600000;
	private static final int MILLISECONDS_PER_DAY = 86400000;
	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year;
	private int month;
	private int day;
	private long[] sessionEnds;
	private long[] sessionLengths;
	private long[] wastedTimes;
	private long[] netHarvests;
	private String[] harvestItems;
	private int[] harvestAmounts;

	public AdvancedReportResponse(long id, long respondingTo, int year, int month, int day,
			long[] sessionEnds, long[] sessionLengths, long[] wastedTimes,
			long[] netHarvests, String[] harvestItems, int[] harvestAmounts) {
		super(id, respondingTo);
		this.year = year;
		this.month = month;
		this.day = day;
		this.sessionEnds = sessionEnds;
		this.sessionLengths = sessionLengths;
		this.wastedTimes = wastedTimes;
		this.netHarvests = netHarvests;
		this.harvestItems = harvestItems;
		this.harvestAmounts = harvestAmounts;
	}

	public static void main(String[] args) {
		AdvancedReportResponse advancedReportResponse = new AdvancedReportResponse(0, 0, 2001, 12, 21,
				new long[] { 3500000, 7400000 }, new long[] { 3500000, 7400000 }, new long[] { 1, 3 },
				new long[] { 0, 3 }, new String[] { "a", "b" }, new int[] { 1, 2 });
		System.out.println(advancedReportResponse.getDescription());
	}

	@Override
	public String getDescription() {
		long totalActive = sum(sessionLengths);
		long totalWasted = sum(wastedTimes);
		long totalNetHarvest = sum(netHarvests);
		String string = "\n==================================Advanced Report================================="
				+ "\nAdvanced report type for " + MONTHS[month - 1] + " " + day + ", " + year
				+ "\nNumber of sessions completed: " + sessionLengths.length
				+ "\nNet harvest value: " + totalNetHarvest + " gold coins"
				+ "\nActive time: " + totalActive / MILLISECONDS_PER_HOUR + "h "
				+ (totalActive % MILLISECONDS_PER_HOUR) / MILLISECONDS_PER_MINUTE + "m "
				+ (totalActive % MILLISECONDS_PER_MINUTE) / 1000 + "s"
				+ "\nWasted time: " + totalWasted / MILLISECONDS_PER_HOUR + "h "
				+ (totalWasted % MILLISECONDS_PER_HOUR) / MILLISECONDS_PER_MINUTE + "m "
				+ (totalWasted % MILLISECONDS_PER_MINUTE) / 1000 + "s"
				+ "\nTotal Yield:"
				+ "\n\t========Total Yield=========";
		for (int i = 0; i < harvestItems.length; i++) {
			string += "\n\t" + harvestAmounts[i] + "x " + harvestItems[i];
		}
		string += "\n\t============================\n\n";
		double[] amounts = getAmounts();
		double max = max(amounts);
		for (double scale = Math.max(max, 10); scale > 0; scale -= 0.5) {
			string += "\n" + scale + "\t|";
			for (int hour = 0; hour < 24; hour++) {
				if (amounts[hour] >= scale) {
					string += "[$]";
				} else {
					string += "   ";
				}
			}
		}
		string += "\nvalue/\t -------------------------------------------------------------------------";
		string += "\n  /hour\t  0  1  2  3  4  5  6  7  8  9  10 12 13 14 15 16 17 18 19 20 21 22 23 24 ";
		string += "\n==================================================================================";
		return string;
	}

	private long sum(long[] arr) {
		long sum = 0;
		for (long l : arr) {
			sum += l;
		}
		return sum;
	}

	private double max(double[] amounts) {
		double maxSoFar = amounts[0];
		for (int i = 1; i < 24; i++) {
			maxSoFar = Math.max(maxSoFar, amounts[i]);
		}
		return maxSoFar;
	}

	private double[] getAmounts() {
		double[] amounts = new double[24];
		for (int i = 0; i < sessionEnds.length; i++) {
			double sessionEnd = hourOfDay(sessionEnds[i]);
			double sessionStart = hourOfDay(sessionEnds[i] - sessionLengths[i]);
			int endHour = (int) Math.floor(sessionEnd);
			int startHour = (int) Math.floor(sessionStart);
			System.out.println(endHour + " " + startHour);
			if (endHour == startHour) {
				amounts[startHour] += netHarvests[i];
				continue;
			}
			double rate = netHarvests[i] / (sessionEnd - sessionStart);
			amounts[startHour] += rate * (1 - (sessionStart - startHour));
			amounts[endHour] += rate * (sessionEnd - endHour);
			for (int hour = startHour + 1; hour < endHour; hour++) {
				amounts[hour] += rate;
			}
		}
		return amounts;
	}

	private double hourOfDay(long time) {
		return (time % MILLISECONDS_PER_DAY) / (double) MILLISECONDS_PER_HOUR;
	}

}
