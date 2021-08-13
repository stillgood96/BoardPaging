let signUpBtn = document.querySelector(".signUp");
let signBtn = document.querySelector(".loginBtn");

let userIdVal = document.querySelector(".userid");
let pwdVal = document.querySelector(".password");

signUpBtn.addEventListener("click", () => {
        location.href="/signup";
})

signBtn.addEventListener("click", () => {

        fetch("/login", {
                method: "POST",
                headers: {
                        "Content-Type": "application/json",
                },
                body: JSON.stringify({
                        userid : userIdVal.value,
                        password : pwdVal.value,
                }),
        })
            .then((response) => response.json())
            .then((data) => console.log(data));
})
