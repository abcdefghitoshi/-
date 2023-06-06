package jp.co.aforce.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDao;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Update
 */
@WebServlet("/jp.co.aforce.update/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html; charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");

	        PrintWriter out = response.getWriter();
	        Page.header(out);

	        String memberID = request.getParameter("member_id");
	        String lastName = request.getParameter("last_name");
	        String firstName = request.getParameter("first_name");
	        String sex = request.getParameter("sex");
	        int birthYear = Integer.parseInt(request.getParameter("birth_year"));
	        int birthMonth = Integer.parseInt(request.getParameter("birth_month"));
	        int birthDay = Integer.parseInt(request.getParameter("birth_day"));
	        String job = request.getParameter("job");
	        String phoneNumber = request.getParameter("phone_number");
	        String mailAddress = request.getParameter("mail_address");

	        Product product = new Product();
	        product.setMember_id(memberID);
	        product.setLast_name(lastName);
	        product.setFirst_name(firstName);
	        product.setSex(sex);
	        product.setBirth_year(birthYear);
	        product.setBirth_month(birthMonth);
	        product.setBirth_day(birthDay);
	        product.setJob(job);
	        product.setPhone_number(phoneNumber);
	        product.setMail_address(mailAddress);

	        try {
	            ProductDao update = new ProductDao();
	            update.updateMember(product);

	            // 更新成功時の処理
	            out.println("更新完了しました");
	        } catch (Exception e) {
	            e.printStackTrace();
	           out.println("更新に失敗しました");
	        }
	}

}
