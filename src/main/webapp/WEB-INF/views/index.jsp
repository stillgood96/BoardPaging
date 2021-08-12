<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 문자를 다루기위함-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 숫자를 다루기위함 -->

<%--
DB query에서는 내림차순으로 데이터를 받아와서
나중에 작성된 글부터 받아오도록 해서 150개의 글중 150번째 글이 1번 글이되어 나타난다.
VIEW단에서는 원래 글번호를 링크해주어 상세보기를 해야해서  원래글 번호를 구하는 로직이 필요하다.
--%>
<fmt:parseNumber var="pp" value="5"/>
<fmt:parseNumber var="snum" value="${bdCnt - (cp-1) * pp}" integerOnly="true"/>


<%--네비게이션 구할때 쓰는 값--%>
<fmt:parseNumber var="pps" value="5"/>
<fmt:parseNumber var="sp" integerOnly="true" value="${((cp - 1) / pps)}"/>
<fmt:parseNumber var="sp" value="${sp * 5 +1}"/>
<fmt:parseNumber var="ep" value="${sp + 4}"/>

<fmt:parseNumber var="tp" value="${bdCnt / pp}" integerOnly="true"/>
<c:if test="${(bdCnt % pp) >0}">
    <fmt:parseNumber var="tp" value="${tp+1}"/>
</c:if>

<%--네비게이션 링크바 변수--%>
<c:set var="navlnk" value="/board?cp="/>


<html>
<head>
    <title>BoardPaging</title>
</head>
<link rel="stylesheet" href="/css/style.css">


<body>
<div class="main">
    <header>게시판</header>

    <div class="container">
        <div class="login">
            <form>
                <span>로그인</span>
                <table>
                    <tr><td>아이디</td><td><input type="text" nam="userid" placeholder="아이디"></td></tr>
                    <tr><td>비밀번호</td><td><input type="password" nam="password" placeholder="비밀번호"></td></tr>
                </table>
            </form>
            <span><button>로그인</button><button class="signUp">회원가입</button></span>
        </div>

        <table class="boardTable">
            <c:forEach var="b" items="${bdInfo}">
                <tr><!-- 유저작성글 -->
                    <td>${snum}</td>
                    <td><a href="/board/view?bno=${b.bno}&cp=${cp}">${b.title}</a></td>
                    <td>${b.userid}</td>
                    <td>${fn:substring(b.regdate,0,10)}</td>
                    <td>${b.thumbs}</td>
                    <td>${b.views}</td>
                </tr>
                <c:set var="snum" value="${snum - 1}"/>
            </c:forEach>
        </table>

        <div class="nav">
            <ul class="pageNavi">
                <li class="<c:if test="${sp lt 6}">disabled</c:if>">
                    <a href="${navlnk}${sp-5}" class="">이전</a></li>

                <c:forEach var="i" begin="${sp}" end="${ep}" step="1">
                    <c:if test="${i le tp}">
                        <c:if test="${i ne cp}">
                            <li class=""><a href="${navlnk}${i}" class="">${i}</a></li>
                        </c:if>

                        <c:if test="${i eq cp}">
                            <li class="active"><a href="/board?cp=${i}" class="">${i}</a></li>
                        </c:if>
                    </c:if>
                </c:forEach>
                <li class=" <c:if test="${ep gt tp}">disabled</c:if>">
                    <a href="${navlnk}${sp+5}" class="page-link">다음</a></li>
            </ul>
        </div>

    </div>
    <footer>Footer</footer>
</div>
</body>
<script src="/js/login.js"></script>
</html>
