package org.imlsw96.board.controller;


import org.imlsw96.board.service.LoginService;
import org.imlsw96.board.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    LoginService isrv;

    @GetMapping("/signup")
    public String signUp() {

        return "signUp";
    }

    @PostMapping("/signup/sign")
    public String login(UserVO uvo) {
        isrv.insertUser(uvo);

        return "redirect:/board?cp=1";
    }

    @ResponseBody
    @GetMapping("/checklogin")
    public String checkUser(@RequestParam String userid) {
       String result = Integer.toString(isrv.checkUser(userid));

        return result;
    }

}
