import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		String to=request.getParameter("mail_by_forget");
		String sub="You get password forget link from Pritam Kushwah";
		String msg="Click below for change your password \n"+"http://localhost:8080/Web_login/ForgetPassword?mail="+to;
		
		Mailer.send(to, sub, msg);
		out.println("<h2>Link for password chenging is successfully send to your email...</h2>");
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
