package jp.co.aforce.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDao;
import jp.co.aforce.tool.Page;
@WebServlet("/jp.co.aforce.register/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Page.header(out);

        String lastName = request.getParameter("last_name");
        String firstName = request.getParameter("first_name");
        String sex = request.getParameter("sex");
        int birthYear = Integer.parseInt(request.getParameter("birth_year"));
        int birthMonth = Integer.parseInt(request.getParameter("birth_month"));
        int birthDay = Integer.parseInt(request.getParameter("birth_day"));
        String job = request.getParameter("job");
        String phoneNumber = request.getParameter("phone_number");
        String mailAddress = request.getParameter("mail_address");
        
        System.out.print(lastName+" ");
        System.out.println(firstName);
        System.out.println(sex);
        System.out.println(birthYear);
        System.out.println(birthMonth);
        System.out.println(birthDay);
        System.out.println(job);
        System.out.println(phoneNumber);
        System.out.println(mailAddress);
        
        
      //会員番号セット
        Product product = new Product();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String formattedDate = sdf.format(now);
        String member_id = ("A" +formattedDate );
        
        System.out.println(member_id);
        
     // Productクラスに入力値をセット
        product.setMember_id(member_id);
        product.setLast_name(lastName);
        product.setFirst_name(firstName);
        product.setSex(sex);
        product.setBirth_year(birthYear);
        product.setBirth_month(birthMonth);
        product.setBirth_day(birthDay);
        product.setJob(job);
        product.setPhone_number(phoneNumber);
        product.setMail_address(mailAddress);
        
        
        
        // フォームからの入力値を取得
        try { 

            // 会員の重複チェックを行う
            ProductDao pd=new ProductDao();
            int count = pd.countMember(product);
             
            
            
            if (count > 0) {
                out.println("すでに登録されています。");
                out.println("<br>");
                out.println("<a href=\"http://localhost:8080/MemberInfomation/views/register.jsp\">会員登録画面へ</a>");
                
            } else {
                // 登録機能を持つDAOをインスタンス化し、会員を登録する
                ProductDao insertDAO = new ProductDao();
                
                insertDAO.insertMember(product);
              
             // 画面遷移する
                String member_ID = product.getMember_id();
                request.setAttribute("member_ID", member_ID);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/registerSuccess.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();

		} finally {
            Page.footer(out);
            
        }
    }
}
