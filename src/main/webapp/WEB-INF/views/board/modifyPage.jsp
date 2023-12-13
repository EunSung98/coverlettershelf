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
	<div class="container bg-body-tertiary row g-5 m-auto col-md-7 col-lg-8">
		<jsp:include page="../header.jsp" />
		<h4 class="mb-3">자소서 수정</h4>
		<hr class="my-2">
		<form action="modifyPageProc?boardNum=${board.board_id}" method="post">
			<div class="row">

				<div class="form-group row my-1">
					<label for="inputCompany" class="col-2 col-form-label">지원회사</label>
					<div class="col">
						<input name="company" type="text" readonly class="form-control" value="${board.company}">
					</div>
				</div>
				<div class="form-group row my-1">
					<label for="inputJob" class="col-2 col-form-label">직무</label>
					<div class="col-sm-10">
						<input name="job" type="text" class="form-control" value="${board.job}">
					</div>
				</div>

				<c:forEach items="${qList}" var="questions">
					<div class="form-group row my-1">
						<label for="inputQuestion" class="col-2 col-form-label">질문</label>
						<div class="col-sm-10">
							<input name="question" type="text" class="form-control" value="${questions.question}">
						</div>
					</div>

					<div class="form-group row my-1">
						<label for="inputContent" class="col-2 col-form-label">답변</label>
						<div class="col-sm-10">
							<textarea name="content" class="form-control" rows="5">${questions.content}</textarea>
						</div>
					</div>
				</c:forEach>

				<div class="form-group row my-1">
					<label for="inputResult" class="col-2 col-form-label">합격여부</label>
					<div class="col-sm-10">
						<input name="result" type="text" class="form-control" value="${board.result}">
					</div>
				</div>

				<div class="form-group row my-1">
					<label for="inputOpen" class="col-2 col-form-label">공개
						여부</label>
					<div class="form-check form-switch col-sm-10">
						<input name="open" ${"on".equals(board.open) ? 'checked' : ''}
							class="form-check-input" type="checkbox" role="switch">
					</div>
				</div>
			</div>

			<div class="row w-70 my-2">
				<button onclick="location.href='myPage?boardNum=${board.board_id}'"
					class="col btn btn-secondary btn-lg mx-1" type="button">취소</button>
				<button class="col btn btn-primary btn-lg mx-1" type="submit">저장</button>
			</div>
		</form>

		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>