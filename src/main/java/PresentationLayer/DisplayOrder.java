package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayOrder extends Command
{
	@Override String execute(HttpServletRequest request, HttpServletResponse response) throws ApplicationException
	{
		try {
			HttpSession session = request.getSession();
			session.setAttribute("orders", LogicFacade.showOrder() );
			return "orderpage"; //should this be more generic?
		}catch(OrderSampleException ose) {
			throw new ApplicationException(ose);
		}
	}
}
