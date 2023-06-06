<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    
    <%@ page import="jp.co.aforce.bean.Product" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>会員検索結果</title>
</head>
<body>
    <h1>会員検索結果</h1>

    <table>

           <form method="post" action="../jp.co.aforce.update/update">
        <% List<Product> memberList = (List<Product>) request.getAttribute("memberList");
           if (memberList != null && !memberList.isEmpty()) {
               for (Product member : memberList) {
        %>
    
        会員ID:<input name="member_id" value="<%= member.getMember_id() %>" disabled><br>
           姓 :<input type="text" name="last_name" value="<%= member.getLast_name() %>"><br>
            名:<input type="text" name="first_name" value="<%= member.getFirst_name() %>"><br>
           性別:<input type="text" name="sex" value="<%= member.getSex() %>"><br>
            生年月日:<input type="text" name="birth_year" value="<%= member.getBirth_year()%>">/<input type="text" name="birth_month" value="<%= member.getBirth_month()%>"> / <input type="text" name="birth_day" value="<%=member.getBirth_day()%>"><br>
            職業:<input type="text" value="<%= member.getJob() %>"><br>
           電話番号 :<input type="text" name="phone_number" value="<%= member.getPhone_number() %>"><br>
            メールアドレス:<input type="text" name="mail_address" value="<%= member.getMail_address() %>"><br>
            <p><input type="submit" value="更新"><p>
         </form>
       
        <% } } else { %>
        <tr>
            <td colspan="8">該当する会員は見つかりませんでした。</td>
        </tr>
        <% } %>
    </table>
</body>
</html>