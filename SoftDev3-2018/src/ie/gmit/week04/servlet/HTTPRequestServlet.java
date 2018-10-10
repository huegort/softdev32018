package ie.gmit.week04.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTTPRequestServlet
 */
@WebServlet("/HTTPRequestServlet")
public class HTTPRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTTPRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> en = request.getHeaderNames();
		response.setContentType("text/html");
		response.getWriter().append("<html><body>");
		while (en.hasMoreElements()) {
			String headerName = en.nextElement();
			response.getWriter().append(headerName+" :"+ request.getHeader(headerName) +"<br/>");
			
		}
		try {
			for(Cookie cookie : request.getCookies()) {
				response.getWriter().append(cookie.getName()+"="+cookie.getValue()+"<br/>");
			}
		}catch (NullPointerException npe) {
			// log a info
			System.out.println("no cookies "+npe.getMessage());
		}
		String firstName = request.getParameter("firstName");
		response.getWriter().append("first name is "+firstName+"<br/>");
		
		response.getWriter().append("</body></html>");
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
