<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적_Admin::Welcome</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>


<link rel="stylesheet" href="/bookjuck/css/global.css">
<link rel="stylesheet" href="/bookjuck/css/curationletter.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
        <h3>큐레이션레터</h3>

        <div id="subtitle">상세조회</div>

        <div id="qbox">
            <h5>아주 조그만 보물 하나가 나를 찾아냈다. 그건 한 단어였다.아주 조그만 보물 하나가 나를 찾아냈다. 그건 한 단어였다.아주 조그만 보</h5>
            <p id="senddate">2021-02-07</p>
            <div>[기록된 단어들 사이, 자리를 잃은 존재들에 대하여] 〈옥스퍼드 영어 사전〉 편찬사를 바탕으로 한 소설. 이야기는 어린시절의 상당 부분을 사전 편집실에서 보낸 한 여자아이의 시선을 따라간다. 단어에 대한 아이의 질문은 이내 세계에 대한 의문으로 이어지며, 그 답을 찾는 여정 속에서, 마땅히 복원해야 할 사라진 이들의 역사가 되살아난다. -소설MD 박형욱</div>
            
        </div>

        <div id="btn">
            <input type="submit" class="btn btn-general inline" value="삭제하기" id="del">
            <button type="button" class="btn btn-general" id="back" onclick="location.href='/bookjuck/admin/curationletter/list.do'">뒤로가기</button>
        </div>
        
    </section>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	</div>
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/admin/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>



</body>

</html>