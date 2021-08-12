<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseNumber var ="totalPage" value="${bdCnt / 5}" integerOnly="true"/>
<c:if test="${(bdCnt % 5) >0}">
    <fmt:parseNumber var="totalPage" value="${totalPage+1}"/>
</c:if>


<fmt:parseNumber var="findCp" value="${(param.bno -1) / 5 }" integerOnly="true"/>
    <c:if test="${((param.bno -1)  % 5) > 0 }">
        <fmt:parseNumber var="findCp" value="${findCp + 1}"/>
    </c:if>

<fmt:parseNumber var="findCp" value="${totalPage - findCp}"/>

<html>

<head>
    <title>게시글 상세 페이지</title>
</head>
<link rel="stylesheet" href="/css/style.css">

<body>
<div class="main">
    <header>상세글 보기</header>
    <div class="container">
        <span><a href="/board?cp=${findCp}">나가기</a></span>
        <table>
            <tr><td>번호</td><td>${boardInfo.bno}</td></tr>
            <tr><td>제목</td><td>${boardInfo.title}</td></tr>
            <tr><td>작성자</td><td>${boardInfo.userid}</td></tr>
            <tr><td>작성일</td><td>${fn:substring(boardInfo.regdate,0,10)}</td></tr>
            <tr><td>내용</td><td>${boardInfo.contents}</td></tr>
        </table>

        <nav>
            <span class="<c:if test="${param.bno eq  1 }">disabled</c:if>"><a href="/board/view?bno=${param.bno-1}">이전글</a></span>
            <span class="<c:if test="${param.bno eq  bdCnt}">disabled</c:if>"><a href="/board/view?bno=${param.bno+1}">다음글</a></span>
        </nav>
    </div>
    <footer>Footer</footer>
</div>


</body>
</html>
