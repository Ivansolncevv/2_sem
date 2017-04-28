package dolgoigraushiy_project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shmalman on 21.04.2017.
 */
public class ToDoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String what = req.getParameter("task");
        list.add(what);
        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder b= new StringBuilder();
        List<Item> items= list.view();
        for (Item i: items) {
            b.append("<li>"+i.text+"</li>\n");
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset = \"UTF-8\">\n" +
                "    <title> Список задач  </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method = \"post\">\n" +
                "    задача: <input name=\"task\">\n" +
                "    <input type= \"submit\"  value= \"Добавить\">\n" +
                "</form>\n" +
                "<ol>\n" +
                b+
                "</ol>\n" +
                "</body>\n" +
                "</html>");
    }
    private ToDoList list=new ToDoList();
    {
        list.add ("пример");
    }

}
