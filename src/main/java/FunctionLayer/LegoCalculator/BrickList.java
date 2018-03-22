package FunctionLayer.LegoCalculator;

public class BrickList
{
	private final int longBrick = 4, mediumBrick = 2, smallBrick = 1;
	private int numberOfLongBrik;
	private int numberOfMediumBrick;
	private int numberOfSmallBrick;

	public BrickList(int numberOfLongBrik, int numberOfMediumBrick, int numberOfSmallBrick) {

		this.numberOfLongBrik = numberOfLongBrik;
		this.numberOfMediumBrick = numberOfMediumBrick;
		this.numberOfSmallBrick = numberOfSmallBrick;
	}

	public int getNumberOfLongBrik()
	{
		return this.numberOfLongBrik;
	}

	public void setNumberOfLongBrik(int numberOfLongBrik)
	{
		this.numberOfLongBrik = numberOfLongBrik;
	}

	public int getNumberOfMediumBrick()
	{
		return this.numberOfMediumBrick;
	}

	public void setNumberOfMediumBrick(int numberOfMediumBrick)
	{
		this.numberOfMediumBrick = numberOfMediumBrick;
	}

	public int getNumberOfSmallBrick()
	{
		return this.numberOfSmallBrick;
	}

	public void setNumberOfSmallBrick(int numberOfSmallBrick)
	{
		this.numberOfSmallBrick = numberOfSmallBrick;
	}
}
