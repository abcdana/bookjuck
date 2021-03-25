# 📚 BookjuckBookjuck
## 💛 Web Project _ Online Book Store :: BookjuckBookjuck _ Group 4
<br>

## 🗒️ 프로젝트 개요

- 관심 카테고리및 통계데이터를 통한 고객 맞춤형 서비스를 제공하는 온라인 서점 사이트를 구현한다.
- 도서 주문/구매 기능 이외에도 중고도서 거래, 실시간채팅 및 다양한 부가기능을 추가하였다.

<br>

## 🚩 프로젝트 기간 및 팀원

- 2021년 1월 28일 - 2021년 3월 2일 (총 32일)
- <b>김다은</b>, 김주혁, 오수경, 이현우, 조아라, 최진영 (6명)
 
<br>

## ⚙️ BookjuckBookjuck 기술 스택
<p align="center">
  <img src="https://img.shields.io/badge/Language-Java_8-007396?style=flat&logo=java&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Library-Bootstrap-563D7C?style=flat&logo=bootstrap">&nbsp 
  <img src="https://img.shields.io/badge/Language-JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Language-JSP-orange?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/Language-JSTL-green?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/Language-jquery-0769AD?style=flat&logo=jquery&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Database-Oracle-F80000?style=flat&logo=oracle&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Server-ApacheTomcat_8.5v-D22128?style=flat&logo=apahce&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/API-Daum우편번호-skyblue?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/API-배송정보-tomato?style=flat">&nbsp 
</p>

<br>

