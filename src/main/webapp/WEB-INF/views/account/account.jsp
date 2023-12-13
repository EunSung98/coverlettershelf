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
	<div class="container bg-body-tertiary">
		<jsp:include page="../header.jsp" />

		<div class="row">
			<h4 class="my-4 text-center">마이페이지</h4>
			<form action="myAccountModify" class="needs-validation" novalidate="">
				<div class="form-group row">
					<label for="staticEmail" class="col-2 col-form-label">이름</label>
					<div class="col">
						<input type="text" readonly class="form-control-plaintext"
							id="staticEmail" value="${user.name}" readonly>
					</div>
					<button class="col btn btn-outline-secondary" type="submit">회원정보
						수정</button>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-2 col-form-label">아이디</label>
					<div class="col-sm-10">
						<input type="text" class="form-control-plaintext"
							id="inputPassword" placeholder="Password" value="${user.id}" readonly>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-2 col-form-label">나이</label>
					<div class="col-sm-10">
						<input type="text" class="form-control-plaintext"
							id="inputPassword" placeholder="Password" value="${user.age}" readonly>
					</div>
				</div>
		</div>

		<hr class="my-4">

		<div class="my-4 d-grid gap-2 d-md-flex justify-content-md-end">
			<button class="w-50 btn btn-outline-danger" data-bs-toggle="modal"
				data-bs-target="#confirmModal" type="button">계정탈퇴</button>
		</div>
		</form>
	</div>

	<!-- 계정탈퇴 모달 창 -->
	<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">계정 탈퇴 확인</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>10일 이내에 로그인을 하면 계정 삭제가 취소됩니다.</p>
				</div>
				<form action="deleteMyAccount" class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">취소</button>
					<button type="submit" class="btn btn-danger"
						onclick="confirmDelete()">탈퇴하기</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../footer.jsp" />
	</div>
</body>

<script>
    function confirmDelete() {
        alert("계정이 탈퇴되었습니다.");
    }
</script>
</html>