package PresentationLayer;

import FunctionLayer.ApplicationException;
import FunctionLayer.OrderSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FunctionLayer.*;

import java.time.LocalDateTime;

public class OrderTime extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws ApplicationException
	{
		try {
			HttpSession session = request.getSession();
			LogicFacade.addSendDate((Order) session.getAttribute("order"), LocalDateTime.now());
			return "orderpage";
		} catch (OrderSampleException ex) {
			throw new ApplicationException(ex);
		}
	}
}
