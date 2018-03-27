package PresentationLayer;

import FunctionLayer.ApplicationException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSampleException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
		commands.put( "delegate", new Delegate() );
		commands.put( "createOrder", new CreateOrder() );
		commands.put( "displayOrder", new DisplayOrder() );
		commands.put( "specificOrderPage", new LegoBricks() );
		commands.put( "sendDate", new OrderTime() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws ApplicationException;

}
