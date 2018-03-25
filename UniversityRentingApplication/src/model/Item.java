package model;

public class Item implements IItem{
	String itemName;
	String itemDescription;
	String itemRent;

	public Item(String itemName, String itemDescription, String itemRent) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemRent = itemRent;
	}

	public Item() {
	}

	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public String getItemDescription() {
		return itemDescription;
	}

	@Override
	public String getItemRent() {
		return itemRent;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemRent(String itemRent) {
		this.itemRent = itemRent;
	}

}
