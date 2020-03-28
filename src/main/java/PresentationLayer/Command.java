package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("redirect", new Redirect());
        commands.put("logout", new Logout());
        commands.put("addCupcake", new AddCupcake());
        commands.put("removeCupcake", new RemoveCupcake());
        commands.put("createOrder", new CreateOrder());
    }

    static Command from(HttpServletRequest request) {
        String TargetName = request.getParameter("target");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(TargetName, new UnknownCommand());   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;
}
