<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
<title>회원리스트</title>
<style type="text/css">
body{
text-align: center;

}
table{
width: 60%;
margin: auto;
text-align: center;
}
ul li{
display: inline;
}
</style>
</head>
<body>
<form action="regist" method="post">
이름 : <input type="text" name="m_id" ><br>
아이디: <input type="text" name="m_name"><br>
<input type="submit" value="등록"/>
<input type="button" onclick="location.href='/mboard';" value="취소" />
</form>


</body>
</html>



