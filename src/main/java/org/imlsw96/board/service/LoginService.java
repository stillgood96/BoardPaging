package org.imlsw96.board.service;

import org.imlsw96.board.vo.UserVO;

import javax.servlet.http.HttpSession;

public interface LoginService {

    int insertUser(UserVO uvo);
    int checkUser(String userid);
    boolean tryLogin(UserVO uvo, HttpSession sess);
}
