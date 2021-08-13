package org.imlsw96.board.service;

import org.imlsw96.board.dao.LoginDAO;
import org.imlsw96.board.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("usrv")
public class LoginServiceImpl  implements LoginService{

    @Autowired
    LoginDAO ldao;

    @Override
    public int insertUser(UserVO uvo) {
        return ldao.insertUser(uvo);
    }

    @Override
    public int checkUser(String userid) {
        return ldao.checkUser(userid);
    }

    @Override
    public boolean tryLogin(UserVO uvo, HttpSession sess) {
        boolean isLogin = false;

        if(ldao.tryLogin(uvo) >0) {
            isLogin = true;
            sess.setAttribute("userid", uvo.getUserid());
        }
        return isLogin;
    }
}
