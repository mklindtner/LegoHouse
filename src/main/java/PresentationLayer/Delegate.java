package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delegate extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException
	{
		return request.getParameter("page");
	}
}
