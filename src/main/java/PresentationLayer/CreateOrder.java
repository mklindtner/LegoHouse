package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateOrder extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws OrderSampleException
	{
		int  length = Integer.parseInt(request.getParameter("length"));
		int  width  = Integer.parseInt(request.getParameter("width"));
		int  height = Integer.parseInt(request.getParameter("height"));
		User user   = (User) request.getSession().getAttribute("user");
		if(length == 0 || width == 0 || height == 0 || user == null)
			throw new OrderSampleException("a side cannot be 0");
		LogicFacade.createOrder(length, width, height, user.getId());
		return user.getRole() + "page"; //use order.getTypeOrder()?
	}
}
