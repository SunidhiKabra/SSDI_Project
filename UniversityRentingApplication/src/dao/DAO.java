package dao;

import utilities.ConnectionData;



public class DAO {
	private ConnectionData conn_data = new ConnectionData();
	
	private ItemDao itemDAO;
	
	public DAO() 
	{
		
		itemDAO = new ItemDao(conn_data); 

	}
	public ItemDao getItemDAO() {
		return itemDAO;
	}

}