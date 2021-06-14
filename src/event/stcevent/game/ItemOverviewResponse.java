package event.stcevent.game;

import event.stcevent.STCEvent;

public class ItemOverviewResponse extends STCEvent {

	private static final long serialVersionUID = 8551497087266206540L;
	private String description;
	private int value;
	private String growsInto;
	private int nutritionValue;

	public ItemOverviewResponse(long id, long respondingTo, String description, int value, String growsInto, int nutritionValue) {
		super(id, respondingTo);
		this.description = description;
		this.value = value;
		this.growsInto = growsInto;
		this.nutritionValue = nutritionValue;
	}

	@Override
	protected String doGetDescription() {
		String string = "\n===Item Description============"
				+ '\n' + description
				+ "\nValue: " + value + " gold coins";
		if (growsInto != null) {
			string += "\nGrows: " + growsInto
					+ "\nNutrition: " + nutritionValue;
		}
		string += "\n===============================";
		return string;
	}

}