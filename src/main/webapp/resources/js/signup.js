let form = document.querySelector(".signUpForm");
let signBtn = document.querySelector(".insertUser");
let pwd = document.querySelector(".pwd");
let rpwd = document.querySelector(".repwd");
let userid = document.querySelector(".userid");

signBtn.addEventListener("click", ()=> {


    if(pwd.value == rpwd.value ){
        form.setAttribute("method","post");
        form.setAttribute("action","/signup/sign");
        form.submit();
    }else {
        alert("비밀번호가 서로 다릅니다.")
    }

})

userid.addEventListener("blur", () => {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() { // 요청에 대한 콜백
        if (xhr.readyState === xhr.DONE) { // 요청이 완료되면
                if(xhr.responseText >0) {
                    alert("아이디가 중복되었습니다.")
                }
        }
    };
    xhr.open('GET', "/checklogin?userid=" + userid.value, true); // 메소드와 주소 설정
    xhr.send(); // 요청 전송

})


