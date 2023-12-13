<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
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
	<div class="container d-flex align-items-center py-4 bg-body-tertiary">
		<div class="row g-5 m-auto">
			<div class="col-md-7 col-lg-8">
				<h4 class="mb-3">회원가입</h4>
				<form action="memberJoinProc" method="post" class="needs-validation"
					novalidate="">
					<div class="row g-3">

						<div class="col-12">
							<label for="address" class="form-label">이름</label> <input
								type="text" name="name" class="form-control" id="address"
								placeholder="" required="">
							<div class="invalid-feedback">Please enter your shipping
								address.</div>
						</div>

						<div class="col-sm-12">
							<label for="firstName" class="form-label">아이디</label><span
								class="h6 text-danger">* 필수 입력</span> <input type="text"
								name="id" class="form-control" id="firstName" placeholder=""
								value="" required="">
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>

						<div class="col-12">
							<label for="email" class="form-label">비밀번호</label><span
								class="h6 text-danger">* 필수 입력</span> <input type="password"
								name="pw" class="form-control" id="email" placeholder="">
							<div class="invalid-feedback">Please enter a valid email
								address for shipping updates.</div>
						</div>

						<div class="col-12">
							<label for="address" class="form-label">나이</label> <input
								type="number" name="age" class="form-control" id="address"
								placeholder="" required="">
							<div class="invalid-feedback">Please enter your shipping
								address.</div>
						</div>

						<button class="w-100 btn btn-primary btn-lg" type="submit">회원가입</button>
						<button onclick="location.href='../'" class="w-100 btn btn-secondary btn-lg" type="reset">취소</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>