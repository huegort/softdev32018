package ie.gmit.week05.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.week05.dao.BookDao;
import ie.gmit.week05.model.Book;

/**
 * Servlet implementation class BookProcessCreate
 */
@WebServlet("/BookProcessCreate")
public class BookProcessCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookProcessCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		int price = Integer.parseInt(request.getParameter("price"));
		
		String datePublishedString = request.getParameter("datePublished");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate datePublished = LocalDate.parse(datePublishedString,formatter);
		
		
		Book b = new Book(isbn, datePublished,price);
		BookDao bookDao = new BookDao();
		
		bookDao.create(b);
		response.getWriter().append("Done ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
