package ie.gmit.week04.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ie.gmit.week04.dao.SomeDao;
import ie.gmit.week04.model.SomeObject;

/**
 * Servlet implementation class ReadParameterServlet
 */
@WebServlet("/ReadParameterServlet")
public class ReadParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SomeDao dao = new SomeDao();
		String someText = request.getParameter("someText");
		
		int someNumber = Integer.parseInt(request.getParameter("someNumber"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat outputFormat = new SimpleDateFormat("dd/MM/yy");
		 Date someDate;
		try {
			someDate  = df.parse(request.getParameter("someDate"));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} 
		
		SomeObject someObject = new SomeObject(someText, someNumber, someDate);
		
		dao.create(someObject);
		
		Gson gson = new Gson();
		String outputJson = gson.toJson(dao.getAll());
		
		// TODO Auto-generated method stub
		response.getWriter().append(outputJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
