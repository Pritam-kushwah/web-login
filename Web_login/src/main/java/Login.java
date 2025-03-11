import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login()
    {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
		PrintWriter out=response.getWriter();//.append("Pritam: ").append(request.getContextPath());
		Connection con;
		try
		{
			con=MyConnection.getConnection();
			String mail=request.getParameter("mail");
			String password=request.getParameter("pass");
			PreparedStatement ps=con.prepareStatement("select*from student where email=? and binary password=?");
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String name=rs.getString("name");
				String id=rs.getString("id");
				String mobile=rs.getString("mobile");
				
				HttpSession hs=request.getSession(true);
				hs.setAttribute("id",id);
				hs.setAttribute("name",name);
				hs.setAttribute("mobile",mobile);
				hs.setAttribute("email",mail);
				
//				RequestDispatcher rd=request.getRequestDispatcher("Home");
//				rd.forward(request, response);
				response.sendRedirect("Home");
				con.close();
			}
			else
			{
				out.println("<h2>....Invalide email or password....</h2>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
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
