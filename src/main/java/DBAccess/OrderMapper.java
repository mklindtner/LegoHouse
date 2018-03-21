package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
	public static void createOrder(Order order, int userId) throws OrderSampleException
	{
		try {
			Connection        con = Connector.connection();
			String            SQL = "INSERT INTO orders (length, height, width, users_id) VALUES (?, ?, ?, ?)";
			PreparedStatement ps  = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS );
			ps.setInt( 1, order.getLength() );
			ps.setInt( 2, order.getWidth() );
			ps.setInt( 3, order.getHeight() );
			ps.setInt(4, userId);
			ps.executeUpdate();
			ResultSet ids = ps.getGeneratedKeys();
			ids.next();
			int id = ids.getInt( 1 );
			order.setId(id);
		} catch(SQLException | ClassNotFoundException ex) {
			throw new OrderSampleException( ex.getMessage() );
		}
	}

	public static List<Order> displayOrders() throws OrderSampleException {
		List<Order> orders = new ArrayList<>();
		try {
			Connection con = Connector.connection();
			String SQL = "Select * FROM orders";
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int length = rs.getInt("length");
				int width = rs.getInt("width");
				int height = rs.getInt("height");
				int userId = rs.getInt("users_id");
				Order order = new Order(length, width, height, userId);
				orders.add(order);
			}
			return orders;
		}catch(SQLException | ClassNotFoundException ex) {
			throw new OrderSampleException( ex.getMessage() );
		}
	}
}