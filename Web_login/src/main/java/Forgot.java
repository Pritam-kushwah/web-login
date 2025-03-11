import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("mail");
		String pass=request.getParameter("pwd");
		Connection con=null;
		try
		{
		    con=MyConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update student set password=? where email=?");
			ps.setString(1, pass);
			ps.setString(2, email);
			ps.executeUpdate();
			out.println("<h2>....Password updated....</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			//con.close();
			//MyConnection.forClose();
		}
		catch(Exception e)
		{
			out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
