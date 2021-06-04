package farm.item;

import java.io.Serializable;

public class ItemSlot<T extends Item> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5477544892470000684L;
	private T item;
	private int amount;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ItemSlot<T> combine(ItemSlot<T> itemSlot) {
		amount += itemSlot.amount;
		return this;
	}

}
