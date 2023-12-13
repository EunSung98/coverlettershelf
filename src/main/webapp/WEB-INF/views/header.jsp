<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 세션에서 id 값을 가져오기 --%>
<c:set var="id" value="${sessionScope.id}" />


<c:choose>
	<%-- [로그아웃] session 에 id 값 x --%>
    <c:when test="${empty id}">
        <header class="d-flex flex-wrap justify-content-md-between py-3 mb-4 border-bottom">
            <div class="col-md-3 mb-2 mb-md-0">
                <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
                    <img class="bi" width="40" height="32" src="resources/image/icon.png" width="40" height="40"
                         role="img" aria-label="Bootstrap" />
                </a>
            </div>

            <div class="col-md-3 justify-content-end">
                <button type="button" onclick="location.href='loginService/login.do'"
                        class="btn btn-outline-primary me-2">Login
                </button>
                <button type="button" onclick="location.href='loginService/memberJoin.do'"
                        class="btn btn-primary">Sign-up
                </button>
            </div>
        </header>
    </c:when>

 	<%-- session에 id (로그인된 상태) --%>
    <c:otherwise>
        <header
            class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <div class="col-md-3 mb-2 mb-md-0">
                <a href="../board/main.do"
                   class="d-inline-flex link-body-emphasis text-decoration-none">
                    <img class="bi" src="../resources/image/icon.png" width="40" height="40"
                         role="img" aria-label="Bootstrap" />
                </a>
            </div>

            <ul class="nav nav-masthead col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                <li><a href="../board/main" class="nav-link fw-bold px-2 active link-secondary">나의 자소서</a></li>
                <li><a href="../board/total" class="nav-link fw-bold px-2">전체 보기</a></li>
                <li><a href="../account/myAccount" class="nav-link fw-bold px-2">마이페이지</a></li>
            </ul>

            <form action="../loginService/logout" class="col-md-3 text-end">
                <span>${id}님</span>
                <button type="submit" onclick="location.href='../loginService/login.do'"
                        class="btn btn-outline-primary me-2">Logout
                </button>
            </form>
        </header>
    </c:otherwise>
</c:choose>
</body>
</html>