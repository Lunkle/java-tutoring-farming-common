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

public class FarmLandAdvancedReportResponse extends STCEvent {

	private static final int MS_PER_MINUTE = 60000;
	private static final int MS_PER_HOUR = 3600000;
	private static final int MS_PER_DAY = 86400000;
	private static final long serialVersionUID = 4526352448249553065L;
	private static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private int year, month, day;
	private long paymentTime;
	private long[] sessionEnds, sessionLengths;
	private double[] efficiencies;
	private int[] harvests, expenses;
	private String[][] harvestItems, expenseItems;
	private int[][] harvestAmounts, expenseAmounts;

	public FarmLandAdvancedReportResponse(long id, long respondingTo, long paymentTime,
			int year, int month, int day,
			long[] sessionEnds, long[] sessionLengths, double[] efficiencies,
			int[] grossHarvests, String[][] harvestItems, int[][] harvestAmounts,
			int[] grossExpenses, String[][] expenseItems, int[][] expenseAmounts) {
		super(id, respondingTo);
		this.paymentTime = paymentTime;
		this.year = year;
		this.month = month;
		this.day = day;
		this.sessionEnds = sessionEnds;
		this.sessionLengths = sessionLengths;
		this.efficiencies = efficiencies;
		this.harvests = grossHarvests;
		this.harvestItems = harvestItems;
		this.harvestAmounts = harvestAmounts;
		this.expenses = grossExpenses;
		this.expenseItems = expenseItems;
		this.expenseAmounts = expenseAmounts;
	}

	@Override
	protected String doGetDescription() {
		String string = generalInfo();
		string += allSessionDetails();
		string += drawGraph();
		return string;
	}

	private String generalInfo() {
		long grossHarvest = 0, grossExpenses = 0, totalActive = 0, efficienctTimeSum = 0;
		for (int i = 0; i < sessionLengths.length; i++) {
			grossHarvest += harvests[i];
			grossExpenses += expenses[i];
			totalActive += sessionLengths[i];
			efficienctTimeSum += sessionLengths[i] * efficiencies[i];
		}
		double averageEfficiency = efficienctTimeSum / (double) totalActive;
		String string = "\n===Advanced Report================================================================"
				+ "\nAdvanced report for:         \t" + MONTHS[month - 1] + " " + day + ", " + year
				+ "\nPurchased on:                \t" + millisToDate(paymentTime)
				+ "\nNumber of sessions completed:\t" + sessionLengths.length
				+ "\nGross harvest value:         \t" + grossHarvest + " gold coins"
				+ "\nGross expense value:         \t" + grossExpenses + " gold coins"
				+ "\nNet harvest value:           \t" + (grossHarvest - grossExpenses) + " gold coins"
				+ "\nActive time:                 \t" + formatDuration(totalActive)
				+ "\nAverage Efficiency:          \t" + formatDecimal4DP(100 * averageEfficiency) + "%"
				+ "\nWasted Time:                 \t" + formatDuration((long) (totalActive * (1 - averageEfficiency)));
		return string;
	}

	private String allSessionDetails() {
		String sessionDetails = "\n";
		for (int i = 0; i < sessionEnds.length; i++) {
			String sessionDetail = "\n\t===Session " + (i + 1)
					+ "======================================================" + repeat(6 - numDigits(i + 1), '=')
					+ "\n\tStart time:        \t" + millisToDate(sessionEnds[i] - sessionLengths[i])
					+ "\n\tSession length:    \t" + formatDuration(sessionLengths[i])
					+ "\n\tEnd time:          \t" + millisToDate(sessionEnds[i])
					+ "\n\tAverage efficiency:\t" + formatDecimal4DP(100 * efficiencies[i]) + "%"
					+ "\n\tWasted Time:       \t" + formatDuration((long) (sessionLengths[i] * (1 - efficiencies[i])))
					+ "\n\t---Harvest-------------|---Expenses------------|---Net Profit----------";
			boolean[] expenseItemUsed = new boolean[expenseItems[i].length];
			for (int itemIndex = 0; itemIndex < harvestItems[i].length; itemIndex++) {
				String harvestItemName = harvestItems[i][itemIndex];
				int harvestItemAmount = harvestAmounts[i][itemIndex];
				int containIndex = contains(expenseItems[i], harvestItemName);
				String harvestText = harvestItemAmount + "x " + harvestItemName;
				sessionDetail += "\n\t" + harvestText + repeat(tabsNeeded(harvestText), '\t');
				if (containIndex != -1) {
					expenseItemUsed[containIndex] = true;
					String expenseText = expenseAmounts[i][containIndex] + "x " + expenseItems[i][containIndex];
					sessionDetail += expenseText + repeat(tabsNeeded(expenseText), '\t');
					if (harvestItemAmount != expenseAmounts[i][containIndex]) {
						sessionDetail += (harvestItemAmount - expenseAmounts[i][containIndex]) + "x " + harvestItemName;
					}
				} else {
					sessionDetail += "\t\t\t";
					sessionDetail += harvestItemAmount + "x " + harvestItemName;
				}
			}
			for (int j = 0; j < expenseItemUsed.length; j++) {
				if (expenseItemUsed[j]) {
					continue;
				}
				sessionDetail += "\n\t\t\t\t";
				String expenseItemName = expenseItems[i][j];
				int expenseItemAmount = expenseAmounts[i][j];
				String expenseText = expenseItemAmount + "x " + expenseItemName;
				sessionDetail += expenseText;
				int numOfTabsNeeded = tabsNeeded(expenseText);
				for (int k = 0; k < numOfTabsNeeded; k++) {
					sessionDetail += '\t';
				}
				sessionDetail += -expenseItemAmount + "x " + expenseItemName;
			}
			sessionDetail += "\n\t-----------------------|-----------------------|-----------------------";
			sessionDetails += sessionDetail;
		}
		sessionDetails += "\n\t===Totals==============================================================";
		sessionDetails += "\n\t---Harvest-------------|---Expenses------------|---Net Profit----------";
		Map<String, Integer> harvest = mapTotal(harvestItems, harvestAmounts), expense;
		expense = mapTotal(expenseItems, expenseAmounts);
		for (String item : harvest.keySet()) {
			int harvestAmount = harvest.get(item);
			String harvestText = harvestAmount + "x " + item;
			sessionDetails += "\n\t" + harvestText + repeat(tabsNeeded(harvestText), '\t');
			Integer expenseAmount = expense.get(item);
			if (expenseAmount != null) {
				expense.remove(item);
				String expenseText = expenseAmount + "x " + item;
				sessionDetails += expenseText + repeat(tabsNeeded(expenseText), '\t');
				if (harvestAmount != expenseAmount) {
					sessionDetails += (harvestAmount - expenseAmount) + "x " + item;
				}
			} else {
				sessionDetails += "\t\t\t" + harvestAmount + "x " + item;
			}
		}
		for (String item : expense.keySet()) {
			String expenseText = expense.get(item) + "x " + item;
			sessionDetails += "\n\t\t\t\t" + expenseText + repeat(tabsNeeded(expenseText), '\t') + "-" + expenseText;
		}
		sessionDetails += "\n\t-----------------------|-----------------------|-----------------------";
		return sessionDetails + "\n\t=======================================================================\n";
	}

