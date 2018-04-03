package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.PresentationFacade;

import javax.ejb.Local;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
				int id = rs.getInt("idorders");
				String ld = rs.getString("order_send");
				if( !(ld == null) ) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime ldt = LocalDateTime.parse(ld, dtf);
					Order order = new Order(length, width, height, userId, id, ldt);
					orders.add(order);
				} else {
					Order order = new Order(length, width, height, userId, id);
					orders.add(order);

				} //LocalDatTime ldt = LocalDateTime.parse(rs.getString("order_send");
			}
			return orders;
		}catch(SQLException | ClassNotFoundException ex) {
			throw new OrderSampleException( ex.getMessage() );
		}
	}

	public static Order getOrder(int orderId) throws OrderSampleException {
		try {
			Connection con = Connector.connection();
			String SQL = "Select * FROM orders WHERE idOrders=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int length = rs.getInt("length");
			int width = rs.getInt("width");
			int height = rs.getInt("height");
			int userId = rs.getInt("users_id");
			int id = rs.getInt("idorders");
			Order order = new Order(length, width, height, userId, id);
			return order;
		} catch(SQLException | ClassNotFoundException ex) {
			throw new OrderSampleException( ex. getMessage() );
		}
	}

	public static void addSendTime(Order order, LocalDateTime localDateTime) throws OrderSampleException {
		try {
			Connection con = Connector.connection();
			String sql = "Update orders SET order_send=? WHERE idorders=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, localDateTime.toString() );
			ps.setInt(2, order.getId() );
			ps.executeUpdate();
		} catch(SQLException | ClassNotFoundException ex) {
			throw new OrderSampleException( ex. getMessage() );
		}
	}

}
