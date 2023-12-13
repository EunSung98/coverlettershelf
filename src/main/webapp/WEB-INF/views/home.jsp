<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" errorPage="error.jsp"%>
<html>
<head>
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
	<!--첫 화면 -->
	<div class="container bg-body-tertiary">
	<jsp:include page="header.jsp" />
		
	<div class="px-4 py-5 my-5 text-center">
	    <img class="d-block mx-auto mb-4" src="resources/image/icon.png" alt="logo" width="72" height="72">
	    <h1 class="display-5 fw-bold text-body-emphasis">눈물의 자소서</h1>
	    <div class="col-lg-6 mx-auto">
	      <p class="lead mb-4">자기소개서 정리하기 힘든 취업, 이직 준비 중인 분들을 위한 서비스입니다.</p>
	      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
	        <button type="button" onclick="location.href='loginService/login.do'" class="btn btn-primary btn-lg px-4 gap-3">Login</button>
	        <button type="button" onclick="location.href='loginService/memberJoin.do'" class="btn btn-outline-secondary btn-lg px-4">Sign-up</button>
	      </div>
	    </div>
	  </div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">회사</th>
					<th scope="col">직무</th>
					<th scope="col">합격여부</th>
					<th scope="col">날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bList}" var="board">
					<tr onclick="location.href='myPage.do?num=${board.board_id}'">
						<td scope="row">${board.company}</td>
						<td scope="row">${board.job}</td>
						<td scope="row">${board.result}</td>
						<td scope="row">${board.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<jsp:include page="footer.jsp" />

	</div>

</body>
</html>
