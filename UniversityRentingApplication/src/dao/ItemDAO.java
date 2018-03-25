package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utilities.*;

public class ItemDAO implements IItemDAO {

	private ConnectionData conn_data = new ConnectionData();
	

	public ItemDAO(ConnectionData conn_data) {

		// TODO Auto-generated method st
		this.conn_data = conn_data;

	}

	@Override
	public List<IItem> getItems() {
		// TODO Auto-generated method stub
		Connection con = null;
		List<IItem> lstItems = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);

			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM item");
			ResultSet rs = pstmt.executeQuery();
			lstItems = new ArrayList<IItem>();
			while (rs.next()) {
				IItem item = new Item();
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setRent(rs.getFloat("rent"));
				lstItems.add(item);
			}
			stmt.close();
			// releaseConnection(con);

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
		return lstItems;

	}

}