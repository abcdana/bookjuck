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
<link rel="stylesheet" href="/bookjuck/css/qcategory.css">

<style>

</style>
</head>

<body>

	<div class="container">

	<!-- 관리자페이지 헤더 좌측 메뉴 + 상단 로고 + 검색창 -->
	<%@include file="/WEB-INF/views/admin/inc/header.jsp" %>

	<section class="contentsection">
            <h3>자주 하는 질문<small>질문카테고리 관리</small></h3>
	            <table class="table tbl-md small" id="categorytbl">
	                <tr>
	                    <th colspan="2">현재 질문카테고리</th>
	                </tr>
	                <tr>
	                    <td>주문결제</td>
	                    <td>
	                        <div id="tblbtn">
	                            <button type="button" class="btn btn-general" data-toggle="modal" href="#editModal">수정</button>
	                            <button type="button" class="btn btn-general inline">삭제</button>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>수령일안내</td>
	                    <td>
	                        <div id="tblbtn">
	                            <button type="button" class="btn btn-general" data-toggle="modal" href="#editModal">수정</button>
	                            <button type="button" class="btn btn-general inline">삭제</button>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>반품</td>
	                    <td>
	                        <div id="tblbtn">
	                            <button type="button" class="btn btn-general" data-toggle="modal" href="#editModal">수정</button>
	                            <button type="button" class="btn btn-general inline">삭제</button>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>교환</td>
	                    <td>
	                        <div id="tblbtn">
	                        <button type="button" class="btn btn-general" data-toggle="modal" href="#editModal">수정</button>
	                        <button type="button" class="btn btn-general inline">삭제</button>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td>환불</td>
	                    <td>
	                        <div id="tblbtn">
	                        <button type="button" class="btn btn-general" data-toggle="modal" href="#editModal">수정</button>
	                        <button type="button" class="btn btn-general inline">삭제</button>
	                        </div>
	                    </td>
	                </tr>
	            </table>

            <!-- 질문카테고리가 너무 많아질 수도 있으므로 살려둘 것 -->
            <!-- <ul class="pagination">
                <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul> -->

            <div id="normalbtn">
                <button type="button" class="btn btn-general" data-toggle="modal" href="#addModal">추가하기</button>
                <button type="button" class="btn btn-general" id="back">뒤로가기</button>
            </div>
        </section>
	
	</div>
	
	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	
	
	<!-- 플로팅 메뉴 -->
	<%@include file="/WEB-INF/views/common/bookjuckee.jsp" %>
	<%@include file="/WEB-INF/views/common/top.jsp" %>

	<!-- Modal -->
    <div class="modal fade" id="addModal" role="dialog">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">질문카테고리 추가</h4>
                </div>
                <div class="modal-body">
                    <form method="POST" action="" id="form">
                        <p>추가할 질문카테고리를 입력해주세요.</p>
                        <input type="text" class="form-control large inline">
                        <input type="submit" class="btn btn-general inline" id="add" value="추가">
                    </form>
                </div>  
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
    </div>

	<!-- Modal -->
    <div class="modal fade" id="editModal" role="dialog">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">질문카테고리 수정</h4>
                </div>
                <div class="modal-body">
                    <form method="POST" action="" id="editform">
                        <p>수정할 질문카테고리를 입력해주세요.</p>
                        <input type="text" class="form-control large inline">
                        <input type="submit" class="btn btn-general inline" id="edit" value="수정">
                    </form>
                </div>  
            </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
        </div>
    </div>

</body>

</html>