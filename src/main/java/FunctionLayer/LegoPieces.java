package FunctionLayer;

public class LegoPieces
{
	private Order order;
	public LegoPieces(Order order) {
		this.order = order;
	}

	public Order calculateHouse() {
		order.setHeight(2);
		order.setWidth(2);
		order.setHeight(2);
		return order;
	}
}
