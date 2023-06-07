<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登録が完了しました。</h1>
    <p>あなたのMember IDは<%= request.getAttribute("member_ID") %>です。</p>

  <a href="http://localhost:8080/MemberInfomation/views/menu.html#home">メインメニューへ</a>  
    
</body>
</html>