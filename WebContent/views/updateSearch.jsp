<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>会員検索</h1>
<p>Member IDを入力してください。<p>
    <form method="post" action="../jp.co.aforce.search/searchmember">
    
        <label for="member_Id">Member ID:</label>
        <input type="text" id="member_Id" name="member_Id">
        <input type="submit" value="検索">
    </form>
    
    
</body>
</html>