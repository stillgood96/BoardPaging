<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>BoardPaging</title>
</head>
<link rel="stylesheet" href="/css/style.css">
<body>
<div class="main">
    <header>회원가입</header>

    <div class="container">
        <form class="signUpForm">
            <table>
                <tr><td>아이디</td><td><input type="text" class="userid" name="userid" placeholder="아이디"></td></tr>
                <tr><td>비밀번호</td><td><input type="password" class="pwd" name="password" placeholder="비밀번호"></td></tr>
                <tr><td>비밀번호 확인</td><td><input type="password" class="repwd" name="repassword" placeholder="다시입력"></td></tr>
            </table>
        </form>
        <span><button class="insertUser">회원가입하기</button></span>
    </div>
    <footer>Footer</footer>
</div>
</body>
<script src="js/signup.js"></script>
</html>
