let form = document.querySelector(".signUpForm");
let signBtn = document.querySelector(".insertUser");
let pwd = document.querySelector(".pwd");
let rpwd = document.querySelector(".repwd");
let userid = document.querySelector(".userid");

let isOk = 0;

signBtn.addEventListener("click", ()=> {


    if(pwd.value == rpwd.value && isOk ==0 ){
        form.setAttribute("method","post");
        form.setAttribute("action","/signup/sign");
        form.submit();
    }else if(pwd.value != rpwd.value) {
        alert("비밀번호가 서로 다릅니다.");
    }else if(isOk == 1) {
        alert("아이디가 중복 되었습니다123");
    }

})

userid.addEventListener("blur", () => {

    fetch("/checkuser?userid=" + userid.value)
        .then( (response) => { return response.json() })
        .then( (result) => {
            if(result >0) {
                isOk =1;
                alert("아이디가 중복 되었습니다.1");
            }else if (result === 0) {
                isOk =0;
                alert("사용가능 아이디 입니다.");
            }
            return console.log(result)} );



})


