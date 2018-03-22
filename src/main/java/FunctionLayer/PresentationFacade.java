package FunctionLayer;

import FunctionLayer.LegoCalculator.LegoPieces;

import java.util.Date;

public class PresentationFacade
{
	public static Order calculateBricks(Order order) {
		LegoPieces lego = new LegoPieces(order);
		return lego.calculateHouse();
	}
}
