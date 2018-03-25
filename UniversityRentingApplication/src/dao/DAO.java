package dao;

import utilities.ConnectionData;



public class DAO {
	private ConnectionData conn_data = new ConnectionData();
	
	private ItemDAO itemDAO;
	
	public DAO() 
	{
		
		itemDAO = new ItemDAO(conn_data); 

	}
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

}