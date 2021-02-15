<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>BookjuckBookjuck::Mypage</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">


<style>

</style>
</head>

<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->

	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- 마이페이지 -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
		<section class="mypagesection">
			<article>
			섹션입니다. 
			마이페이지(좌측sub메뉴) 사용하시는 분들은 이 소스 복사해서 여기에서 작업해주세요.
			</article>
		</section class="mypagesection">

	</div>
	
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	

</body>

</html>