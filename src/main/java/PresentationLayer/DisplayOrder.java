package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayOrder extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws OrderSampleException
	{
		HttpSession session = request.getSession();
		session.setAttribute("orders", LogicFacade.showOrder() );
		return "orderpage"; //should this be more generic?
	}
}