## 📷 BookjuckBookjuck ERD 
![BookjuckBookjuck ERD](https://user-images.githubusercontent.com/74163296/112273438-b3052380-8cc0-11eb-9019-ae7179ae7543.png)


<br>

## ✈️ BookjuckBookjuck 기능 소개
<center><img src="https://user-images.githubusercontent.com/74163296/112271356-2eb1a100-8cbe-11eb-8261-74b88059ce2d.png" width="75%"></center>
<br>


## 🔥 김다은 담당 업무
|    단계    |  담당업무                                              |
| :--------: | :----------------------------------------------------------- |
|  기획단계  | - 요구사항 분석, ERD 작성</br>- Script 작성</br>- 화면 설계</br>- 더미데이터 생성</br>- 데이터구조 정리</br>- 깃허브 프로젝트 세팅 |
|  구현단계  | - (사용자) 주문취소/환불/교환</br>- (사용자) 배송조회</br>- (사용자) 주문(상세)내역 조회</br>- (사용자) 중고게시판</br>- (관리자) 주문/배송내역 관리</br>- (관리자) 교환/취소/환불내역 관리 |
| 마무리단계 | - 테스트 및 에러 수정</br>- 본인 구현파트 화면캡처</br>- 프로젝트 최종요약본 작성 |
<br>

## 💻 담당 업무 구현 화면
### [관리자] 주문 관리 ###
<img src="https://user-images.githubusercontent.com/74163296/112452821-5fff9f00-8d9a-11eb-88c3-d6937f1e7024.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112452826-6130cc00-8d9a-11eb-8cfc-2b4787c0c403.PNG" width="48%">

**📷주문/배송 내역 조회 & 교환/취소/환불 내역 조회** 
- 주문내역(교환,취소,환불 통틀어)은 일반배송, 바로드림, E-Book탭을 나눠 각각 조회할 수 있다.
- 주문기간, 주문번호, 주문자ID, 상품명, 주문상태(교환/취소/환불의 경우)로 내역을 검색할 수 있다.

<img src="https://user-images.githubusercontent.com/74163296/112452827-6130cc00-8d9a-11eb-9a56-7c3cfde1ddd8.PNG" width="70%">

**📷주문 상세내역 조회** 
- 주문 목록조회 화면에서 주문번호를 클릭하면 상세내역을 조회 할 수 있다.
- 해당 주문의 주문상태, 취소/교환/환불 처리상태를 변경할 수 있으며, 관리자 권한의 주문휘소를 할 수 있다.

<img src="https://user-images.githubusercontent.com/74163296/112452829-61c96280-8d9a-11eb-81e3-296fe6b60412.PNG" width="32%"> <img src="https://user-images.githubusercontent.com/74163296/112452834-6261f900-8d9a-11eb-9360-37af7ec3a9a5.PNG" width="32%"> <img src="https://user-images.githubusercontent.com/74163296/112452835-6261f900-8d9a-11eb-946f-3d001671487e.PNG" width="32%">

**📷주문상태 수정, 처리상태 수정, 주문취소** 

---

### [사용자] 교환/환불/취소 및 배송조회 ###
<img src="https://user-images.githubusercontent.com/74163296/112454104-b15c5e00-8d9b-11eb-8c99-e23760f1d5ba.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112454113-b28d8b00-8d9b-11eb-867b-7a5b68747220.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112454111-b1f4f480-8d9b-11eb-985a-15198182a6f9.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112462032-f2f10700-8da3-11eb-8071-329981ada522.PNG" width="40%">

**📷주문 교환 & 주문 취소 & 주문 환불** 
- 교환/취소/환불 신청을 할 수 있으며, 사유는 기타를 선택하는 경우에만 상세사유를 작성할 수 있다.
- 회수지정보 등록 시 우편번호 검색을 통해 주소를 쉽게 입력할 수 있다. (다음 우편주소 API 사용)

<img src="https://user-images.githubusercontent.com/74163296/112462160-15832000-8da4-11eb-9dbe-e28eca799e8d.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112462155-1451f300-8da4-11eb-9ba6-15989d7b4f30.PNG" width="48%"> 

**📷교환/취소/환불 내역 조회 & 상세 내역 조회** 
- 교환/취소/환불 내역을 분류별 검색을 통해 조회 할 수 있다.
- 교환/취소/환불인 주문의 경우 주문 상세내역에서 해당 관련 정보를 확인할 수 있다.

<img src="https://user-images.githubusercontent.com/74163296/112462176-187e1080-8da4-11eb-96b7-89352e6a8bd8.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112462178-1916a700-8da4-11eb-9d4a-f87afdfd7850.PNG" width="48%">

**📷배송조회**
- 해당 도서 주문의 택배사 + 운송번호 정보를 통해 배송 조회를 할 수 있다. (배송조회 API 사용)

### [사용자] 중고도서 거래 게시판 ###
<img src="https://user-images.githubusercontent.com/74163296/112463166-4021a880-8da5-11eb-865c-e048b6801c37.PNG" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112463169-4152d580-8da5-11eb-8729-bd4a9b020068.PNG" width="48%">

**📷게시글 목록 조회**
- 사진이 게시글의 메인이 되는 중고게시판 특성상 썸네일형 게시판을 만들어 사용자들의 편의성을 높였다.
- 검색어를 통해 글쓴이id, 글제목, 글내용 검색이 가능하다.

<img src="https://user-images.githubusercontent.com/74163296/112463444-9b539b00-8da5-11eb-8315-5f46081b76e0.PNG" width="33%"> <img src="https://user-images.githubusercontent.com/74163296/112463446-9bec3180-8da5-11eb-9887-36ed9a698292.PNG" width="33%"> <img src="https://user-images.githubusercontent.com/74163296/112463449-9c84c800-8da5-11eb-8c5f-8de5af108d0d.PNG" width="33%">

**📷글 작성 & 수정 & 삭제하기**
- 게시글을 작성, 수정, 삭제할 수 있다.
- 이미지 파일을 업로드 할 경우 어떤 사진을 업로드 했는지 바로 확인할 수 있다.

<img src="https://user-images.githubusercontent.com/74163296/112463630-d48c0b00-8da5-11eb-935f-ae2161b5e2c4.PNG" width="63%"> <img src="https://user-images.githubusercontent.com/74163296/112463627-d3f37480-8da5-11eb-92f4-e5e840c3c8ea.PNG" width="35%"> 

**📷글 상세보기 & url복사**
- 게시글의 내용을 확인할 수 있다.
- 게시글에 댓글을 작성 또는 삭제할 수 있다.
- 게시글 작성자의 다른 게시물을 보고싶은 경우 더보기 버튼을 통해 해당 작성자의 다른 게시물 확인이 가능하다.
- url복사 버튼을 누르면 해당 글의 url이 클립보드에 복사된다.
- 게시글 작성자에게 mail보내기 버튼을 통해 거래의향이 있음을 알릴 수 있다.
<br>

## 📝 BookjuckBookjuck 프로젝트 후기
<p> 국비과정 중 진행하는 세번째 프로젝트로써 JSP, Servlet, Bootstrap, JQuery등 을 이용한 온라인 서점 "북적북적' 웹 페이지를 구현하는 프로젝트를 마쳤다. 지난 콘솔 프로젝트와는 확연하게 다른 볼륨감으로 기능 개발을 하는 내내 시간이 많이 모자라다 느꼈다. 초기 client 작업을 할 때까지만 해도 데이터 구조의 큰 결함을 찾지 못하다 server 작업 후반부에 데이터 구조가 잘못되었다는 것을 깨달았다. 제출기한이 당장 내일이었기 때문에 해당 기능 구현이 요구 명세와 완벽히 맞게 되지 않은 점이 아쉬워 제출 이후에 보완할 예정이다. Ajax를 프로젝트를 진행하면서 동시에 배워 많이 적용시켜보지 못한 점도 아쉬워 추가 기능 구현시 활용해 보도록 할 것이다.</p> 
<p> 또한, 지난 프로젝트들 보다 각 기능의 볼륨이 커져 큰 기능 하나를 공동작업 했는데 파트 분배를 이어받는식 보다는 병렬식으로 나눴어야 팀 작업을 더 원활하게 마칠 수 있었다는 것도 알게되었다. 기능 구현 후반부로 갈수록 초창기에 작업을 더욱 꼼꼼히 해 놓았으면 좋았을걸 하는 생각이 들었어서 다음 프로젝트는 기틀부터 단단하게 잡고 시작할 예정이다. 마지막으로, 비대면 수업이라 DB를 하나로 통일 시키지 못해 팀원별로 작동되는 기능의 범위가 달라져서 계정 연동을 통해 DB를 하나로 잡고 다음 프로젝트를 진행하면 좋을 것 같다는 생각이 들었다.</p>
<p> 개발하다 막힐 때나 오류가 날 때 팀내에서 서로서로 도와주어 무사히 이번 프로젝트를 마칠 수 있었다. 이번 프로젝트를 같이 진행하며 고생했던 모든 팀원분들에게 너무 고맙다.</p>

## 🔗 BookjuckBookjuck 깃허브 주소

👉🏻 [BookjuckBookjuck github](https://github.com/abcdana/bookjuck)


