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
    httpRequest = new XMLHttpRequest()
    httpRequest.open('GET', "/checklogin?userid="+userid.value,true)
    httpRequest.send()

    console.log(httpRequest);
    console.log(httpRequest.responseText);


    if(httpRequest == null) {
        console.log("null");
    }else {
        console.log("not null");
    }

    if(httpRequest.responseText > 0) {
        alert("아이디가 중복되었습니다.")
    }
})


