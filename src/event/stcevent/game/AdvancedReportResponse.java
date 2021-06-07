package event.stcevent.game;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import event.stcevent.STCEvent;

public class AdvancedReportResponse extends STCEvent {

	private static final int MILLISECONDS_PER_MINUTE = 60000;
	private static final int MILLISECONDS_PER_HOUR = 3600000;
	private static final int MILLISECONDS_PER_DAY = 86400000;
	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year, month, day;
	private long paymentTime;
	private long[] sessionEnds, sessionLengths;
	private double[] efficiencies;
	private long[] harvests, expenses;
	private String[][] harvestItems, expenseItems;
	private int[][] harvestAmounts, expenseAmounts;

	public AdvancedReportResponse(long id, long respondingTo, long paymentTime,
			int year, int month, int day,
			long[] sessionEnds, long[] sessionLengths, double[] efficiencies,
			long[] harvests, String[][] harvestItems, int[][] harvestAmounts,
			long[] expenses, String[][] expenseItems, int[][] expenseAmounts) {
		super(id, respondingTo);
		this.paymentTime = paymentTime;
		this.year = year;
		this.month = month;
		this.day = day;
		this.sessionEnds = sessionEnds;
		this.sessionLengths = sessionLengths;
		this.efficiencies = efficiencies;
		this.harvests = harvests;
		this.harvestItems = harvestItems;
		this.harvestAmounts = harvestAmounts;
		this.expenses = expenses;
		this.expenseItems = expenseItems;
		this.expenseAmounts = expenseAmounts;
	}

	@Override
	public String getDescription() {
		long grossHarvest = 0, grossExpenses = 0, totalActive = 0, efficienctTimeSum = 0;
		for (int i = 0; i < sessionLengths.length; i++) {
			grossHarvest += harvests[i];
			grossExpenses += expenses[i];
			totalActive += sessionLengths[i];
			efficienctTimeSum += sessionLengths[i] * efficiencies[i];
		}
//		long grossExpenses = 0, 
		double averageEfficiency = efficienctTimeSum / (double) totalActive;
		String string = "\n==================================Advanced Report================================="
				+ "\nAdvanced report type for " + MONTHS[month - 1] + " " + day + ", " + year
				+ "\nPaid for on " + millisToDate(paymentTime)
				+ "\nNumber of sessions completed: " + sessionLengths.length
				+ "\nGross harvest value: " + grossHarvest + " gold coins"
				+ "\nGross expense value: " + grossExpenses + " gold coins"
				+ "\nNet harvest value: " + (grossHarvest - grossExpenses) + " gold coins"
				+ "\nActive time: " + totalActive / MILLISECONDS_PER_HOUR + "h "
				+ (totalActive % MILLISECONDS_PER_HOUR) / MILLISECONDS_PER_MINUTE + "m "
				+ (totalActive % MILLISECONDS_PER_MINUTE) / 1000 + "s"
				+ "\nAverage Efficiency: " + formatDecimal(100 * averageEfficiency) + "%"
				+ "\nTotal Yield:"
				+ "\n\t========Total Yield=========";
		Map<String, Integer> harvest = getTotalHarvest();
		for (String item : harvest.keySet()) {
			string += "\n\t" + harvest.get(item) + "x " + item;
		}
		string += "\n\t============================\n\n";
		string += drawGraph();
		return string;
	}

	private String drawGraph() {
		String string = "";
		double[] amounts = getAmounts();
		double max = max(amounts);
		for (double scale = Math.max(max, 20); scale > 0; scale -= 1) {
			string += "\n" + scale + "\t|";
			for (int hour = 0; hour < 24; hour++) {
				if (amounts[hour] >= scale) {
					string += "[$]";
				} else {
					string += "   ";
				}
			}
		}
		string += "\nvalue/\t -------------------------------------------------------------------------"
				+ "\n  /hour\t  0  1  2  3  4  5  6  7  8  9  10 12 13 14 15 16 17 18 19 20 21 22 23 24 "
				+ "\n==================================================================================";
		return string;
	}

	private Map<String, Integer> getTotalHarvest() {
		Map<String, Integer> harvest = new HashMap<>();
		for (int sessionIndex = 0; sessionIndex < harvestItems.length; sessionIndex++) {
			for (int itemIndex = 0; itemIndex < harvestItems[sessionIndex].length; itemIndex++) {
				Integer prevValue = harvest.get(harvestItems[sessionIndex][itemIndex]);
				if (prevValue == null) {
					prevValue = 0;
				}
				harvest.put(harvestItems[sessionIndex][itemIndex], prevValue + harvestAmounts[sessionIndex][itemIndex]);
			}
		}
		return harvest;
	}

	private String millisToDate(long millis) {
		LocalDateTime localDate = Instant.ofEpochMilli(millis).atZone(ZoneId.of("UTC")).toLocalDateTime();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, HH:mm:ss");
		return localDate.format(dateFormatter);
	}

	private String formatDecimal(double d) {
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		return df.format(d);
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
			if (endHour == startHour) {
				amounts[startHour] += harvests[i];
				continue;
			}
			double rate = harvests[i] / (sessionEnd - sessionStart);
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

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public long getPaymentTime() {
		return paymentTime;
	}

	public long[] getSessionEnds() {
		return sessionEnds;
	}

	public long[] getSessionLengths() {
		return sessionLengths;
	}

	public double[] getEfficiencies() {
		return efficiencies;
	}

	public long[] getHarvests() {
		return harvests;
	}

	public String[][] getHarvestItems() {
		return harvestItems;
	}

	public int[][] getHarvestAmounts() {
		return harvestAmounts;
	}

	public long[] getExpenses() {
		return expenses;
	}

	public String[][] getExpenseItems() {
		return expenseItems;
	}

	public int[][] getExpenseAmounts() {
		return expenseAmounts;
	}

}
