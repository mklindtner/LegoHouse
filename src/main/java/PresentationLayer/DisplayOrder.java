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
			User u = (User) session.getAttribute("user");
			if(u == null)
				throw new LoginSampleException("no user detected");
			session.setAttribute("orders", LogicFacade.showOrder() );
			return "orderpage"; //should this be more generic?
		}catch(OrderSampleException | LoginSampleException ose) {
			throw new ApplicationException(ose);
		}
	}
}
