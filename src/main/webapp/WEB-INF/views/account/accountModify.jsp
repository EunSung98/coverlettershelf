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
	<div class="container bg-body-tertiary">
		<jsp:include page="../header.jsp" />

		<main>
			<div class="row g-5">
				<div class="col-md-7 col-lg-8">
					<h4 class="mb-3">마이페이지</h4>
					<form action="myAccountModifyProc" method="post"
						class="row g-2 needs-validation">
						<div class="form-group row">
							<label for="userName" class="col-2 col-form-label">이름</label>
							<div class="col-sm-10">
								<input name="name" type="text" class="form-control"
									id="inputName" value="${user.name}">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword" class="col-2 col-form-label">아이디</label>
							<div class="col-sm-10">
								<input name="id" type="text" class="form-control"
									id="inputPassword" value="${user.id}">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword" class="col-2 col-form-label">비밀번호</label>
							<div class="col-sm-10">
								<input name="pw" type="password" class="form-control"
									id="inputPassword" value="${user.pw}">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword" class="col-2 col-form-label">나이</label>
							<div class="col-sm-10">
								<input name="age" type="text" class="form-control"
									id="inputPassword" value="${user.age}">
							</div>
						</div>
				</div>
				<button class="w-100 btn btn-outline-secondary" type="submit">회원정보
					수정</button>
				</form>
				<hr class="my-4">

			</div>
		</main>

		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>