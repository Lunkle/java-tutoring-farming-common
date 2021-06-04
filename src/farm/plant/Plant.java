package farm.plant;

import java.io.Serializable;
import java.util.List;

import farm.item.Item;
import farm.item.ItemSlot;

public abstract class Plant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4975112327584955958L;
	private int lifeSpan;

	public int getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public abstract List<ItemSlot<Item>> harvest();

}
