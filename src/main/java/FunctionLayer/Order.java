package FunctionLayer;

import FunctionLayer.LegoCalculator.BrickList;
import FunctionLayer.LegoCalculator.LegoPieces;

import java.time.LocalDateTime;

public class Order
{
	private int height, width, length, id, userId; //set id explicity in orderMapper
	private BrickList brickList;
	private final LocalDateTime localDateTime;

	public Order(int height, int width, int length, int userId) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.userId = userId;
		localDateTime = LocalDateTime.now();
	}

	public Order(int height, int width, int length, int userId, int id) {
		this(height, width, length, userId);
		this.id = id;
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

	public BrickList getBrickList()
	{
		return this.brickList;
	}

	public void setBrickList(BrickList brickList)
	{
		this.brickList = brickList;
	}

	public LocalDateTime getLocalDateTime()
	{
		return this.localDateTime;
	}
}
