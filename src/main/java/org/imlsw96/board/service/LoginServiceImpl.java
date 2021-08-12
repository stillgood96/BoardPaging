package org.imlsw96.board.service;

import org.imlsw96.board.dao.LoginDAO;
import org.imlsw96.board.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usrv")
public class LoginServiceImpl  implements LoginService{

    @Autowired
    LoginDAO idao;

    @Override
    public int insertUser(UserVO uvo) {
        return idao.insertUser(uvo);
    }

    @Override
    public int checkUser(String userid) {
        return idao.checkUser(userid);
    }
}
