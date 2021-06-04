package farm.plant;

import java.io.Serializable;
import java.util.List;

import farm.item.Item;

public abstract class Plant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7760209193281682087L;
	private int lifeSpan;

	public int getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public abstract List<Item> harvest();

}
