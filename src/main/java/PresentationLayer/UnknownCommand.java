package PresentationLayer;

import FunctionLayer.ApplicationException;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws ApplicationException {
        throw new ApplicationException(new LoginSampleException("Unknown command. Contact IT"));
    }

}
