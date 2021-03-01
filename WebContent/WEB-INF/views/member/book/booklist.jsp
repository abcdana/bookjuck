<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::Welcome</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/global.css">

<!-- sidemenu.css -->
<link rel="stylesheet" href="/bookjuck/css/category.css">

<!-- booklist.css -->
<link rel="stylesheet" href="/bookjuck/css/booklist.css">

<!-- booklist.js -->
<script src="/bookjuck/js/booklist.js"></script>

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- ########## 상단 헤더 시작 -->
	<!-- 변경 전 -->
	<%-- <%@include file="/WEB-INF/views/member/inc/header.jsp" %> --%>

	<!-- 변경 후 -->
	<%
		out.flush();
		RequestDispatcher dheader = request.getRequestDispatcher("/member/inc/header.do");
		dheader.include(request, response);
	%>
	<!-- ########## 상단 헤더 끝 -->
	
	
	<!-- ########## 카테고리 사이드 메뉴 시작 -->
   	<%
		out.flush();
		RequestDispatcher dcategory = request.getRequestDispatcher("/member/inc/category.do");
		dcategory.include(request, response);
	%>
	<!-- ########## 카테고리 사이드 메뉴 끝 -->
	
	
	<!-- 섹션 -->
	<section class="contentsection">
		<table class="table">
			<thead>
				<c:forEach items="${sCategoryList}" var="scdto">
				<c:if test="${not empty seqSCategory}">
					<c:if test="${seqSCategory.equals(scdto.seqSCategory)}">
						<th colspan="3"><h6>${scdto.lCategory} > ${scdto.mCategory} > ${scdto.sCategory}</h6></th>
					</c:if>
				</c:if>
				</c:forEach>
				<c:forEach items="${mCategoryList}" var="mcdto">
				<c:if test="${empty seqSCategory}">
					<c:if test="${seqMCategory.equals(mcdto.seqMCategory)}">
						<th colspan="3"><h6>${mcdto.lCategory} > ${mcdto.mCategory}</h6></th>
					</c:if>
				</c:if>
				</c:forEach>
				
			</thead>
			<tbody>
				<c:if test="${blist.size() == 0}">
					<tr>
						<td colspan="3" style="text-align: center; padding-top: 50px;"><b style="font-size: 1.5em;">도서 목록이 없습니다.</b></td>
					</tr>
				</c:if>
			
				<c:forEach items="${blist}" var="dto">
				<tr>
					<td>
						<a href="/bookjuck/member/book/bookdetail.do?seqLCategory=${seqLCategory}&seqMCategory=${seqMCategory}&seqSCategory=${dto.seqSCategory}&seq=${dto.seq}">
							<img src="/bookjuck/image/book/${dto.image}" class="image">
						</a>
					</td>
					<td>
						<div><a href="/bookjuck/member/book/bookdetail.do?seqLCategory=${seqLCategory}&seqMCategory=${seqMCategory}&seqSCategory=${dto.seqSCategory}&seq=${dto.seq}" class="title">${dto.title}</a></div>
						<div class="info">${dto.author} | ${dto.publisher}</div>
						<div class="subinfo">${dto.pubDate} | ${dto.page}쪽</div>
						<div class="intro">${dto.summary}</div>
						<div class="priceinfo">
							<span class="price"><s>정가 ${String.format('%,d원', dto.price)}</s></span>
							<span class="saleprice">판매가 <strong>${String.format('%,d', dto.salePrice)}</strong>원</span>
						</div>
					</td>
					<td>
						<div class="form-inline amount">
							<input type="button" value="-" class="minus btn btn-default btn-sm">
							<input type="text" value="1" class="cnt form-control">
							<input type="button" value="+" class="plus btn btn-default btn-sm">
						</div>
						<div class="btns">
							<button class="btn btn-success btn-lg btn-block cart" onclick="fnCart()">장바구니</button>
							<button class="btn btn-primary btn-lg btn-block buy">바로구매</button>
							<button class="btn btn-warning btn-lg btn-block baro">바로드림</button>
						</div>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<!-- paging -->
		<c:if test="${not empty blist}">
		<nav class="pagebar">
			<ul class="pagination">${pagebar}
			</ul>
		</nav>
		</c:if>

	</section>


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/member/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<script>
	
	function fnCart() {
		var flag = confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?");
		if(flag){
			//장바구니로 이동
			
			
		} else {
			//현재 페이지에 남기
		}
	}

	</script>

</body>

</html>