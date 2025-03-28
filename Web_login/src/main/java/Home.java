
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("logout.html");
		rd.include(request, response);
		
		HttpSession hs=request.getSession(false);
		if(hs!=null)
		{
			String name=(String)hs.getAttribute("name");
		out.println("<h2>....Welcome Home....</h2><br>");
		out.println("<h2>Hello "+name+"</h2>");
		out.println("<a href='Profile'>Profile</a>");
		}
		else
		{
			out.println("<h2>Please login first</h2>");
			RequestDispatcher rd1=request.getRequestDispatcher("index.html");
			rd1.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
