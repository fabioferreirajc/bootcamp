import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                Customer customer= new Customer();
                customer.setId(1);
                customer.setName("Fábio");
                customer.setEmail("fabioferreira@gmail.com");

                req.setAttribute("customer",customer);

                RequestDispatcher customerPageDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp");
                customerPageDispatcher.forward(req, resp);
        }
}
