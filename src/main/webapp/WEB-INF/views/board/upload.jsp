<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp"%>
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
		<h4 class="">자소서 작성</h4>
		<hr class="my-2">

		<form action="uploadProc" method="post" class="needs-validation"
			novalidate="">
			<div class="row g-3">
				<div class="col-12">
					<label for="address" class="form-label">지원 회사</label> <input
						type="text" name="company" class="form-control" id="address"
						placeholder="">
				</div>

				<div class="col-12">
					<label for="address" class="form-label">직무</label> <input
						type="text" name="job" class="form-control" id="address"
						placeholder="" required="">
				</div>


				<div class="col-sm-12">
					<label for="firstName" class="form-label">질문</label> <input
						type="text" name="question" class="form-control" id="firstName"
						placeholder="" value="" required>
					<div class="invalid-feedback">Valid first name is required.</div>
				</div>

				<div class="col-12 row-10">
					<label for="email" class="form-label">답변</label>
					<textarea name="content" class="form-control"
						id="exampleFormControlTextarea1" rows="5">
					</textarea>
					<div class="invalid-feedback">Please enter a valid email
						address for shipping updates.</div>
				</div>

				<div class="col-12 row-10">
					<label for="email" class="form-label">합격여부</label> <input
						type="text" name="result" class="form-control" id="email"
						placeholder="" required>
					<div class="invalid-feedback">Please enter a valid email
						address for shipping updates.</div>
				</div>

				<div class="col-12">
					<label for="email" class="form-label">공개 여부</label>
					<div class="form-check form-switch">
						<label class="form-check-label" for="flexSwitchCheckDefault">공개</label>
						<input name="open" class="form-check-input" type="checkbox"
							role="switch" id="flexSwitchCheckDefault">
					</div>
				</div>

				<div class="row w-70 my-4">
					<button onclick="location.href='board/main'"
						class="col btn btn-secondary btn-lg mx-1" type="button">취소</button>
					<button class="col btn btn-primary btn-lg mx-1" type="submit">저장</button>
				</div>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>