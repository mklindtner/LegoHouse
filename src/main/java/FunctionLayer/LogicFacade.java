package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.io.PrintWriter;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static Order createOrder( int length, int width, int height, int userId ) throws OrderSampleException {
    	Order order = new Order(length, width, height, userId);
		OrderMapper.createOrder( order, userId );
		return order;
	}

	public static List<Order> showOrder() throws OrderSampleException {
    	return OrderMapper.displayOrders();
	}


}
