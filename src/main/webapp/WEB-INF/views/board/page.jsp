<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div class="container bg-body-tertiary row g-5 m-auto">
		<div class="container col-md-7 col-lg-8 m-auto row g-5">
			<jsp:include page="../header.jsp" />
			<h4 class="mb-3">자소서</h4>
			<hr class="my-2">

			<form action="uploadProc" method="post" class="needs-validation">
				<div class="row g-3">


					<div class="form-group row">
						<label for="getCompany" class="col-2 col-form-label">지원회사</label>
						<div class="col">
							<input type="text" readonly class="form-control-plaintext"
								value="${board.company}">
						</div>
					</div>
					<div class="form-group row">
						<label for="getJob" class="col-2 col-form-label">직무</label>
						<div class="col-sm-10">
							<input type="text" readonly class="form-control-plaintext"
								value="${board.job}">
						</div>
					</div>

					<c:forEach items="${qList}" var="questions">
						<div class="form-group row">
							<label for="getQuestion" class="col-2 col-form-label">질문</label>
							<div class="col-sm-10">
								<input type="text" class="form-control-plaintext" readonly
									value="${questions.question}">
							</div>
						</div>

						<div class="form-group row">
							<label for="getContent" class="col-2 col-form-label">답변</label>
							<div class="col-sm-10">
								<textarea name="content" class="form-control-plaintext" readonly
									rows="5" readonly>${questions.content}</textarea>
							</div>
						</div>
					</c:forEach>

					<div class="form-group row my-1">
						<label for="getResult" class="col-2 col-form-label">합격여부</label>
						<div class="col-sm-10">
							<input name="result" type="text" readonly
								class="form-control-plaintext" value="${board.result}">
						</div>
					</div>

					<div class="form-group row">
						<label for="getOpen" class="col-2 col-form-label">공개 여부</label>
						<div class="form-check form-switch col-sm-10">
							<input name="open" ${"on".equals(board.open) ? 'checked' : ''}
								class="form-check-input" type="checkbox" role="switch" readonly>
						</div>
					</div>
				</div>


				<button onclick="location.href='total'"
					class="w-100 btn btn-outline-secondary btn-lg" type="button">돌아가기</button>
			</form>

			<jsp:include page="../footer.jsp" />
		</div>
</body>
</html>