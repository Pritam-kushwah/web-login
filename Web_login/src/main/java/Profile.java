import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd= request.getRequestDispatcher("logout.html");
		rd.include(request, response);
		HttpSession hs=request.getSession(false);
		if(hs!=null)
		{
			String name=(String)hs.getAttribute("name");
		out.println("<h2>....Wellcome in your profile....</h2><br>");
		out.println("<h2>Hello "+name+"</h2>");
		}
		else
		{
			out.println("<h2>Please login first</h2>");
			RequestDispatcher rdis=request.getRequestDispatcher("index.html");
	        rdis.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
