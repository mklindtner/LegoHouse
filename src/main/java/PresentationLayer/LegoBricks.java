package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;

public class LegoBricks extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws ApplicationException
	{
		try {
			HttpSession session = request.getSession();
			Order order = LogicFacade.getOrderFromId(Integer.parseInt(request.getParameter("orderId")));
			PresentationFacade.calculateBricks( order ); //consider taking a builder
			session.setAttribute("order", order);
			return "specificOrderPage"; //can i make this more generic ?
		} catch (OrderSampleException ex) {
			throw new ApplicationException(ex);
		}

	}
}
