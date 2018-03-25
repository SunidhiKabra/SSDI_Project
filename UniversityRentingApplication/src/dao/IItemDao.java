package dao;

import java.util.List;

import model.Item;

public interface IItemDao {
	void addItem(Item item);
	List<Item> getItem();
}
