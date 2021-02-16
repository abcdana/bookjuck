<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>북적북적::환불 신청(무통장 입금)</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>

<link rel="stylesheet" href="/bookjuck/css/mypage.css">
<link rel="stylesheet" href="/bookjuck/css/global.css">

<link rel="stylesheet" href="/bookjuck/css/refund.css">

<style>

</style>
</head>

<body>



	<!-- 플로팅 메뉴 (북적이& top) -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>


	<div class="container">
	
		<!-- ########## 상단 헤더 시작 -->
		<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
		<!-- ########## 상단 헤더 끝 -->
	
	
		<!-- 마이페이지 side bar -->
		<%@include file="/WEB-INF/views/member/inc/mypage.jsp" %>
		
		
		
		
		<!-- @@@@@여기에 개인작업 페이지 넣을 것 -->
        <section class="contentsection">
            <article class="application-form">

                <h3>환불 신청<b> (무통장 입금)</b></h3>

                <table class="table tbl-md">
                    <tr style="background-color: RGBA(140,179,105,0.2)">
                        <th>주문번호</th>
                        <td><input type="text" class="form-control"></td>
                        <th>상품정보</th>
                        <td>
                            <select name="book-title" class="form-control">
                                <option value="">자바의 정석</option>
                            </select>
                        </td>
                        <th>수량</th>
                        <td>
                            <select name="book-amount" class="form-control">
                                <option value="">1</option>
                            </select>                            
                        </td>
                    </tr>
                    <tr>
                        <th>환불 사유</th>
                        <td colspan="5">
                            <select name="refund-reason" class="form-control">
                            <option value="단순 변심">단순 변심</option>
                            <option value="상품 하자">상품 하자</option>
                            <option value="상품 오배송">상품 오배송</option>
                            <option value="기타">기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>상세 사유</th>
                        <td colspan="5">
                            <textarea class="form-control" placeholder="사유를 자세히 적어주세요."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>회수지 정보</th>
                        <td colspan="5">
                            <textarea class="form-control" placeholder="주소를 입력하세요."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="3">환불 계좌</th>
                        <td colspan="5">
                            <textarea class="form-control" placeholder="예금주명을 입력하세요."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <select name="bank" class="form-control">
                                <option value="KB국민은행">KB국민은행</option>
                                <option value="우리은행">우리은행</option>
                                <option value="신한은행">신한은행</option>
                                <option value="하나은행">하나은행</option>
                                <option value="SC제일은행">SC제일은행</option>
                                <option value="한국씨티은행">한국씨티은행</option>
                                <option value="케이뱅크">케이뱅크</option>
                                <option value="카카오뱅크">카카오뱅크</option>
                                <option value="농협">농협</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <textarea class="form-control" placeholder="계좌번호를 입력하세요."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6"></td>
                    </tr>
                </table>

                <input type="button" class="btn btn-general" id="btnapply" value="신청하기">

            </article>




            <div class="refund-info">
                <h5>안내사항</h5>
                <ul>
                    <li>교환신청은 상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내 가능합니다.</li>
                    <li>변심반품의 경우 수령 후 7일 이내, 상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내 가능합니다.</li>
                    <li>오픈마켓, 기프트, 중고장터, 해외배송주문, 바로드림주문건은 <b>[1:1 상담]</b>으로 문의 바랍니다. <a href=""><input type="button" class="btn btn-xs btn-general" value="1:1 상담 문의"></a></li>
                    <li><b>반품처리 절차 : 반품신청 > 접수 > 반품회수 > 회수완료 > 반품완료</b></li>
                    <li><b>교환처리 절차 : 교환신청 > 접수 > 처리중 > 교환완료</b></li>
                    <li>반품/교환신청건은 접수 이전 상태에서 신청취소가 가능합니다.
                </ul>
            </div>
            
        </section>


		<!-- ########## 하단 시작 -->
		<%@include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- ########## 하단 끝 -->
		
	</div>
	
	

</body>

</html>