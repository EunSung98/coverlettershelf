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

        <div class="row w-100 my-10 justify-content-between">
            <form action="publicSearch.do"
                class="d-flex justify-content-end col-9 row" role="search"
                method="get">
                <select name="type" class="form-select col" aria-label="Default select example">
                    <option value="" ${empty param.type ? 'selected' : ''}>검색항목</option>
                    <option value="company" ${param.type == 'company' ? 'selected' : ''}>회사</option>
                    <option value="job" ${param.type == 'job' ? 'selected' : ''}>직무</option>
                </select>

                <input name="keyword" class="form-control col" type="search"
                    placeholder="검색내용 입력" aria-label="Search" value="${param.keyword}">
                <button class="btn btn-outline-success col" type="submit">Search</button>
            </form>
        </div>

        <table class="table my-2">
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
                    <tr onclick="location.href='page?boardNum=${board.board_id}'">
                        <td scope="row">${board.company}</td>
                        <td scope="row">${board.job}</td>
                        <td scope="row">${board.result}</td>
                        <td scope="row">${board.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <jsp:include page="../footer.jsp" />
    </div>
</body>
</html>
