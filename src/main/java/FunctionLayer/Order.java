package FunctionLayer;

public class Order
{
	private int height, width, length, id, userId; //set id explicity in orderMapper
	private String typeOrder; //is this stupid?

	public Order(int height, int width, int length, int userId) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.userId = userId;
	}

	/*
	public Order(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}*/

	//use or not?

	public int getUserId() {
		return userId;
	}


	public int getHeight()
	{
		return this.height;
	}

	public int setHeight(int height) {
		return this.height = height;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int setWidth(int width) {
		return this.width = width;
	}

	public int getLength()
	{
		return this.length;
	}

	public int setLength(int length) {
		return this.length = length;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTypeOrder()
	{
		return this.typeOrder;
	}

	public void setTypeOrder(String typeOrder)
	{
		this.typeOrder = typeOrder;
	}
}
