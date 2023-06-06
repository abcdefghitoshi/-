package jp.co.aforce.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDao;

/**
 * Servlet implementation class SearchMember
 */
@WebServlet("/jp.co.aforce.search/searchmember")
public class SearchMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String member_Id = request.getParameter("member_Id");
			ProductDao searchDAO = new ProductDao();
			List<Product> memberList = searchDAO.searchMember(member_Id);

			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("/views/memberInfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
