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
<body class="d-flex align-items-center py-4 bg-body-tertiary">

	<main class="container form-signin w-100 m-auto">
	
		<form action="loginProc" method="post">
			<img class="mb-4" width="70" height="70"
				src="../resources/image/icon.png" width="72" height="57" role="img"
				aria-label="Bootstrap" />
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

			<div class="form-floating">
				<input type="text" name="id" value="${cookie.saveId.value}"
					class="form-control" id="floatingInput" placeholder="Id"> <label
					for="floatingInput">Id</label>
			</div>
			<div class="form-floating">
				<input type="password" name="pw" class="form-control"
					id="floatingPassword" placeholder="Password"> <label
					for="floatingPassword">Password</label>
			</div>

			<div class="form-check text-start my-3">
				<input name="rememberId" class="form-check-input" type="checkbox"
					value="1" id="flexCheckDefault"> <label
					class="form-check-label" for="flexCheckDefault"> 아이디 저장 </label>
			</div>
			<button class="btn btn-primary w-100 py-2" type="submit">Sign
				in</button>
			<div class="mt-4 d-flex justify-content-center">
				<a href="memberJoin">회원가입 하러 가기</a>
			</div>
		</form>
	</main>
	<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>

</html>