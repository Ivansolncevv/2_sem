package dolgoigraushiy_project;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by Shmalman on 21.04.2017.
 */
public class ToDoServer {
    public static void main(String[] args) throws Exception {
        Server server= new Server(88);
        ServletContextHandler h= new ServletContextHandler();
        h.addServlet(ToDoServlet.class, "/");
        server.setHandler(h);
        server.start();
    }
}
