package jp.co.aforce.delete;

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
 * Servlet implementation class Delete
 */
@WebServlet("/jp.co.aforce.delete/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			//パラメータの取得
			String memberId=request.getParameter("member_id");
			
			//Productに格納
			Product product =new Product();
			product.setMember_id(memberId);
			
			//削除機能を持ったメソッド呼び出し
			ProductDao pd = new ProductDao();
			int deleteline =pd.deleteMember(product);
			
			if(deleteline>0) {
				request.getRequestDispatcher("/views/deleteSuccess.jsp").forward(request, response);
			}else {
				out.println("削除に失敗しました");
			}
			
		}catch(Exception e){
			
		}
		Page.footer(out);
	}

}
