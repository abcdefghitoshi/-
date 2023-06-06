<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="../jp.co.aforce.register/register" method="post"
		required="required">
		<h1>会員情報登録</h1>

		<p>・名前</p>
		姓<input type="text" name="last_name" required="required"> 名<input
			type="text" name="first_name" required="required">
		<p>・性別</p>
		<input type="radio" name="sex" value="男" required="required">男
		<input type="radio" name="sex" value="女">女
		<p>・生年月日
		<p>
			<select name="birth_year" required="required">
				<%for (int i = 1920; i <= 2020; i++) {%>
				<option value="<%=i%>"><%=i%></option>
				<%}%>
			</select>年 <select name="birth_month" required="required">
				<% for(int i=1 ; i <=12 ; i++ ){ %>
				<option value="<%=i %>"><%= i %></option>
				<%} %>
			</select>月 <select name="birth_day" required="required">
				<% for(int i=1 ; i<=31 ; i++){ %>
				<option value="<%=i %>"><%=i %></option>
				<% } %>
			</select>日
		<p>・電話番号</p>
		<input type="text" name="phone_number" required="required">

		<p>・メールアドレス</p>
		<input type="text" name="mail_address" required="required">

		<p>・職業</p>
		<select name="job" required="required">
			<option value="会社員">会社員</option>
			<option value="自営業">自営業</option>
			<option value="学生">学生</option>
			<option value="その他">その他</option>
		</select>


		<p>
			<input type="submit" value="登録"> <input type="reset"
				value="リセット">
		</p>
	</form>

	<form method="post" action="updateSearch.jsp">
		<button>登録情報の変更はこちらから</button>
	</form>
	</a>

</body>
</html>