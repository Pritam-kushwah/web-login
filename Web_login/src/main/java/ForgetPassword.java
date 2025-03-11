import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("mail");
		
		out.println("<h2>Forgot password</h2>");
		out.println("<form action='Forgot'>");
		out.println("<pre>");
		out.println("<input type='email' name='mail' value='"+email+"' readonly>");
		out.println("<input type='password' name='pwd' placeholder='Enter new password'>");
		out.println("<input type='password'placeholder='Confirm new password'>");
		out.println("<input type='submit' value='Update Password'>");
		out.println("</pre>");
		out.println("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
