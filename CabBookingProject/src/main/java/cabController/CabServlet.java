package cabController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cabModel.CabDAO;
@WebServlet("/bookinglink")
public class CabServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//fetch the value from html page
		int km = Integer.parseInt(req.getParameter("km"));
		int wtime = Integer.parseInt(req.getParameter("wtime"));
         String cabtype = req.getParameter("cabtype");
         
         //CREATE OBJECT OF MODEL CLASS
         CabDAO c = new CabDAO();
         
         int totalAmt=c.getTotalAmt(cabtype, km);
          int waiting_charge = c.getWaitingCharges(cabtype, wtime);
         int final_bill = totalAmt + waiting_charge;
         RequestDispatcher rd = req.getRequestDispatcher("cab.jsp");
         req.setAttribute("totalAmt", totalAmt);
         req.setAttribute("waiting_charge",waiting_charge);
         req.setAttribute("final_bill", final_bill);
        
         rd.forward(req, resp);
	
	
	}

}
