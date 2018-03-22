package PresentationLayer;

import FunctionLayer.ApplicationException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delegate extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws ApplicationException
	{
		try {
			return request.getParameter("page");
		}catch(Exception ex) {
			throw new ApplicationException(ex);
		}
	}
}
