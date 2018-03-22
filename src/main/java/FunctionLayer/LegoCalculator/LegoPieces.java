package FunctionLayer.LegoCalculator;

import FunctionLayer.Order;

import java.time.LocalDateTime;
import java.util.Date;

public class LegoPieces
{
	private final int longBrick = 4, mediumBrick = 2, smallBrick = 1;
	private Order order;

	public LegoPieces(Order order) {
		this.order = order;
	}

	public Order calculateHouse() {
		//L*2 + (w*2) - (8)
		order.setBrickList(new BrickList(order.getLength()*2, order.getWidth()*2, order.getHeight()*2));
		return order;
	}
}
