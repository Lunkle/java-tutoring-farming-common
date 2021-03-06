package event.stcevent.game;

import event.stcevent.STCEvent;

public class ItemOverviewResponse extends STCEvent {

	private static final long serialVersionUID = 8623771894111164440L;
	private static final int MS_PER_MINUTE = 60000;
	private static final int MS_PER_HOUR = 3600000;
	private String description;
	private int value;
	private String growsInto;
	private int nutritionValue;
	private long sellsIn;
	private long growsIn;
	private String[] recipeItems;
	private int[] recipeAmounts;

	public ItemOverviewResponse(long id, long respondingTo, String description,
			int value, long sellsIn,
			String growsInto, long growsIn, int nutritionValue,
			String[] recipeItems, int[] recipeAmounts) {
		super(id, respondingTo);
		this.description = description;
		this.value = value;
		this.sellsIn = sellsIn;
		this.growsInto = growsInto;
		this.growsIn = growsIn;
		this.nutritionValue = nutritionValue;
		this.recipeItems = recipeItems;
		this.recipeAmounts = recipeAmounts;
	}

	@Override
	protected String doGetDescription() {
		String string = "\n===Item Description================"
				+ '\n' + description
				+ "\nValue: " + value + " gold coins"
				+ "\nSells in: " + formatDuration(sellsIn);
		if (growsInto != null) {
			string += "\nGrows: " + growsInto
					+ "\nGrows in: " + formatDuration(growsIn);
		}
		if (nutritionValue != 0) {
			string += "\nNutrition: " + nutritionValue;
		}
		if (recipeItems.length != 0) {
			string += "\n\t===Recipe======================";
			for (int i = 0; i < recipeItems.length; i++) {
				string += "\n\t" + recipeAmounts[i] + "x " + recipeItems[i];
			}
			string += "\n\t===============================";
		}
		string += "\n===================================";
		return string;
	}

	private String formatDuration(long millis) {
		return millis / MS_PER_HOUR + "h "
				+ (millis % MS_PER_HOUR) / MS_PER_MINUTE + "m "
				+ (millis % MS_PER_MINUTE) / 1000 + "s";
	}

}