	private String drawGraph() {
		String string = "";
		double[] harvestAmounts = hourlyAmounts(harvests);
		double[] expenseAmounts = hourlyAmounts(expenses);
		double max = Math.max(24, max(harvestAmounts) * 1.1);
		for (double scale = max; scale > 0; scale -= max / 24) {
			string += "\n" + formatDecimal1DP(scale) + "\t|";
			for (int hour = 0; hour < 24; hour++) {
				if (expenseAmounts[hour] >= scale) {
					string += "[-]";
				} else if (harvestAmounts[hour] >= scale) {
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

	private int tabsNeeded(String text) {
		return (24 - text.length()) / 8 + (text.length() % 8 == 0 ? 0 : 1);
	}

	private String repeat(int amount, char character) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < amount; i++) {
			sb.append(character);
		}
		return sb.toString();
	}

	private int numDigits(int number) {
		return (int) (Math.log10(number) + 1);
	}

	private static int contains(String[] items, String item) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	private Map<String, Integer> mapTotal(String[][] items, int[][] amounts) {
		Map<String, Integer> harvest = new HashMap<>();
		for (int sessionIndex = 0; sessionIndex < items.length; sessionIndex++) {
			for (int itemIndex = 0; itemIndex < items[sessionIndex].length; itemIndex++) {
				Integer prevValue = harvest.get(items[sessionIndex][itemIndex]);
				if (prevValue == null) {
					prevValue = 0;
				}
				harvest.put(items[sessionIndex][itemIndex], prevValue + amounts[sessionIndex][itemIndex]);
			}
		}
		return harvest;
	}

	private String formatDuration(long millis) {
		return millis / MS_PER_HOUR + "h "
				+ (millis % MS_PER_HOUR) / MS_PER_MINUTE + "m "
				+ (millis % MS_PER_MINUTE) / 1000 + "s";
	}

	private String millisToDate(long millis) {
		LocalDateTime localDate = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm:ss a");
		return localDate.format(dateFormatter);
	}

	private String formatDecimal4DP(double d) {
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(d);
	}

	private String formatDecimal1DP(double d) {
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(d);
	}

	private double max(double[] amounts) {
		double maxSoFar = amounts[0];
		for (int i = 1; i < 24; i++) {
			maxSoFar = Math.max(maxSoFar, amounts[i]);
		}
		return maxSoFar;
	}

	private double[] hourlyAmounts(int[] array) {
		double[] amounts = new double[24];
		for (int i = 0; i < sessionEnds.length; i++) {
			double sessionEnd = hourOfDay(sessionEnds[i]);
			double sessionStart = hourOfDay(sessionEnds[i] - sessionLengths[i]);
			int endHour = (int) Math.floor(sessionEnd);
			int startHour = (int) Math.floor(sessionStart);
			if (endHour == startHour) {
				amounts[startHour] += array[i];
				continue;
			}
			double rate = array[i] / (sessionEnd - sessionStart);
			if (startHour >= 0) {
				amounts[startHour] += rate * (1 - (sessionStart - startHour));
			}
			amounts[endHour] += rate * (sessionEnd - endHour);
			for (int hour = startHour + 1; hour < endHour; hour++) {
				if (hour >= 0) {
					amounts[hour] += rate;
				}
			}
		}
		return amounts;
	}

	private double hourOfDay(long time) {
		return (time % MS_PER_DAY) / (double) MS_PER_HOUR;
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

	public int[] getHarvests() {
		return harvests;
	}

	public String[][] getHarvestItems() {
		return harvestItems;
	}

	public int[][] getHarvestAmounts() {
		return harvestAmounts;
	}

	public int[] getExpenses() {
		return expenses;
	}

	public String[][] getExpenseItems() {
		return expenseItems;
	}

	public int[][] getExpenseAmounts() {
		return expenseAmounts;
	}

}
