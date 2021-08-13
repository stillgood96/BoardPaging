package org.imlsw96.board.controller;


import org.imlsw96.board.service.LoginService;
import org.imlsw96.board.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService lsrv;

    @GetMapping("/signup")
    public String signUp() {

        return "signUp";
    }

    @PostMapping("/signup/sign")
    public String login(UserVO uvo) {
        lsrv.insertUser(uvo);

        return "redirect:/board?cp=1";
    }

    @ResponseBody
    @GetMapping("/checkuser")
    public String checkUser(@RequestParam String userid) {
       String result = Integer.toString(lsrv.checkUser(userid));

        return result;
    }

    @ResponseBody
    @GetMapping("/login")
    public String login(UserVO uvo, HttpSession sess) {

        lsrv.tryLogin(uvo, sess);

        return "redirect:/board?cp=1";
    }

}
