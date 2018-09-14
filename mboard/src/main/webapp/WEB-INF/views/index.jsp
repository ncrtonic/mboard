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
<h1>회원 목록</h1>
<a href="regist"> 회원등록하기 </a>
	<table>
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>회원등록일</th>
			<th>회원수정일</th>
		</tr>
		<c:forEach items="${list}" var="memberVO">
			<tr>
	            <td>${memberVO.m_num}</td>
				<td>${memberVO.m_id}</td>
				<td>${memberVO.m_name}</td> 
				<td>${memberVO.regdate}</td>
				<td>${memberVO.updatedate}</td>
				<td><button onclick="del(${memberVO.m_num});">삭제</button></td>
			</tr>
		</c:forEach>
	</table>

	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li><a href="?page=${pageMaker.startPage -1}&perPageNum=5">&laquo;</a></li>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="idx">
			<c:choose>
				<c:when test="${pageMaker.cri.page == idx}">
				<li>${idx}</li>
				</c:when>
				<c:otherwise>
				<li><a href="?page=${idx}&perPageNum=5">${idx}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="?page=${pageMaker.startPage + 1}&perPageNum=5">&raquo;</a></li>
		</c:if>
	</ul>

</body>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	} else if(result =='FALSE') {
		alert("처리가 실패하였습니다.");
	}
	
	function del(num) {
		var cf = confirm('삭제 하시겠습니까?');
		if (cf == true) {
			location.href = 'delete?m_num='+num
		}
	}
</script>
</html>
