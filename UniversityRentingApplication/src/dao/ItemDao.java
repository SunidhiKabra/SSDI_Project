package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Item;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class ItemDao implements IItemDao{

	private ConnectionData conn_data = new ConnectionData();
	
	public ItemDao(){
		
	}
	
	@Override
	public void addItem(Item item) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			String sql = "Insert into item(itemName, itemDescription, itemRent) values (?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, item.getItemName());
			statement.setString(2, item.getItemDescription());
			statement.setString(3, item.getItemRent());
			statement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Item> getItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
