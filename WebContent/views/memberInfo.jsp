<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="jp.co.aforce.bean.Product"%>
<%@ page import="java.util.List"%>

<html>
<head>
<meta charset="UTF-8">
<title>会員検索結果</title>
</head>
<body>
	<h1>会員検索結果</h1>

		<form method="post" action="../jp.co.aforce.update/update">
			<%
			List<Product> memberList = (List<Product>) request.getAttribute("memberList");
			if (memberList != null && !memberList.isEmpty()) {
				for (Product member : memberList) {
			%>

			会員ID:
			<input name="member_id" value="<%=member.getMember_id()%>"><br>
			姓 :
			<input type="text" name="last_name"
				value="<%=member.getLast_name()%>"><br> 名:<input
				type="text" name="first_name" value="<%=member.getFirst_name()%>"><br>
			性別:
			<input type="radio" name="sex" value="男"
				<%if (member.getSex().equals("男")) {%> checked <%}%>> 男
			<input type="radio" name="sex" value="女"
				<%if (member.getSex().equals("女")) {%> checked <%}%>> 女<br>
			生年月日:
			<select name="birth_year" >
			 <%for (int i= 1920; i<=2020; i++) {%>
				<option value="<%=i%>" 
				<%if (i == member.getBirth_year()) {%>selected <%}%>><%=i%>
				</option><%}%>
			</select>
				 /
			<select name="birth_month">
		     <%for (int i = 1 ; i <= 12 ; i++) {%>
				 <option value="<%=i%>"
				 <%if(i == member.getBirth_month()){%>selected<%}%>><%=i%>
				 </option><%}%>
		    </select>
			     / 
			<select name="birth_day">
			     <%for(int i = 1 ; i <=31 ;i++){%>
			     <option value="<%=i%>"
			     <%if (i == member.getBirth_day()){%>selected<%}%>><%=i%>
			     </option><%} %>
			 </select>
			 <br>
			職業:<input type="text" name="job" value="<%=member.getJob()%>"><br>
			電話番号 :<input type="text" name="phone_number"
				value="<%=member.getPhone_number()%>"><br> メールアドレス:<input
				type="text" name="mail_address"
				value="<%=member.getMail_address()%>"><br>
			<p>
				<input type="submit" value="更新">
			<p>
		</form>

		<%
		}
		} else {
		%>
		<tr>
			<td colspan="8">該当する会員は見つかりませんでした。</td>
		</tr>
		<%
		}
		%>
		

	
	
</form>
<a href="http://localhost:8080/MemberInfomation/views/register.jsp">会員登録画面へ</a>
</body>
</html>